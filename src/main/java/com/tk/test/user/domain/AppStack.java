package com.tk.test.user.domain;


import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.ZonedDateTime;

/**
 * 应用信息表
 */
@Entity
@Table(name = "app_stack")
public class AppStack implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 应用名
     */
    @NotNull
    @Size(max = 30)
    @Column(name = "app_stack_name", length = 30, nullable = false)
    private String appStackName;

    /**
     * 项目id
     */
    @NotNull
    @Column(name = "app_project_id", nullable = false)
    private Long appProjectId;

    /**
     * 所属项目名
     */
    @NotNull
    @Size(max = 30)
    @Column(name = "project_name", length = 30, nullable = false)
    private String projectName;

    /**
     * 序号
     */
    @Column(name = "app_stack_order")
    private Integer appStackOrder;

    /**
     * 前端入口服务id
     */
    @NotNull
    @Column(name = "entrance_service_id", nullable = false)
    private Long entranceServiceId;

    /**
     * 应用类型，1-应用支撑应用、2-服务治理应用
     */
    @NotNull
    @Column(name = "app_stack_type", nullable = false)
    private Integer appStackType;

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

    public String getAppStackName() {
        return appStackName;
    }

    public AppStack appStackName(String appStackName) {
        this.appStackName = appStackName;
        return this;
    }

    public void setAppStackName(String appStackName) {
        this.appStackName = appStackName;
    }

    public Long getAppProjectId() {
        return appProjectId;
    }

    public AppStack appProjectId(Long appProjectId) {
        this.appProjectId = appProjectId;
        return this;
    }

    public void setAppProjectId(Long appProjectId) {
        this.appProjectId = appProjectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public AppStack projectName(String projectName) {
        this.projectName = projectName;
        return this;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Integer getAppStackOrder() {
        return appStackOrder;
    }

    public AppStack appStackOrder(Integer appStackOrder) {
        this.appStackOrder = appStackOrder;
        return this;
    }

    public void setAppStackOrder(Integer appStackOrder) {
        this.appStackOrder = appStackOrder;
    }

    public Long getEntranceServiceId() {
        return entranceServiceId;
    }

    public AppStack entranceServiceId(Long entranceServiceId) {
        this.entranceServiceId = entranceServiceId;
        return this;
    }

    public void setEntranceServiceId(Long entranceServiceId) {
        this.entranceServiceId = entranceServiceId;
    }

    public Integer getAppStackType() {
        return appStackType;
    }

    public AppStack appStackType(Integer appStackType) {
        this.appStackType = appStackType;
        return this;
    }

    public void setAppStackType(Integer appStackType) {
        this.appStackType = appStackType;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public AppStack delFlag(Integer delFlag) {
        this.delFlag = delFlag;
        return this;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public String getCreateById() {
        return createById;
    }

    public AppStack createById(String createById) {
        this.createById = createById;
        return this;
    }

    public void setCreateById(String createById) {
        this.createById = createById;
    }

    public String getCreateByName() {
        return createByName;
    }

    public AppStack createByName(String createByName) {
        this.createByName = createByName;
        return this;
    }

    public void setCreateByName(String createByName) {
        this.createByName = createByName;
    }

    public ZonedDateTime getCreateTime() {
        return createTime;
    }

    public AppStack createTime(ZonedDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public void setCreateTime(ZonedDateTime createTime) {
        this.createTime = createTime;
    }

    public String getLastModifierId() {
        return lastModifierId;
    }

    public AppStack lastModifierId(String lastModifierId) {
        this.lastModifierId = lastModifierId;
        return this;
    }

    public void setLastModifierId(String lastModifierId) {
        this.lastModifierId = lastModifierId;
    }

    public String getLastModifierName() {
        return lastModifierName;
    }

    public AppStack lastModifierName(String lastModifierName) {
        this.lastModifierName = lastModifierName;
        return this;
    }

    public void setLastModifierName(String lastModifierName) {
        this.lastModifierName = lastModifierName;
    }

    public ZonedDateTime getLastModifyTime() {
        return lastModifyTime;
    }

    public AppStack lastModifyTime(ZonedDateTime lastModifyTime) {
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
        if (!(o instanceof AppStack)) {
            return false;
        }
        return id != null && id.equals(((AppStack) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AppStack{" +
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
