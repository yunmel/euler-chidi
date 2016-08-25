/*******************************************************************************
 *
 *==============================================================================
 *
 * Copyright (c) 2001-2016 Primeton Technologies, Ltd.
 * All rights reserved.
 * 
 * Created on 2016年8月24日 上午10:04:07
 *******************************************************************************/

package com.primeton.euler.chidi.service.model;

/**
 * 
 * 自定义产品实例信息
 *
 * @author tianxh (mailto:tianxh@primeton.com)
 */
public class CustomProductInstInfo {
	private String instcnceId;
	/**
	 * json格式
	 */
	private String dependentInstanceInfo;

	public String getInstcnceId() {
		return instcnceId;
	}

	public void setInstcnceId(String instcnceId) {
		this.instcnceId = instcnceId;
	}

	public String getDependentInstanceInfo() {
		return dependentInstanceInfo;
	}

	public void setDependentInstanceInfo(String dependentInstanceInfo) {
		this.dependentInstanceInfo = dependentInstanceInfo;
	}

}
