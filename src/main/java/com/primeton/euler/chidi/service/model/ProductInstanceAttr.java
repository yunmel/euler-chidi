package com.primeton.euler.chidi.service.model;

/**
 * TODO 产品实例属性
 * @author libin
 *
 */
@SuppressWarnings("serial")
public class ProductInstanceAttr extends LogicalBase {

	//规格属性与srm关联code
	private String srmSpecCode;
	
	//规格属性与srm关联name
	private String srmSpecName;
	
	//组件code
	private String componentCode;
	
	//组件版本
	private String componentVersion;
	
	//属性id
	private String attrId;
	
	//source 来源（0为自身，1来自srm，2来自scm）默认为0
	private String source;
	
	//属性键
	private String attrKey;
	
	//属性值
	private String attrValue;

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

	public String getAttrId() {
        return attrId;
    }

    public void setAttrId(String attrId) {
        this.attrId = attrId;
    }

    public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getAttrKey() {
		return attrKey;
	}

	public void setAttrKey(String attrKey) {
		this.attrKey = attrKey;
	}

	public String getAttrValue() {
		return attrValue;
	}

	public void setAttrValue(String attrValue) {
		this.attrValue = attrValue;
	}
	
}
