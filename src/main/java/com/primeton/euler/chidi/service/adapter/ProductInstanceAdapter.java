/*******************************************************************************
 *
 *==============================================================================
 *
 * Copyright (c) 2001-2016 Primeton Technologies, Ltd.
 * All rights reserved.
 * 
 * Created on 2016年8月17日 下午3:06:27
 *******************************************************************************/

package com.primeton.euler.chidi.service.adapter;

import org.gocom.euler.specs.portal.capability.api.ProductInstanceApi;
import org.gocom.euler.specs.portal.exception.PortalCapabilityException;
import org.gocom.euler.specs.portal.model.ProductInstanceVO;

import com.primeton.euler.chidi.service.model.ProductInstance;
import com.primeton.euler.msf.api.MSFApi;

public class ProductInstanceAdapter {
	@MSFApi
	private ProductInstanceApi productInstanceApi;

	// 创建产品实例
	public String createProductInstance(ProductInstance productInstance, String tenantCode) {
		ProductInstanceVO instanceVO = ModelUtils.toInstanceVO(productInstance);
		try {
			productInstanceApi.createProductInstance(instanceVO, tenantCode);
		} catch (PortalCapabilityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	// 删除产品实例
	public boolean deleteProductInstance(String instanceId) {
		try {
			return productInstanceApi.deleteProductInstanceById(instanceId);
		} catch (PortalCapabilityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	// 查看产品实例
	public ProductInstance queryProductInstanceById(String tenantCode, String instanceId) {
		try {
			ProductInstanceVO vo = productInstanceApi.queryProductInstanceById(tenantCode, instanceId);
			return ModelUtils.toInstance(vo);
		} catch (PortalCapabilityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
