package com.tk.test.user.domain;


import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.ZonedDateTime;

/**
 * 应用服务环境表
 */
@Entity
@Table(name = "app_service_profile")
public class AppServiceProfile implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 服务id
     */
    @NotNull
    @Column(name = "service_id", nullable = false)
    private Long serviceId;

    /**
     * 序号
     */
    @Column(name = "note_order")
    private Integer noteOrder;

    /**
     * 环境名
     */
    @Size(max = 40)
    @Column(name = "env_name", length = 40)
    private String envName;

    /**
     * 环境描述
     */
    @Size(max = 1000)
    @Column(name = "env_describe", length = 1000)
    private String envDescribe;

    /**
     * 所处分支名
     */
    @Size(max = 40)
    @Column(name = "branch_name", length = 40)
    private String branchName;

    /**
     * 镜像tag
     */
    @Size(max = 200)
    @Column(name = "image_tag", length = 200)
    private String imageTag;

    /**
     * 服务版本号
     */
    @Size(max = 100)
    @Column(name = "service_version", length = 100)
    private String serviceVersion;

    /**
     * 服务状态，0-正常，1-停用，…
     */
    @NotNull
    @Column(name = "status", nullable = false)
    private Integer status;

    /**
     * 应用指定端口
     */
    @NotNull
    @Column(name = "service_port", nullable = false)
    private Integer servicePort;

    /**
     * 服务入口url
     */
    @Size(max = 200)
    @Column(name = "entrance_url", length = 200)
    private String entranceUrl;

    /**
     * 服务api文档url
     */
    @Size(max = 200)
    @Column(name = "api_url", length = 200)
    private String apiUrl;

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
    @Size(max = 20)
    @Column(name = "create_by_name", length = 20)
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
    @Size(max = 20)
    @Column(name = "last_modifier_name", length = 20)
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

    public Long getServiceId() {
        return serviceId;
    }

    public AppServiceProfile serviceId(Long serviceId) {
        this.serviceId = serviceId;
        return this;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public Integer getNoteOrder() {
        return noteOrder;
    }

    public AppServiceProfile noteOrder(Integer noteOrder) {
        this.noteOrder = noteOrder;
        return this;
    }

    public void setNoteOrder(Integer noteOrder) {
        this.noteOrder = noteOrder;
    }

    public String getEnvName() {
        return envName;
    }

    public AppServiceProfile envName(String envName) {
        this.envName = envName;
        return this;
    }

    public void setEnvName(String envName) {
        this.envName = envName;
    }

    public String getEnvDescribe() {
        return envDescribe;
    }

    public AppServiceProfile envDescribe(String envDescribe) {
        this.envDescribe = envDescribe;
        return this;
    }

    public void setEnvDescribe(String envDescribe) {
        this.envDescribe = envDescribe;
    }

    public String getBranchName() {
        return branchName;
    }

    public AppServiceProfile branchName(String branchName) {
        this.branchName = branchName;
        return this;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getImageTag() {
        return imageTag;
    }

    public AppServiceProfile imageTag(String imageTag) {
        this.imageTag = imageTag;
        return this;
    }

    public void setImageTag(String imageTag) {
        this.imageTag = imageTag;
    }

    public String getServiceVersion() {
        return serviceVersion;
    }

    public AppServiceProfile serviceVersion(String serviceVersion) {
        this.serviceVersion = serviceVersion;
        return this;
    }

    public void setServiceVersion(String serviceVersion) {
        this.serviceVersion = serviceVersion;
    }

    public Integer getStatus() {
        return status;
    }

    public AppServiceProfile status(Integer status) {
        this.status = status;
        return this;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getServicePort() {
        return servicePort;
    }

    public AppServiceProfile servicePort(Integer servicePort) {
        this.servicePort = servicePort;
        return this;
    }

    public void setServicePort(Integer servicePort) {
        this.servicePort = servicePort;
    }

    public String getEntranceUrl() {
        return entranceUrl;
    }

    public AppServiceProfile entranceUrl(String entranceUrl) {
        this.entranceUrl = entranceUrl;
        return this;
    }

    public void setEntranceUrl(String entranceUrl) {
        this.entranceUrl = entranceUrl;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public AppServiceProfile apiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
        return this;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public AppServiceProfile delFlag(Integer delFlag) {
        this.delFlag = delFlag;
        return this;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public String getCreateById() {
        return createById;
    }

    public AppServiceProfile createById(String createById) {
        this.createById = createById;
        return this;
    }

    public void setCreateById(String createById) {
        this.createById = createById;
    }

    public String getCreateByName() {
        return createByName;
    }

    public AppServiceProfile createByName(String createByName) {
        this.createByName = createByName;
        return this;
    }

    public void setCreateByName(String createByName) {
        this.createByName = createByName;
    }

    public ZonedDateTime getCreateTime() {
        return createTime;
    }

    public AppServiceProfile createTime(ZonedDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public void setCreateTime(ZonedDateTime createTime) {
        this.createTime = createTime;
    }

    public String getLastModifierId() {
        return lastModifierId;
    }

    public AppServiceProfile lastModifierId(String lastModifierId) {
        this.lastModifierId = lastModifierId;
        return this;
    }

    public void setLastModifierId(String lastModifierId) {
        this.lastModifierId = lastModifierId;
    }

    public String getLastModifierName() {
        return lastModifierName;
    }

    public AppServiceProfile lastModifierName(String lastModifierName) {
        this.lastModifierName = lastModifierName;
        return this;
    }

    public void setLastModifierName(String lastModifierName) {
        this.lastModifierName = lastModifierName;
    }

    public ZonedDateTime getLastModifyTime() {
        return lastModifyTime;
    }

    public AppServiceProfile lastModifyTime(ZonedDateTime lastModifyTime) {
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
        if (!(o instanceof AppServiceProfile)) {
            return false;
        }
        return id != null && id.equals(((AppServiceProfile) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AppServiceProfile{" +
            "id=" + getId() +
            ", serviceId=" + getServiceId() +
            ", noteOrder=" + getNoteOrder() +
            ", envName='" + getEnvName() + "'" +
            ", envDescribe='" + getEnvDescribe() + "'" +
            ", branchName='" + getBranchName() + "'" +
            ", imageTag='" + getImageTag() + "'" +
            ", serviceVersion='" + getServiceVersion() + "'" +
            ", status=" + getStatus() +
            ", servicePort=" + getServicePort() +
            ", entranceUrl='" + getEntranceUrl() + "'" +
            ", apiUrl='" + getApiUrl() + "'" +
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
