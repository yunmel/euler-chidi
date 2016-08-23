package com.primeton.euler.chidi.service.model;

@SuppressWarnings("serial")
public class CompSpec extends LogicalBase {

	//组件code
	private String componentCode;
	
	//组件version
	private String componentVersion;
	
	//创建次数
	private int buildNumber;
	
	private int orderNumber;
	
	//规格属性与srm关联code
	private String srmSpecCode;
		
	//规格属性与srm关联name
	private String srmSpecName;

	public String getComponentCode() {
		return componentCode;
	}

	public void setComponentCode(String componentCode) {
		this.componentCode = componentCode;
	}

	public String getComponentVersion() {
		return componentVersion;
	}

	public void setComponentVersion(String componentVersion) {
		this.componentVersion = componentVersion;
	}

	public int getBuildNumber() {
		return buildNumber;
	}

	public void setBuildNumber(int buildNumber) {
		this.buildNumber = buildNumber;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getSrmSpecCode() {
		return srmSpecCode;
	}

	public void setSrmSpecCode(String srmSpecCode) {
		this.srmSpecCode = srmSpecCode;
	}

	public String getSrmSpecName() {
		return srmSpecName;
	}

	public void setSrmSpecName(String srmSpecName) {
		this.srmSpecName = srmSpecName;
	}

}
