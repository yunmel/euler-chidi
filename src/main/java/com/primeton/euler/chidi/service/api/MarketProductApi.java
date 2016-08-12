/**
 * Copyright (c) 2001-2016 Primeton Technologies, Ltd.
 * All rights reserved. 
 */
package com.primeton.euler.chidi.service.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.primeton.euler.chidi.service.model.ProductInstance;
import com.primeton.euler.specs.devops.exception.CapabilityException;

/**
 * @author ZhongWen Li (mailto:lizw@primeton.com)
 *
 */
@Path(ApiPrefix.PREFIX + "/mkt/product")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface MarketProductApi {

	@POST
	@Path("/create")
	String createProductInstance(ProductInstance instance) throws CapabilityException;
	
	@DELETE
	@Path("/delete")
	void destroyProductInstance(String instanceId) throws CapabilityException;
	
}
