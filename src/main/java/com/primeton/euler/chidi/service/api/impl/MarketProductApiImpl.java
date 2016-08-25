/**
 * Copyright (c) 2001-2016 Primeton Technologies, Ltd.
 * All rights reserved. 
 */
package com.primeton.euler.chidi.service.api.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.gocom.euler.specs.portal.capability.api.ProductInstanceApi;
import org.gocom.euler.specs.portal.capability.api.StandardProductApi;
import org.gocom.euler.specs.portal.exception.PortalCapabilityException;
import org.gocom.euler.specs.portal.model.InstanceResourceVO;
import org.gocom.euler.specs.portal.model.ProductInstanceVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import com.alibaba.fastjson.JSON;
import com.primeton.euler.chidi.service.api.MarketProductApi;
import com.primeton.euler.chidi.service.dao.CustomProductInstInfoDao;
import com.primeton.euler.chidi.service.dao.ProductScriptDao;
import com.primeton.euler.chidi.service.model.CustomProductInstInfo;
import com.primeton.euler.chidi.service.model.ProductScript;
import com.primeton.euler.chidi.service.model.preset.MySQLProductInstance;
import com.primeton.euler.chidi.service.util.DbUtils;
import com.primeton.euler.msf.api.MSFApi;
import com.primeton.euler.specs.devops.exception.CapabilityException;

/**
 * @author ZhongWen Li (mailto:lizw@primeton.com)
 *
 */
@Service
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class MarketProductApiImpl implements MarketProductApi {
	
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
	public String createProductInstance(ProductInstanceVO instance, String tenantCode) throws CapabilityException {
		
		// 获取产品信息
		
		// 如果产品需要使用MySQL数据库
		
		// 获取依赖产品MySQL信息
		
		// 使用默认配置部署MySQL数据库
		
		// 获取部署结果——MySQL实例信息
		
		// 获取产品数据库脚本
		
		// 执行数据库初始化操作
		
		// 根据MySQL实例信息生成产品运行期配置数据（运行期配置注入）
		
		// 部署产品自身
		
		// 获取部署结果
		
		String customProductId = instance.getStandardProductId();
		
		// 部署数据库实例
		MySQLProductInstance mysqInfo = MySQLProductInstance.getDefaultMySQLInstance(); // 默认从文件读取
		mysqInfo.setTenantCode(tenantCode);
		ProductInstanceVO mysqlInstance = createMySQLProductInstance(mysqInfo, tenantCode);
		
		// 
		for (;;) {
			ProductInstanceVO createdMysqlInstance = viewProductInstance(mysqlInstance.getId(), tenantCode);
			/**
			 * 1 正在创建 2 创建失败 3 正在运行 4 停止 5 删除失败
			 */
			if (createdMysqlInstance.getStatusId().equals("3")) {
				mysqlInstance = createdMysqlInstance;
				break;
			}
		}
		
		List<InstanceResourceVO>  mysqlInstanceResources = mysqlInstance.getProductInstanceResources();
		InstanceResourceVO mysqlResource = mysqlInstanceResources.get(0);

		String userName = "root";
		String password = mysqInfo.getRootPassword();
		String dbName = instance.getProductCode();
		String netUrl = mysqlResource.getNetUrl();

		// 创建数据库，初始化数据库
		DbUtils.createMySQLDataBase(DbUtils.generateUrl(netUrl, ""), userName, password, dbName);
		ProductScript script = scriptDao.queryByProductId(customProductId);
		String scriptContent = script.getScriptContent();
		DbUtils.executeMySQLScript(DbUtils.generateUrl(netUrl, dbName), userName, password, scriptContent);

		// TODO 自定义产品配置注入
		
		// 部署自定义产品实例
		ProductInstanceVO customProductInstance = createCustomProductInstance(instance, tenantCode);
		
		// 记录产品和数据库关联信息
		CustomProductInstInfo info = new CustomProductInstInfo();
		info.setInstcnceId(customProductInstance.getId());
		Map<String, String> dependentInstInfo = new HashMap<String, String>();
		dependentInstInfo.put("instanceId", mysqlInstance.getId());
		dependentInstInfo.put("productCode", mysqlInstance.getProductCode());
		info.setDependentInstanceInfo(JSON.toJSONString(dependentInstInfo));
		instInfoDao.insert(info);
		
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
	
	private ProductInstanceVO createMySQLProductInstance(ProductInstanceVO instance, String tenantCode) {
		ProductInstanceVO mysqlInstance = null;
		try {
			mysqlInstance = productInstanceApi.createProductInstance(instance, tenantCode);
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
