/**
 * Copyright (c) 2001-2016 Primeton Technologies, Ltd.
 * All rights reserved. 
 */
package com.primeton.euler.chidi.service.api.impl;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.gocom.euler.specs.portal.capability.api.ProductInstanceApi;
import org.gocom.euler.specs.portal.capability.api.StandardProductApi;
import org.gocom.euler.specs.portal.exception.PortalCapabilityException;
import org.gocom.euler.specs.portal.model.CompSpecVO;
import org.gocom.euler.specs.portal.model.InstanceResourceVO;
import org.gocom.euler.specs.portal.model.ProductInstanceAttrVO;
import org.gocom.euler.specs.portal.model.ProductInstanceVO;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import com.alibaba.fastjson.JSON;
import com.primeton.euler.cbc.log.LoggerFactory;
import com.primeton.euler.chidi.service.api.MarketProductApi;
import com.primeton.euler.chidi.service.dao.CustomProductInstInfoDao;
import com.primeton.euler.chidi.service.dao.ProductScriptDao;
import com.primeton.euler.chidi.service.model.CustomProductInstInfo;
import com.primeton.euler.chidi.service.model.ProductScript;
import com.primeton.euler.chidi.service.model.preset.CustomProductInstance;
import com.primeton.euler.chidi.service.model.preset.MySQLProductInstance;
import com.primeton.euler.chidi.service.util.DbUtils;
import com.primeton.euler.msf.api.MSFApi;
import com.primeton.euler.specs.devops.exception.CapabilityException;

/**
 * @author ZhongWen Li (mailto:lizw@primeton.com)
 *
 */
@Service
//@Scope(WebApplicationContext.SCOPE_REQUEST)
public class MarketProductApiImpl implements MarketProductApi {
	private static final Logger logger = LoggerFactory.getTraceLogger(MarketProductApiImpl.class);
	
	// 市场产品发布（创建标准/自定义产品，查询产品）
	@MSFApi
	private StandardProductApi standardProductApi;
	
	// 市场产品部署 （创建产品实例，查询产品实例）
	@MSFApi
	private ProductInstanceApi productInstanceApi;
	
	@Autowired
	private ProductScriptDao scriptDao;
	
	@Autowired
	private CustomProductInstInfoDao instInfoDao;

	@Override
	public String createProductInstance(String standardProductId, String tenantCode) throws CapabilityException {
//		String productId = createInstance.getStandardProductId();
//		String tenantCode = createInstance.getTenantCode();
		logger.info(">>>> productId: " + standardProductId + ", tenantCode: " + tenantCode);
		
		// 部署数据库实例
		MySQLProductInstance mysqInfo = MySQLProductInstance.getDefaultMySQLInstance(); // 默认从文件读取
		ProductInstanceVO mysqlInstance = createMySQLProductInstance(mysqInfo, tenantCode);
		
		// 
		for (;;) {
			logger.info(">>>> query mysql instance [" + mysqlInstance.getId() + "] status");
			ProductInstanceVO createdMysqlInstance = viewProductInstance(mysqlInstance.getId(), tenantCode);
			/**
			 * 1 正在创建 2 创建失败 3 正在运行 4 停止 5 删除失败
			 */
			if (createdMysqlInstance.getStatusId().equals("3")) {
				mysqlInstance = createdMysqlInstance;
				logger.info(">>>> mysql instance [" + mysqlInstance.getId() + "] is running");
				break;
			}
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		List<InstanceResourceVO>  mysqlInstanceResources = mysqlInstance.getProductInstanceResources();
		InstanceResourceVO mysqlResource = mysqlInstanceResources.get(0);

		String userName = "root";
		String password = MySQLProductInstance.getRootPassword();
		String dbName = "test";
		String publicUrl = mysqlResource.getNetUrl();
		String dbUrl = mysqlResource.getPublicIp() + ":" + publicUrl.split(":")[1];
		logger.info(">>>> userName: " + userName + ", password: " + password + ", dbName: " + dbName + ", dbUrl: " + dbUrl);

		// 创建数据库，初始化数据库
//		DbUtils.createMySQLDataBase(DbUtils.generateUrl(dbUrl, ""), userName, password, dbName);
		ProductScript script = scriptDao.queryByProductId(standardProductId);
		String scriptFilePath = script.getScriptPath()+File.separator+script.getScriptName();
		logger.info(">>>> scriptFilePath: "+scriptFilePath);
		DbUtils.executeMySQLScript(DbUtils.generateUrl(dbUrl, dbName), userName, password, scriptFilePath);

		// 自定义产品配置注入, db url, userName, password
		CustomProductInstance customInstInfo = CustomProductInstance.getDefaultCustomProductInstance();
		List<CompSpecVO> compSpecList = customInstInfo.getCompSpecs();
		List<ProductInstanceAttrVO>  instanceAttrs = customInstInfo.getProductInstanceAttrs();
		for (ProductInstanceAttrVO instanceAttr : instanceAttrs) {
			if (instanceAttr.getAttrKey().equals("db.url")) {
				instanceAttr.setAttrValue(DbUtils.generateUrl(dbUrl, dbName));
				continue;
			}
			if (instanceAttr.getAttrKey().equals("db.user")) {
				instanceAttr.setAttrValue(userName);
				continue;
			}
			if (instanceAttr.getAttrKey().equals("db.password")) {
				instanceAttr.setAttrValue(userName);
				continue;
			}
//			if (instanceAttr.getAttrKey().equals("home.title")) {
//				instanceAttr.setAttrValue("销售统计");
//				continue;
//			}
		}
		
		// 部署自定义产品实例
		ProductInstanceVO customProductInstance = createCustomProductInstance(customInstInfo, tenantCode);
		
		// 记录产品和数据库关联信息
		CustomProductInstInfo createdInstanceInfo = new CustomProductInstInfo();
		createdInstanceInfo.setInstcnceId(customProductInstance.getId());
		Map<String, String> dependentInstInfo = new HashMap<String, String>();
		dependentInstInfo.put("instanceId", mysqlInstance.getId());
		dependentInstInfo.put("productCode", mysqlInstance.getProductCode());
		createdInstanceInfo.setDependentInstanceInfo(JSON.toJSONString(dependentInstInfo));
		instInfoDao.insert(createdInstanceInfo);
		logger.info(">>>> instanceId: " + customProductInstance.getId());
		return customProductInstance.getId();
	}

	@Override
	public void destroyProductInstance(String instanceId, String tenantCode) throws CapabilityException {
		CustomProductInstInfo instInfo = instInfoDao.queryById(instanceId);
		String dependInfo = instInfo.getDependentInstanceInfo();
		String dependInstId = ""; 
		if (!StringUtils.isBlank(dependInfo)) {
			JSON.parseObject(dependInfo, Map.class);
			dependInstId = (String) JSON.parseObject(dependInfo, Map.class).get(instanceId);
		}
		productInstanceApi.deleteProductInstanceById(tenantCode, instanceId);
		productInstanceApi.deleteProductInstanceById(tenantCode, dependInstId);
	}

	@Override
	public ProductInstanceVO viewProductInstance(String instanceId, String tenantCode) throws CapabilityException {
		ProductInstanceVO productInstance = productInstanceApi.queryProductInstanceById(tenantCode, instanceId);
		return productInstance;
	}
	
	private ProductInstanceVO createMySQLProductInstance(MySQLProductInstance mysqInfo, String tenantCode) {
		ProductInstanceVO mysqlInstance = null;
		try {
			mysqInfo.setTenantCode(tenantCode);
			mysqlInstance = productInstanceApi.createProductInstance(mysqInfo, tenantCode);
			return mysqlInstance;
		} catch (PortalCapabilityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private ProductInstanceVO createCustomProductInstance(ProductInstanceVO instance, String tenantCode) {
		ProductInstanceVO customInstance = null;
		try {
			customInstance = productInstanceApi.createProductInstance(instance, tenantCode);
			return customInstance;
		} catch (PortalCapabilityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
