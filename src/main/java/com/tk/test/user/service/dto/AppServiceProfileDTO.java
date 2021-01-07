package com.tk.test.user.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.ZonedDateTime;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.tk.test.user.domain.AppServiceProfile} entity.
 */
@ApiModel(description = "应用服务环境表")
public class AppServiceProfileDTO implements Serializable {
    
    private Long id;

    /**
     * 服务id
     */
    @NotNull
    @ApiModelProperty(value = "服务id", required = true)
    private Long serviceId;

    /**
     * 序号
     */
    @ApiModelProperty(value = "序号")
    private Integer noteOrder;

    /**
     * 环境名
     */
    @Size(max = 40)
    @ApiModelProperty(value = "环境名")
    private String envName;

    /**
     * 环境描述
     */
    @Size(max = 1000)
    @ApiModelProperty(value = "环境描述")
    private String envDescribe;

    /**
     * 所处分支名
     */
    @Size(max = 40)
    @ApiModelProperty(value = "所处分支名")
    private String branchName;

    /**
     * 镜像tag
     */
    @Size(max = 200)
    @ApiModelProperty(value = "镜像tag")
    private String imageTag;

    /**
     * 服务版本号
     */
    @Size(max = 100)
    @ApiModelProperty(value = "服务版本号")
    private String serviceVersion;

    /**
     * 服务状态，0-正常，1-停用，…
     */
    @NotNull
    @ApiModelProperty(value = "服务状态，0-正常，1-停用，…", required = true)
    private Integer status;

    /**
     * 应用指定端口
     */
    @NotNull
    @ApiModelProperty(value = "应用指定端口", required = true)
    private Integer servicePort;

    /**
     * 服务入口url
     */
    @Size(max = 200)
    @ApiModelProperty(value = "服务入口url")
    private String entranceUrl;

    /**
     * 服务api文档url
     */
    @Size(max = 200)
    @ApiModelProperty(value = "服务api文档url")
    private String apiUrl;

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
    @Size(max = 20)
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
    @Size(max = 20)
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

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public Integer getNoteOrder() {
        return noteOrder;
    }

    public void setNoteOrder(Integer noteOrder) {
        this.noteOrder = noteOrder;
    }

    public String getEnvName() {
        return envName;
    }

    public void setEnvName(String envName) {
        this.envName = envName;
    }

    public String getEnvDescribe() {
        return envDescribe;
    }

    public void setEnvDescribe(String envDescribe) {
        this.envDescribe = envDescribe;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getImageTag() {
        return imageTag;
    }

    public void setImageTag(String imageTag) {
        this.imageTag = imageTag;
    }

    public String getServiceVersion() {
        return serviceVersion;
    }

    public void setServiceVersion(String serviceVersion) {
        this.serviceVersion = serviceVersion;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getServicePort() {
        return servicePort;
    }

    public void setServicePort(Integer servicePort) {
        this.servicePort = servicePort;
    }

    public String getEntranceUrl() {
        return entranceUrl;
    }

    public void setEntranceUrl(String entranceUrl) {
        this.entranceUrl = entranceUrl;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
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
        if (!(o instanceof AppServiceProfileDTO)) {
            return false;
        }

        return id != null && id.equals(((AppServiceProfileDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AppServiceProfileDTO{" +
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
