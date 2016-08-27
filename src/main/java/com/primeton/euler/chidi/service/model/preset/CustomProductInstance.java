/*******************************************************************************
 *
 *==============================================================================
 *
 * Copyright (c) 2001-2016 Primeton Technologies, Ltd.
 * All rights reserved.
 * 
 * Created on 2016年8月23日 上午11:30:24
 *******************************************************************************/

package com.primeton.euler.chidi.service.model.preset;

import java.io.InputStream;
import java.util.Scanner;

import org.gocom.euler.specs.portal.model.ProductInstanceVO;

import com.alibaba.fastjson.JSON;

public class CustomProductInstance extends ProductInstanceVO {
	/**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 1L;

	public CustomProductInstance() {
		
	}
	
	public static CustomProductInstance getDefaultCustomProductInstance() {
		InputStream is = CustomProductInstance.class.getResourceAsStream("CustomProductInstance.json");
		String productInstance = new Scanner(is, "UTF-8").useDelimiter("\\a").next();
		CustomProductInstance instance = JSON.parseObject(productInstance, CustomProductInstance.class);
		return instance;
	}
	
	public static void main(String[] args) {
		CustomProductInstance instance = CustomProductInstance.getDefaultCustomProductInstance();
		System.out.println(instance);
	}
}
