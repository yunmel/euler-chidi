/*******************************************************************************
 *
 *==============================================================================
 *
 * Copyright (c) 2001-2016 Primeton Technologies, Ltd.
 * All rights reserved.
 * 
 * Created on 2016年8月17日 下午5:58:31
 *******************************************************************************/

package com.primeton.euler.chidi.service.adapter;

import org.gocom.euler.specs.portal.model.ProductInstanceVO;

import com.primeton.euler.chidi.service.model.ProductInstance;

public class ModelUtils {
	public static ProductInstanceVO toInstanceVO(ProductInstance instance) {
		ProductInstanceVO vo = new ProductInstanceVO();
		return vo;
	}
	
	public static ProductInstance toInstance(ProductInstanceVO vo) {
		ProductInstance instance = new ProductInstance();
		return instance;
	}
}
