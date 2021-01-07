package com.tk.test.user.domain;


import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.ZonedDateTime;

/**
 * 应用服务信息
 */
@Entity
@Table(name = "app_service")
public class AppService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 应用id
     */
    @NotNull
    @Column(name = "app_stack_id", nullable = false)
    private Long appStackId;

    /**
     * 应用服务名
     */
    @NotNull
    @Size(max = 30)
    @Column(name = "service_name", length = 30, nullable = false)
    private String serviceName;

    /**
     * 中文名
     */
    @Size(max = 30)
    @Column(name = "service_name_zh", length = 30)
    private String serviceNameZh;

    /**
     * 服务描述
     */
    @Size(max = 1000)
    @Column(name = "service_describe", length = 1000)
    private String serviceDescribe;

    /**
     * 服务类型
     */
    @NotNull
    @Column(name = "service_type", nullable = false)
    private Integer serviceType;

    /**
     * 服务全局唯一id
     */
    @Size(max = 40)
    @Column(name = "guid", length = 40, unique = true)
    private String guid;

    /**
     * git群组
     */
    @NotNull
    @Column(name = "git_company", nullable = false)
    private String gitCompany;

    /**
     * 代码仓库地址
     */
    @Column(name = "git_url")
    private String gitUrl;

    /**
     * 代码仓库名
     */
    @NotNull
    @Size(max = 40)
    @Column(name = "repository_name", length = 40, nullable = false)
    private String repositoryName;

    /**
     * 包名称后缀
     */
    @NotNull
    @Size(max = 40)
    @Column(name = "package_name_suffix", length = 40, nullable = false)
    private String packageNameSuffix;

    /**
     * 服务序号
     */
    @Column(name = "service_oder")
    private Integer serviceOder;

    /**
     * 企业唯一id
     */
    @Size(max = 40)
    @Column(name = "company_id", length = 40)
    private String companyId;

    /**
     * 服务提供商
     */
    @Size(max = 60)
    @Column(name = "service_provider", length = 60)
    private String serviceProvider;

    /**
     * 备注
     */
    @Column(name = "remark")
    private String remark;

    /**
     * 删除状态（0，正常，1已删除）
     */
    @NotNull
    @Column(name = "del_flag", nullable = false)
    private Integer delFlag;

    /**
     * 创建人id
     */
    @Size(max = 40)
    @Column(name = "create_by_id", length = 40)
    private String createById;

    /**
     * 创建人
     */
    @Size(max = 40)
    @Column(name = "create_by_name", length = 40)
    private String createByName;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private ZonedDateTime createTime;

    /**
     * 最后更新人id
     */
    @Size(max = 40)
    @Column(name = "last_modifier_id", length = 40)
    private String lastModifierId;

    /**
     * 最后更新人
     */
    @Size(max = 40)
    @Column(name = "last_modifier_name", length = 40)
    private String lastModifierName;

    /**
     * 最后更新时间
     */
    @Column(name = "last_modify_time")
    private ZonedDateTime lastModifyTime;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAppStackId() {
        return appStackId;
    }

    public AppService appStackId(Long appStackId) {
        this.appStackId = appStackId;
        return this;
    }

    public void setAppStackId(Long appStackId) {
        this.appStackId = appStackId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public AppService serviceName(String serviceName) {
        this.serviceName = serviceName;
        return this;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceNameZh() {
        return serviceNameZh;
    }

    public AppService serviceNameZh(String serviceNameZh) {
        this.serviceNameZh = serviceNameZh;
        return this;
    }

    public void setServiceNameZh(String serviceNameZh) {
        this.serviceNameZh = serviceNameZh;
    }

    public String getServiceDescribe() {
        return serviceDescribe;
    }

    public AppService serviceDescribe(String serviceDescribe) {
        this.serviceDescribe = serviceDescribe;
        return this;
    }

    public void setServiceDescribe(String serviceDescribe) {
        this.serviceDescribe = serviceDescribe;
    }

    public Integer getServiceType() {
        return serviceType;
    }

    public AppService serviceType(Integer serviceType) {
        this.serviceType = serviceType;
        return this;
    }

    public void setServiceType(Integer serviceType) {
        this.serviceType = serviceType;
    }

    public String getGuid() {
        return guid;
    }

    public AppService guid(String guid) {
        this.guid = guid;
        return this;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getGitCompany() {
        return gitCompany;
    }

    public AppService gitCompany(String gitCompany) {
        this.gitCompany = gitCompany;
        return this;
    }

    public void setGitCompany(String gitCompany) {
        this.gitCompany = gitCompany;
    }

    public String getGitUrl() {
        return gitUrl;
    }

    public AppService gitUrl(String gitUrl) {
        this.gitUrl = gitUrl;
        return this;
    }

    public void setGitUrl(String gitUrl) {
        this.gitUrl = gitUrl;
    }

    public String getRepositoryName() {
        return repositoryName;
    }

    public AppService repositoryName(String repositoryName) {
        this.repositoryName = repositoryName;
        return this;
    }

    public void setRepositoryName(String repositoryName) {
        this.repositoryName = repositoryName;
    }

    public String getPackageNameSuffix() {
        return packageNameSuffix;
    }

    public AppService packageNameSuffix(String packageNameSuffix) {
        this.packageNameSuffix = packageNameSuffix;
        return this;
    }

    public void setPackageNameSuffix(String packageNameSuffix) {
        this.packageNameSuffix = packageNameSuffix;
    }

    public Integer getServiceOder() {
        return serviceOder;
    }

    public AppService serviceOder(Integer serviceOder) {
        this.serviceOder = serviceOder;
        return this;
    }

    public void setServiceOder(Integer serviceOder) {
        this.serviceOder = serviceOder;
    }

    public String getCompanyId() {
        return companyId;
    }

    public AppService companyId(String companyId) {
        this.companyId = companyId;
        return this;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getServiceProvider() {
        return serviceProvider;
    }

    public AppService serviceProvider(String serviceProvider) {
        this.serviceProvider = serviceProvider;
        return this;
    }

    public void setServiceProvider(String serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    public String getRemark() {
        return remark;
    }

    public AppService remark(String remark) {
        this.remark = remark;
        return this;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public AppService delFlag(Integer delFlag) {
        this.delFlag = delFlag;
        return this;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public String getCreateById() {
        return createById;
    }

    public AppService createById(String createById) {
        this.createById = createById;
        return this;
    }

    public void setCreateById(String createById) {
        this.createById = createById;
    }

    public String getCreateByName() {
        return createByName;
    }

    public AppService createByName(String createByName) {
        this.createByName = createByName;
        return this;
    }

    public void setCreateByName(String createByName) {
        this.createByName = createByName;
    }

    public ZonedDateTime getCreateTime() {
        return createTime;
    }

    public AppService createTime(ZonedDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public void setCreateTime(ZonedDateTime createTime) {
        this.createTime = createTime;
    }

    public String getLastModifierId() {
        return lastModifierId;
    }

    public AppService lastModifierId(String lastModifierId) {
        this.lastModifierId = lastModifierId;
        return this;
    }

    public void setLastModifierId(String lastModifierId) {
        this.lastModifierId = lastModifierId;
    }

    public String getLastModifierName() {
        return lastModifierName;
    }

    public AppService lastModifierName(String lastModifierName) {
        this.lastModifierName = lastModifierName;
        return this;
    }

    public void setLastModifierName(String lastModifierName) {
        this.lastModifierName = lastModifierName;
    }

    public ZonedDateTime getLastModifyTime() {
        return lastModifyTime;
    }

    public AppService lastModifyTime(ZonedDateTime lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
        return this;
    }

    public void setLastModifyTime(ZonedDateTime lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AppService)) {
            return false;
        }
        return id != null && id.equals(((AppService) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AppService{" +
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
