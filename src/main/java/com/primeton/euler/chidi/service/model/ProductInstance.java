package com.primeton.euler.chidi.service.model;

import java.util.List;

/**
 * @author libin (mailto:libin@primeton.com)
 */
public class ProductInstance extends LogicalBase {

	private static final long serialVersionUID = 7893691254289630227L;

	/**
     * 标准产品Id
     */
    private String standardProductId;

    /**
     * 产品规格Id
     */
    private String productSpecId;
    
    /**
     * 标准产品url
     */
    private String url;
    
    /**
     * 标准产品name
     */
    private String standardProductName;
    
    /**
     * 标准产品code
     */
    private String productCode;
    
    /**
     * 标准产品version
     */
    private String productVersion;
    
    /**
     * spm version
     */
    private String spmVersion;
    
    /**
     * 发布描述
     */
    private String releaseDesc;
    
    /**
     * 发布时间
     */
    private Long releaseTime;
    
    /**
     * 提供方
     */
    private String provider;
    
    /**
     * 标准产品供应商tenantCode
     */
    private String providerCode;
    
    /**
     * 状态id
     */
    private String statusId;
    
    /**
     * 产品描述
     */
    private String productDesc;
    
    /**
     * 产品logo
     */
    private String logo;
    
    /**
     * 产品标签
     */
    private String tag;
    
    /**
     * 使用次数
     */
    private int usedCount;
    
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
     * 状态名称
     */
    private String statusName;
    
    /**
     * 环境编码envCode
     */
    private String envCode;
    
    //租户code
    private String tenantCode;
    
    private String offerId;
    
    private List<ProductInstanceAttr> productInstanceAttrs;
    
    private List<CompSpec> compSpecs;
    
    private List<InstanceResource> productInstanceResources;

	public String getStandardProductId() {
		return standardProductId;
	}

	public void setStandardProductId(String standardProductId) {
		this.standardProductId = standardProductId;
	}

	public String getProductSpecId() {
		return productSpecId;
	}

	public void setProductSpecId(String productSpecId) {
		this.productSpecId = productSpecId;
	}

	public String getProviderCode() {
        return providerCode;
    }

    public void setProviderCode(String providerCode) {
        this.providerCode = providerCode;
    }

    public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
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


	public String getEnvCode() {
		return envCode;
	}

	public void setEnvCode(String envCode) {
		this.envCode = envCode;
	}

	public String getTenantCode() {
		return tenantCode;
	}

	public void setTenantCode(String tenantCode) {
		this.tenantCode = tenantCode;
	}

	
	
	public String getOfferId() {
		return offerId;
	}

	public void setOfferId(String offerId) {
		this.offerId = offerId;
	}

	public String getStandardProductName() {
		return standardProductName;
	}

	public void setStandardProductName(String standardProductName) {
		this.standardProductName = standardProductName;
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

	public String getSpmVersion() {
		return spmVersion;
	}

	public void setSpmVersion(String spmVersion) {
		this.spmVersion = spmVersion;
	}

	public String getReleaseDesc() {
		return releaseDesc;
	}

	public void setReleaseDesc(String releaseDesc) {
		this.releaseDesc = releaseDesc;
	}

	public Long getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(Long releaseTime) {
		this.releaseTime = releaseTime;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public int getUsedCount() {
		return usedCount;
	}

	public void setUsedCount(int usedCount) {
		this.usedCount = usedCount;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public List<ProductInstanceAttr> getProductInstanceAttrs() {
		return productInstanceAttrs;
	}

	public void setProductInstanceAttrs(List<ProductInstanceAttr> productInstanceAttrs) {
		this.productInstanceAttrs = productInstanceAttrs;
	}

	public List<CompSpec> getCompSpecs() {
		return compSpecs;
	}

	public void setCompSpecs(List<CompSpec> compSpecs) {
		this.compSpecs = compSpecs;
	}

	public List<InstanceResource> getProductInstanceResources() {
		return productInstanceResources;
	}

	public void setProductInstanceResources(List<InstanceResource> productInstanceResources) {
		this.productInstanceResources = productInstanceResources;
	}
	
}
