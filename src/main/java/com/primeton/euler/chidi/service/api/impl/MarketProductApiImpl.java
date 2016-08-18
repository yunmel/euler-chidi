/**
 * Copyright (c) 2001-2016 Primeton Technologies, Ltd.
 * All rights reserved. 
 */
package com.primeton.euler.chidi.service.api.impl;

import org.gocom.euler.specs.portal.capability.api.ProductInstanceApi;
import org.gocom.euler.specs.portal.capability.api.StandardProductApi;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import com.primeton.euler.chidi.service.api.MarketProductApi;
import com.primeton.euler.chidi.service.model.ProductInstance;
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

	/* (non-Javadoc)
	 * @see com.primeton.euler.chidi.service.api.MarketProductApi#createProductInstance(com.primeton.euler.chidi.service.model.ProductInstance)
	 */
	@Override
	public String createProductInstance(ProductInstance instance) throws CapabilityException {
		
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
		
		return null;
	}

	/* (non-Javadoc)
	 * @see com.primeton.euler.chidi.service.api.MarketProductApi#destroyProductInstance(java.lang.String)
	 */
	@Override
	public void destroyProductInstance(String instanceId) throws CapabilityException {
	}

}
