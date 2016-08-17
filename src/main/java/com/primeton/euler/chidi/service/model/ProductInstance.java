package com.primeton.euler.chidi.service.model;

import com.primeton.euler.specs.devops.model.LogicalBase;

public class ProductInstance extends LogicalBase {

	/**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 7854226839655476155L;

	/**
	 * 标准产品id
	 */
	private String standardProductId;

	/**
	 * 用户名
	 */
	private String userName;

	/**
	 * url
	 */
	private String url;

	/**
	 * 实例规格Id
	 */
	private String productSpecId;

	/**
	 * 工作空间id
	 */
	private String workspaceId;

	/**
	 * 流程id
	 */
	private String processId;

	/**
	 * 自定义产品访问URL用户唯一凭证
	 */
	private String appKey;

	/**
	 * 自定义产品访问URL用户唯一凭证秘钥
	 */
	private String secret;

	/**
	 * 自定义产品访问URL访问令牌
	 */
	private String accessToken;

	/**
	 * 扩展属性
	 */
	private String extend1;

	/**
	 * 扩展属性
	 */
	private String extend2;

	/**
	 * 扩展属性
	 */
	private String extend3;
	/**
	 * 状态id
	 */
	private String statusId;

	/**
	 * 租户code
	 */
	private String tenantCode;

	/**
	 * 状态名称
	 */
	private String statusName;

	public String getStandardProductId() {
		return standardProductId;
	}

	public void setStandardProductId(String standardProductId) {
		this.standardProductId = standardProductId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getAppKey() {
		return appKey;
	}

	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getExtend1() {
		return extend1;
	}

	public void setExtend1(String extend1) {
		this.extend1 = extend1;
	}

	public String getExtend2() {
		return extend2;
	}

	public void setExtend2(String extend2) {
		this.extend2 = extend2;
	}

	public String getExtend3() {
		return extend3;
	}

	public void setExtend3(String extend3) {
		this.extend3 = extend3;
	}

	public String getWorkspaceId() {
		return workspaceId;
	}

	public void setWorkspaceId(String workspaceId) {
		this.workspaceId = workspaceId;
	}

	public String getProductSpecId() {
		return productSpecId;
	}

	public void setProductSpecId(String productSpecId) {
		this.productSpecId = productSpecId;
	}

	public String getStatusId() {
		return statusId;
	}

	public void setStatusId(String statusId) {
		this.statusId = statusId;
	}

	public String getTenantCode() {
		return tenantCode;
	}

	public void setTenantCode(String tenantCode) {
		this.tenantCode = tenantCode;
	}

	public String getProcessId() {
		return processId;
	}

	public void setProcessId(String processId) {
		this.processId = processId;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

}
