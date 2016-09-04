/**
 * Copyright (c) 2001-2016 Primeton Technologies, Ltd.
 * All rights reserved. 
 */
package com.primeton.euler.chidi.service.api.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import com.primeton.euler.chidi.service.api.PingApi;

/**
 * @author ZhongWen Li (mailto:lizw@primeton.com)
 *
 */
@Service
//@Scope(WebApplicationContext.SCOPE_REQUEST)
public class PingApiImpl implements PingApi {
	
	/* (non-Javadoc)
	 * @see com.primeton.euler.chidi.service.api.PingApi#ping()
	 */
	@Override
	public String ping() {
		return "pong"; //$NON-NLS-1$
	}

}
