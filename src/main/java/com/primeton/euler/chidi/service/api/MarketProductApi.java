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
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.gocom.euler.specs.portal.model.ProductInstanceVO;

import com.primeton.euler.specs.devops.exception.CapabilityException;

/**
 * @author ZhongWen Li (mailto:lizw@primeton.com)
 *
 */
@Path(ApiPrefix.PREFIX + "/market/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface MarketProductApi {

	@POST
	String createProductInstance(ProductInstanceVO instance, String tenantCode) throws CapabilityException;
	
	@DELETE
	@Path("/{id}")
	void destroyProductInstance(String instanceId, String tenantCode) throws CapabilityException;
	
	@GET
	@Path("/{id}")
	ProductInstanceVO viewProductInstance(String instanceId, String tenantCode) throws CapabilityException;
	
}
