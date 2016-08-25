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

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import org.gocom.euler.specs.portal.model.ProductInstanceAttrVO;
import org.gocom.euler.specs.portal.model.ProductInstanceVO;

import com.alibaba.fastjson.JSON;

public class MySQLProductInstance extends ProductInstanceVO {
	/**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 1L;

	public MySQLProductInstance() {
		
	}
	
	public static MySQLProductInstance getDefaultMySQLInstance() {
		InputStream is = MySQLProductInstance.class.getResourceAsStream("MySQLProductInstance.json");
		String productInstance = new Scanner(is, "UTF-8").useDelimiter("\\a").next();
		MySQLProductInstance instance = JSON.parseObject(productInstance, MySQLProductInstance.class);
		return instance;
	}
	
	public String getRootPassword() {
		List<ProductInstanceAttrVO> attrs =  this.getProductInstanceAttrs();
		for (ProductInstanceAttrVO attr : attrs) {
			if (attr.getComponentCode().equals("percona_xtradb_node_1:5.6") && attr.getAttrKey().equals("mysql_password")) {
				return attr.getAttrValue();
			}
		}
		return "";
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
	
//	public static void main(String[] args) {
//		MySQLProductInstance instance = MySQLProductInstance.getDefaultMySQLInstance();
//		System.out.println(">>>> root password: " + instance.getRootPassword());
//	}
	
}
