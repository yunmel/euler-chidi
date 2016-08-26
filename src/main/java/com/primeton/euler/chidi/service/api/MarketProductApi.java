/**
 * Copyright (c) 2001-2016 Primeton Technologies, Ltd.
 * All rights reserved. 
 */
package com.primeton.euler.chidi.service.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.gocom.euler.specs.portal.model.ProductInstanceVO;

import com.primeton.euler.specs.devops.exception.CapabilityException;

/**
 * @author ZhongWen Li (mailto:lizw@primeton.com)
 *
 */
@Path(ApiPrefix.PREFIX + "/market/productInstances")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface MarketProductApi {

	@POST
	String createProductInstance(ProductInstanceVO instance) throws CapabilityException;
	
	@DELETE
	@Path("/{instanceId}")
	void destroyProductInstance(@PathParam("instanceId") String instanceId, @QueryParam("tenantCode") String tenantCode) throws CapabilityException;
	
	@GET
	@Path("/{instanceId}")
	ProductInstanceVO viewProductInstance(@PathParam("instanceId") String instanceId, @QueryParam("tenantCode") String tenantCode) throws CapabilityException;
	
}
