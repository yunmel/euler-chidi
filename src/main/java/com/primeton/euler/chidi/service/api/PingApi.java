/**
 * Copyright (c) 2001-2016 Primeton Technologies, Ltd.
 * All rights reserved. 
 */
package com.primeton.euler.chidi.service.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author ZhongWen Li (mailto:lizw@primeton.com)
 *
 */
@Path("/chidi")
public interface PingApi {

	/**
	 * Return pong. <br>
	 * 
	 * @return pong
	 */
	@Path("/ping")
	@GET
	@Produces({ MediaType.TEXT_PLAIN })
	String ping();
	
}
