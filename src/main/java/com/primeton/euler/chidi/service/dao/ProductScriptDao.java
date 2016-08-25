/*******************************************************************************
 *
 *==============================================================================
 *
 * Copyright (c) 2001-2016 Primeton Technologies, Ltd.
 * All rights reserved.
 * 
 * Created on 2016年8月17日 上午11:36:01
 *******************************************************************************/

package com.primeton.euler.chidi.service.dao;

import com.primeton.euler.chidi.service.model.ProductScript;

/**
 * 
 * ProductScriptDao
 *
 * @author tianxh (mailto:tianxh@primeton.com)
 */
public interface ProductScriptDao {
	ProductScript queryById(String id);

	ProductScript queryByProductId(String id);

	void insert(ProductScript script);

	void update(ProductScript script);

	void deleteById(String id);
}
