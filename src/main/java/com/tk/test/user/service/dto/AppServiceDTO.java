package com.tk.test.user.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.ZonedDateTime;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.tk.test.user.domain.AppService} entity.
 */
@ApiModel(description = "应用服务信息")
public class AppServiceDTO implements Serializable {
    
    private Long id;

    /**
     * 应用id
     */
    @NotNull
    @ApiModelProperty(value = "应用id", required = true)
    private Long appStackId;

    /**
     * 应用服务名
     */
    @NotNull
    @Size(max = 30)
    @ApiModelProperty(value = "应用服务名", required = true)
    private String serviceName;

    /**
     * 中文名
     */
    @Size(max = 30)
    @ApiModelProperty(value = "中文名")
    private String serviceNameZh;

    /**
     * 服务描述
     */
    @Size(max = 1000)
    @ApiModelProperty(value = "服务描述")
    private String serviceDescribe;

    /**
     * 服务类型
     */
    @NotNull
    @ApiModelProperty(value = "服务类型", required = true)
    private Integer serviceType;

    /**
     * 服务全局唯一id
     */
    @Size(max = 40)
    @ApiModelProperty(value = "服务全局唯一id")
    private String guid;

    /**
     * git群组
     */
    @NotNull
    @ApiModelProperty(value = "git群组", required = true)
    private String gitCompany;

    /**
     * 代码仓库地址
     */
    @ApiModelProperty(value = "代码仓库地址")
    private String gitUrl;

    /**
     * 代码仓库名
     */
    @NotNull
    @Size(max = 40)
    @ApiModelProperty(value = "代码仓库名", required = true)
    private String repositoryName;

    /**
     * 包名称后缀
     */
    @NotNull
    @Size(max = 40)
    @ApiModelProperty(value = "包名称后缀", required = true)
    private String packageNameSuffix;

    /**
     * 服务序号
     */
    @ApiModelProperty(value = "服务序号")
    private Integer serviceOder;

    /**
     * 企业唯一id
     */
    @Size(max = 40)
    @ApiModelProperty(value = "企业唯一id")
    private String companyId;

    /**
     * 服务提供商
     */
    @Size(max = 60)
    @ApiModelProperty(value = "服务提供商")
    private String serviceProvider;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;

    /**
     * 删除状态（0，正常，1已删除）
     */
    @NotNull
    @ApiModelProperty(value = "删除状态（0，正常，1已删除）", required = true)
    private Integer delFlag;

    /**
     * 创建人id
     */
    @Size(max = 40)
    @ApiModelProperty(value = "创建人id")
    private String createById;

    /**
     * 创建人
     */
    @Size(max = 40)
    @ApiModelProperty(value = "创建人")
    private String createByName;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private ZonedDateTime createTime;

    /**
     * 最后更新人id
     */
    @Size(max = 40)
    @ApiModelProperty(value = "最后更新人id")
    private String lastModifierId;

    /**
     * 最后更新人
     */
    @Size(max = 40)
    @ApiModelProperty(value = "最后更新人")
    private String lastModifierName;

    /**
     * 最后更新时间
     */
    @ApiModelProperty(value = "最后更新时间")
    private ZonedDateTime lastModifyTime;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAppStackId() {
        return appStackId;
    }

    public void setAppStackId(Long appStackId) {
        this.appStackId = appStackId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceNameZh() {
        return serviceNameZh;
    }

    public void setServiceNameZh(String serviceNameZh) {
        this.serviceNameZh = serviceNameZh;
    }

    public String getServiceDescribe() {
        return serviceDescribe;
    }

    public void setServiceDescribe(String serviceDescribe) {
        this.serviceDescribe = serviceDescribe;
    }

    public Integer getServiceType() {
        return serviceType;
    }

    public void setServiceType(Integer serviceType) {
        this.serviceType = serviceType;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getGitCompany() {
        return gitCompany;
    }

    public void setGitCompany(String gitCompany) {
        this.gitCompany = gitCompany;
    }

    public String getGitUrl() {
        return gitUrl;
    }

    public void setGitUrl(String gitUrl) {
        this.gitUrl = gitUrl;
    }

    public String getRepositoryName() {
        return repositoryName;
    }

    public void setRepositoryName(String repositoryName) {
        this.repositoryName = repositoryName;
    }

    public String getPackageNameSuffix() {
        return packageNameSuffix;
    }

    public void setPackageNameSuffix(String packageNameSuffix) {
        this.packageNameSuffix = packageNameSuffix;
    }

    public Integer getServiceOder() {
        return serviceOder;
    }

    public void setServiceOder(Integer serviceOder) {
        this.serviceOder = serviceOder;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(String serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public String getCreateById() {
        return createById;
    }

    public void setCreateById(String createById) {
        this.createById = createById;
    }

    public String getCreateByName() {
        return createByName;
    }

    public void setCreateByName(String createByName) {
        this.createByName = createByName;
    }

    public ZonedDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(ZonedDateTime createTime) {
        this.createTime = createTime;
    }

    public String getLastModifierId() {
        return lastModifierId;
    }

    public void setLastModifierId(String lastModifierId) {
        this.lastModifierId = lastModifierId;
    }

    public String getLastModifierName() {
        return lastModifierName;
    }

    public void setLastModifierName(String lastModifierName) {
        this.lastModifierName = lastModifierName;
    }

    public ZonedDateTime getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(ZonedDateTime lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AppServiceDTO)) {
            return false;
        }

        return id != null && id.equals(((AppServiceDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AppServiceDTO{" +
            "id=" + getId() +
            ", appStackId=" + getAppStackId() +
            ", serviceName='" + getServiceName() + "'" +
            ", serviceNameZh='" + getServiceNameZh() + "'" +
            ", serviceDescribe='" + getServiceDescribe() + "'" +
            ", serviceType=" + getServiceType() +
            ", guid='" + getGuid() + "'" +
            ", gitCompany='" + getGitCompany() + "'" +
            ", gitUrl='" + getGitUrl() + "'" +
            ", repositoryName='" + getRepositoryName() + "'" +
            ", packageNameSuffix='" + getPackageNameSuffix() + "'" +
            ", serviceOder=" + getServiceOder() +
            ", companyId='" + getCompanyId() + "'" +
            ", serviceProvider='" + getServiceProvider() + "'" +
            ", remark='" + getRemark() + "'" +
            ", delFlag=" + getDelFlag() +
            ", createById='" + getCreateById() + "'" +
            ", createByName='" + getCreateByName() + "'" +
            ", createTime='" + getCreateTime() + "'" +
            ", lastModifierId='" + getLastModifierId() + "'" +
            ", lastModifierName='" + getLastModifierName() + "'" +
            ", lastModifyTime='" + getLastModifyTime() + "'" +
            "}";
    }
}
