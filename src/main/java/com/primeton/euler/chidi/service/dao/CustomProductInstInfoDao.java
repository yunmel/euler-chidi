/*******************************************************************************
 *
 *==============================================================================
 *
 * Copyright (c) 2001-2016 Primeton Technologies, Ltd.
 * All rights reserved.
 * 
 * Created on 2016年8月24日 上午10:03:02
 *******************************************************************************/

package com.primeton.euler.chidi.service.dao;

import com.primeton.euler.chidi.service.model.CustomProductInstInfo;

/**
 * 
 * CustomProductInstDao
 *
 * @author tianxh (mailto:tianxh@primeton.com)
 */
public interface CustomProductInstInfoDao {
	CustomProductInstInfo queryById(String id);

	void insert(CustomProductInstInfo inst);

	void update(CustomProductInstInfo inst);

	void deleteById(String id);
}
