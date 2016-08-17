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

public interface ProductScriptDao {
	ProductScript queryById(String id);
	void insert(ProductScript scripe);
	void update(ProductScript scripe);
	void deleteById(String id);
	void logicDeleteById(String id);
}
