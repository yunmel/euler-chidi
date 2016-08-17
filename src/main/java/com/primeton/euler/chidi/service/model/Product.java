package com.primeton.euler.chidi.service.model;

import java.util.Date;

public class Product extends LogicalBase {

	/**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = -6143274930933175255L;

	/**
	 * 标准产品名称
	 */
	private String standardProductName;

	/**
	 * 产品code
	 */
	private String productCode;

	/**
	 * 产品version
	 */
	private String productVersion;

	/**
	 * 产品版本(spm)
	 */
	private String spmVersion;

	/**
	 * 产品来源（0为上传产品，1为SPM的产品）
	 */
	private int sourceType;

	private String offerId;

	/**
	 * 发布时间
	 */
	private Date releaseTime;

	/**
	 * 发布描述
	 */
	private String releaseDesc;

	/**
	 * 发布tag
	 */
	private String tag;

	// 发布状态
	private String releaseStatus;

	private int statusId;

	/**
	 * 发布次数
	 */
	private int usedCount;

	/**
	 * 标准产品图标
	 */
	private String logo;

	/**
	 * 标准产品供应商
	 */
	private String productDesc;

	/**
	 * 范围
	 */
	private String scope;

	/**
	 * 租户编号唯一
	 */
	private String tenantCode;

	/**
	 * 产品开通url
	 */
	private String productOpenUrl;

	/**
	 * 产品销毁url
	 */
	private String productDestroyUrl;

	/**
	 * 产品详情url
	 */
	private String productDetailUrl;

}
