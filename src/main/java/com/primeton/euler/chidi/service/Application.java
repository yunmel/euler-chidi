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

import org.springframework.boot.SpringApplication;

import com.primeton.euler.chidi.service.core.SampleController;

public class Application {

	public static void main(String[] args) {
		SpringApplication.run(SampleController.class, args);
	}

}
