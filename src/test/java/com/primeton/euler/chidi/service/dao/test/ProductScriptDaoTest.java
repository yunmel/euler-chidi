/*******************************************************************************
 *
 *==============================================================================
 *
 * Copyright (c) 2001-2016 Primeton Technologies, Ltd.
 * All rights reserved.
 * 
 * Created on 2016年8月25日 上午11:14:31
 *******************************************************************************/

package com.primeton.euler.chidi.service.dao.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.primeton.euler.chidi.service.Application;
import com.primeton.euler.chidi.service.dao.ProductScriptDao;
import com.primeton.euler.chidi.service.model.ProductScript;

/**
 * 
 * TODO 此处填写 class 信息
 *
 * @author tianxh (mailto:tianxh@primeton.com)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@Rollback(false) // true 清空测试数据
@Transactional
public class ProductScriptDaoTest {
	@Autowired
	private ProductScriptDao scriptDao;

	@Test
	public void testQuery() {
		ProductScript script = scriptDao.queryById("1");
		System.out.println(script.getScriptContent());
	}
}
