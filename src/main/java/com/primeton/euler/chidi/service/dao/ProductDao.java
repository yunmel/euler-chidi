/*******************************************************************************
 *
 *==============================================================================
 *
 * Copyright (c) 2001-2016 Primeton Technologies, Ltd.
 * All rights reserved.
 * 
 * Created on 2016年8月16日 上午7:49:45
 *******************************************************************************/

package com.primeton.euler.chidi.service.dao;

import com.primeton.euler.chidi.service.model.Product;

public interface ProductDao {
	Product queryById(String id);

	void insert(Product product);

	void update(Product product);

	void deleteById(String id);

	void logicDeleteById(String id);
}
