package com.primeton.euler.chidi.service.model;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;

public class LogicalBase implements Serializable {

	/**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 1823711313141254642L;

	/**
	 * 唯一标识
	 */
	protected String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String toString() {
		StringBuffer buf = new StringBuffer();
		buf.append(this.getClass().getName());
		buf.append(" json is : ");
		buf.append(JSON.toJSONString(this));
		return buf.toString();
	}
}
