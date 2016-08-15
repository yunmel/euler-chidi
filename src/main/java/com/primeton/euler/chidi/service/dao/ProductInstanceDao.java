/*******************************************************************************
 *
 *==============================================================================
 *
 * Copyright (c) 2001-2016 Primeton Technologies, Ltd.
 * All rights reserved.
 * 
 * Created on 2016年8月16日 上午7:46:13
 *******************************************************************************/


package com.primeton.euler.chidi.service.dao;

import com.primeton.euler.chidi.service.model.ProductInstance;

public interface ProductInstanceDao {
	ProductInstance queryById(String id);
	void insert(ProductInstance instance);
	void update(ProductInstance instance);
	void deleteById(String id);
	void logicDeleteById(String id);
}
