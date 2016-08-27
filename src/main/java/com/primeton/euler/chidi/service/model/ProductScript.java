/*******************************************************************************
 *
 *==============================================================================
 *
 * Copyright (c) 2001-2016 Primeton Technologies, Ltd.
 * All rights reserved.
 * 
 * Created on 2016年8月16日 上午7:49:45
 *******************************************************************************/

package com.primeton.euler.chidi.service.model;

/**
 * 
 * 产品脚本信息表
 *
 * @author tianxh (mailto:tianxh@primeton.com)
 */
public class ProductScript {
	private String scriptId;
	private String productId;
	private String scriptPath;
	private String scriptName;

	public String getScriptId() {
		return scriptId;
	}

	public void setScriptId(String scriptId) {
		this.scriptId = scriptId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getScriptPath() {
		return scriptPath;
	}

	public void setScriptPath(String scriptPath) {
		this.scriptPath = scriptPath;
	}

	public String getScriptName() {
		return scriptName;
	}

	public void setScriptName(String scriptName) {
		this.scriptName = scriptName;
	}

}