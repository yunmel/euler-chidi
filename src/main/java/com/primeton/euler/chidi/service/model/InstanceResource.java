package com.primeton.euler.chidi.service.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * TODO 产品实例资源
 *
 * @author zhangwen (mailto:zhangwen@primeton.com)
 */
public class InstanceResource extends LogicalBase{
    
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 7854226839655476155L;
    
    /**
     * 产品实例id
     */
    private String productInstanceId;
    
    /**
     * 资源id
     */
    private String resourceId;
    
    /**
     * 流程实例id
     */
    private String processInstId;
  
  	/**
  	 * 组件code
  	 */
  	private String componentCode;
  	
  	/**
  	 * 组件版本
  	 */
  	private String componentVersion;
  	
  	/**
  	 * 产品code
  	 */
  	private String productCode;
  	
  	/**
  	 * 产品版本
  	 */
  	private String productVersion;
  	
  	/**
  	 * 服务名称
  	 */
  	private String serviceName;
  	
  	/**
  	 * 外部访问资源地址
  	 */
  	private String netUrl;
  	
  	/**
  	 * 域名名称
  	 */
  	private String publicDomainName;
  	
  	/**
  	 * 域名名称
  	 */
  	private String privateDomainName;
  	
  	/**
  	 * 公开IP
  	 */
  	private String publicIp;
  	
  	/**
  	 * 私有IP
  	 */
  	private String privateIp;
  	
  	/**
  	 * 额外信息
  	 */
  	private String additionalInfo;
  	
  	/**
  	 * 资源环境CODE
  	 */
  	private String envCode;
  	
  	/**
  	 * 资源端口信息
  	 */
  	private List<ResInfoPort> ports = new ArrayList<>();

	public String getProductInstanceId() {
		return productInstanceId;
	}

	public void setProductInstanceId(String productInstanceId) {
		this.productInstanceId = productInstanceId;
	}

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public String getProcessInstId() {
		return processInstId;
	}

	public void setProcessInstId(String processInstId) {
		this.processInstId = processInstId;
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

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductVersion() {
		return productVersion;
	}

	public void setProductVersion(String productVersion) {
		this.productVersion = productVersion;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getNetUrl() {
		return netUrl;
	}

	public void setNetUrl(String netUrl) {
		this.netUrl = netUrl;
	}

	public String getPublicDomainName() {
		return publicDomainName;
	}

	public void setPublicDomainName(String publicDomainName) {
		this.publicDomainName = publicDomainName;
	}

	public String getPrivateDomainName() {
		return privateDomainName;
	}

	public void setPrivateDomainName(String privateDomainName) {
		this.privateDomainName = privateDomainName;
	}

	public String getPublicIp() {
		return publicIp;
	}

	public void setPublicIp(String publicIp) {
		this.publicIp = publicIp;
	}

	public String getPrivateIp() {
		return privateIp;
	}

	public void setPrivateIp(String privateIp) {
		this.privateIp = privateIp;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public String getEnvCode() {
		return envCode;
	}

	public void setEnvCode(String envCode) {
		this.envCode = envCode;
	}

	public List<ResInfoPort> getPorts() {
		return ports;
	}

	public void setPorts(List<ResInfoPort> ports) {
		this.ports = ports;
	}
  	
}
