/*******************************************************************************
 *
 *==============================================================================
 *
 * Copyright (c) 2001-2016 Primeton Technologies, Ltd.
 * All rights reserved.
 * 
 * Created on 2016年8月25日 下午5:32:07
 *******************************************************************************/

package com.primeton.euler.chidi.service.api.test;

import org.gocom.euler.specs.portal.model.ProductInstanceVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextBeforeModesTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;

import com.primeton.euler.chidi.service.Application;
import com.primeton.euler.chidi.service.api.MarketProductApi;
import com.primeton.euler.specs.devops.exception.CapabilityException;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@TestExecutionListeners({
    DirtiesContextBeforeModesTestExecutionListener.class,
    DependencyInjectionTestExecutionListener.class,
    DirtiesContextTestExecutionListener.class,
    WebContextTestExecutionListener.class
})
public class MarketProductApiTest {
	@Autowired
	private MarketProductApi productApi;

	@Test
	public void testCreateCustomProduct() {

	}

	@Test
	public void testViewProductInstance() throws CapabilityException {
		String instanceId = "43701f80-5a6e-4fd3-8bf2-9570a6324b3f";
		String tenantCode = "tenant-tianxh";
		ProductInstanceVO instance = productApi.viewProductInstance(instanceId, tenantCode);
		System.out.println(">>>> instance: " + instance);
	}
}
