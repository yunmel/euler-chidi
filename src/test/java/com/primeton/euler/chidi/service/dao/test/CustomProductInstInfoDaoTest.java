/*******************************************************************************
 *
 *==============================================================================
 *
 * Copyright (c) 2001-2016 Primeton Technologies, Ltd.
 * All rights reserved.
 * 
 * Created on 2016年8月24日 下午6:43:38
 *******************************************************************************/

package com.primeton.euler.chidi.service.dao.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.primeton.euler.chidi.service.Application;
import com.primeton.euler.chidi.service.dao.CustomProductInstInfoDao;
import com.primeton.euler.chidi.service.model.CustomProductInstInfo;

/**
 * 
 * CustomProductInstInfoDao TestCase
 *
 * @author tianxh (mailto:tianxh@primeton.com)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@Rollback(true)// true 清空测试数据
@Transactional
public class CustomProductInstInfoDaoTest {
	@Autowired
	CustomProductInstInfoDao instInfoDao;

	@Test
	public void testInsertAndQuery() {
		CustomProductInstInfo instInfo = generateInstInfo();
		instInfoDao.insert(instInfo);
		
		CustomProductInstInfo created = instInfoDao.queryById(instInfo.getInstcnceId());
		Assert.assertEquals(instInfo.getInstcnceId(), created.getInstcnceId());
		Assert.assertEquals(instInfo.getDependentInstanceInfo(), created.getDependentInstanceInfo());
	}

	@Test
	public void testUpdate() {
		
	}

	@Test
	public void testDelete() {
		CustomProductInstInfo instInfo = generateInstInfo();
		instInfoDao.insert(instInfo);
		
		instInfoDao.deleteById(instInfo.getInstcnceId());
		
		Assert.assertNull(instInfoDao.queryById(instInfo.getInstcnceId()));
	}

	private CustomProductInstInfo generateInstInfo() {
		CustomProductInstInfo instInfo = new CustomProductInstInfo();
		instInfo.setInstcnceId("225cf5c3-549a-4f77-8aec-65ad93587496");
		Map<String, String> dependentInfoMap = new HashMap<String, String>();
		dependentInfoMap.put("instanceId", "524353d3-7d11-4ed9-a340-75f2618b4ceb");
		dependentInfoMap.put("productCode", "percona_xtradb_cluster:5.6");
		String dependentInfo = JSON.toJSONString(dependentInfoMap);
		instInfo.setDependentInstanceInfo(dependentInfo);
		return instInfo;
	}
}
