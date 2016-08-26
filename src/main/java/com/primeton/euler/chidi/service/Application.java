/*******************************************************************************
 *
 *==============================================================================
 *
 * Copyright (c) 2001-2016 Primeton Technologies, Ltd.
 * All rights reserved.
 * 
 * Created on 2016年8月10日 上午10:32:21
 *******************************************************************************/

package com.primeton.euler.chidi.service;

import org.gocom.euler.specs.portal.capability.api.ProductInstanceApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.primeton.euler.msf.mock.MockServerSupport;

@SpringBootApplication
@ComponentScan("com.primeton.euler.chidi")
public class Application {

	public static void main(String[] args) {
		MockServerSupport.INSTANCE.register(ProductInstanceApi.class, "10.15.15.99:9006");
		SpringApplication.run(Application.class, args);
		System.out.println("=============================================================================");
		System.out.println("============================ euler-chidi startup ============================");
		System.out.println("=============================================================================");
	}

}
