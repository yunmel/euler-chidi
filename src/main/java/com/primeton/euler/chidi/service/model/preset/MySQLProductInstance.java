/*******************************************************************************
 *
 *==============================================================================
 *
 * Copyright (c) 2001-2016 Primeton Technologies, Ltd.
 * All rights reserved.
 * 
 * Created on 2016年8月23日 上午11:28:57
 *******************************************************************************/

package com.primeton.euler.chidi.service.model.preset;

import java.util.ArrayList;
import java.util.List;

import com.primeton.euler.chidi.service.model.CompSpec;
import com.primeton.euler.chidi.service.model.ProductInstance;
import com.primeton.euler.chidi.service.model.ProductInstanceAttr;

public class MySQLProductInstance extends ProductInstance {
	/**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 1L;

	public MySQLProductInstance() {
		this.setStandardProductId("1qce7fd5-55e3-4816-ae71-ff44fca290cd");
		this.setProductSpecId("024ac216-6a19-45f5-9f51-514f2475a541");
		this.setUrl("http://baidu.com");
		this.setTenantCode("default");
		this.setOfferId("1");
		this.setProviderCode("default");
		this.setProductCode("default");
		
		List<CompSpec> compSpecs = new ArrayList<CompSpec>();
		CompSpec compSpec = new CompSpec();
		compSpec.setComponentCode("mysql");
		compSpec.setComponentVersion("5.6");
		compSpec.setBuildNumber(1000);
		compSpec.setOrderNumber(1);
		compSpecs.add(compSpec);
		this.setCompSpecs(compSpecs);
		
		List<ProductInstanceAttr> instanceAttr = new ArrayList<ProductInstanceAttr>();
		ProductInstanceAttr attr = new ProductInstanceAttr();
		attr.setSrmSpecCode("service");
		attr.setSrmSpecName("默认规格");
		attr.setComponentCode("mysql");
		attr.setComponentVersion("5.6");
		attr.setAttrId("1");
		attr.setSource("0");
		attr.setAttrKey("sss");
		attr.setAttrValue("xxx");
		instanceAttr.add(attr);
		this.setProductInstanceAttrs(instanceAttr);
	}
	
	
	
	@Override
	public String toString() {
		return "MySQLProductInstance [id=" + id + ", standardProductId=" + getStandardProductId()
				+ ", productSpecId=" + getProductSpecId() + ", providerCode=" + getProviderCode()
				+ ", url=" + getUrl() + ", statusId=" + getStatusId() + ", appKey=" + getAppKey()
				+ ", secret=" + getSecret() + ", accessToken=" + getAccessToken() + ", extend1="
				+ getExtend1() + ", extend2=" + getExtend2() + ", extend3=" + getExtend3() + ", envCode="
				+ getEnvCode() + ", tenantCode=" + getTenantCode() + ", offerId=" + getOfferId()
				+ ", standardProductName=" + getStandardProductName() + ", productCode=" + getProductCode()
				+ ", productVersion=" + getProductVersion() + ", spmVersion=" + getSpmVersion()
				+ ", releaseDesc=" + getReleaseDesc() + ", releaseTime=" + getReleaseTime()
				+ ", provider=" + getProvider() + ", productDesc=" + getProductDesc() + ", logo="
				+ getLogo() + ", tag=" + getTag() + ", usedCount=" + getUsedCount() + ", statusName="
				+ getStatusName() + ", productInstanceAttrs=" + getProductInstanceAttrs() + ", compSpecs="
				+ getCompSpecs() + ", productInstanceResources=" + getProductInstanceResources() + "]";
	}

	public static void main(String[] args) {
		MySQLProductInstance instance = new MySQLProductInstance();
		System.out.println(instance);
	}
}
