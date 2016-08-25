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
 * TODO 此处填写 class 信息
 *
 * @author tianxh (mailto:tianxh@primeton.com)
 */
public class ProductScript {
	/**
	 * 脚本id
	 */
	private String scriptId;
	/**
	 * 产品id
	 */
	private String productId;
	/**
	 * 脚本内容
	 */
	private String scriptContent;

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

	public String getScriptContent() {
		return scriptContent;
	}

	public void setScriptContent(String scriptContent) {
		this.scriptContent = scriptContent;
	}

	@Override
	public String toString() {
		return "ProductScript [scriptId=" + scriptId + ", productId=" + productId + ", scriptContent=" + scriptContent
				+ "]";
	}
	
}