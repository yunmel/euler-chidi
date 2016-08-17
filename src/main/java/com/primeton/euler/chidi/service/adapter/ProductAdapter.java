/*******************************************************************************
 *
 *==============================================================================
 *
 * Copyright (c) 2001-2016 Primeton Technologies, Ltd.
 * All rights reserved.
 * 
 * Created on 2016年8月17日 下午3:04:56
 *******************************************************************************/

package com.primeton.euler.chidi.service.adapter;

import org.gocom.euler.specs.portal.capability.api.StandardProductApi;

import com.primeton.euler.chidi.service.model.Product;
import com.primeton.euler.msf.api.MSFApi;

public class ProductAdapter {
	@MSFApi
	private StandardProductApi standardProductApi;

	// 发布产品
	public String createStandardProduct(Product product) {
		
		return "";
	}

	// 删除/下线产品
	public String offLineStandardProduct(String productId) {
		
		return "";
	}

	// 查看产品
	public Product queryProductById(String productId) {
		
		return null;
	}
}
