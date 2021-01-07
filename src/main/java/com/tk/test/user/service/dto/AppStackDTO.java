package com.tk.test.user.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.ZonedDateTime;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.tk.test.user.domain.AppStack} entity.
 */
@ApiModel(description = "应用信息表")
public class AppStackDTO implements Serializable {
    
    private Long id;

    /**
     * 应用名
     */
    @NotNull
    @Size(max = 30)
    @ApiModelProperty(value = "应用名", required = true)
    private String appStackName;

    /**
     * 项目id
     */
    @NotNull
    @ApiModelProperty(value = "项目id", required = true)
    private Long appProjectId;

    /**
     * 所属项目名
     */
    @NotNull
    @Size(max = 30)
    @ApiModelProperty(value = "所属项目名", required = true)
    private String projectName;

    /**
     * 序号
     */
    @ApiModelProperty(value = "序号")
    private Integer appStackOrder;

    /**
     * 前端入口服务id
     */
    @NotNull
    @ApiModelProperty(value = "前端入口服务id", required = true)
    private Long entranceServiceId;

    /**
     * 应用类型，1-应用支撑应用、2-服务治理应用
     */
    @NotNull
    @ApiModelProperty(value = "应用类型，1-应用支撑应用、2-服务治理应用", required = true)
    private Integer appStackType;

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

    public String getAppStackName() {
        return appStackName;
    }

    public void setAppStackName(String appStackName) {
        this.appStackName = appStackName;
    }

    public Long getAppProjectId() {
        return appProjectId;
    }

    public void setAppProjectId(Long appProjectId) {
        this.appProjectId = appProjectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Integer getAppStackOrder() {
        return appStackOrder;
    }

    public void setAppStackOrder(Integer appStackOrder) {
        this.appStackOrder = appStackOrder;
    }

    public Long getEntranceServiceId() {
        return entranceServiceId;
    }

    public void setEntranceServiceId(Long entranceServiceId) {
        this.entranceServiceId = entranceServiceId;
    }

    public Integer getAppStackType() {
        return appStackType;
    }

    public void setAppStackType(Integer appStackType) {
        this.appStackType = appStackType;
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
        if (!(o instanceof AppStackDTO)) {
            return false;
        }

        return id != null && id.equals(((AppStackDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AppStackDTO{" +
            "id=" + getId() +
            ", appStackName='" + getAppStackName() + "'" +
            ", appProjectId=" + getAppProjectId() +
            ", projectName='" + getProjectName() + "'" +
            ", appStackOrder=" + getAppStackOrder() +
            ", entranceServiceId=" + getEntranceServiceId() +
            ", appStackType=" + getAppStackType() +
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
