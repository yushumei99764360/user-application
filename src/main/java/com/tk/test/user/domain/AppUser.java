package com.tk.test.user.domain;


import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.ZonedDateTime;

/**
 * 应用用户表
 */
@Entity
@Table(name = "app_user")
public class AppUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 应用id
     */
    @NotNull
    @Column(name = "app_id", nullable = false)
    private Long appId;

    /**
     * 用户id
     */
    @NotNull
    @Column(name = "user_id", nullable = false)
    private Long userId;

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

    public Long getAppId() {
        return appId;
    }

    public AppUser appId(Long appId) {
        this.appId = appId;
        return this;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    public Long getUserId() {
        return userId;
    }

    public AppUser userId(Long userId) {
        this.userId = userId;
        return this;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public AppUser delFlag(Integer delFlag) {
        this.delFlag = delFlag;
        return this;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public String getCreateById() {
        return createById;
    }

    public AppUser createById(String createById) {
        this.createById = createById;
        return this;
    }

    public void setCreateById(String createById) {
        this.createById = createById;
    }

    public String getCreateByName() {
        return createByName;
    }

    public AppUser createByName(String createByName) {
        this.createByName = createByName;
        return this;
    }

    public void setCreateByName(String createByName) {
        this.createByName = createByName;
    }

    public ZonedDateTime getCreateTime() {
        return createTime;
    }

    public AppUser createTime(ZonedDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public void setCreateTime(ZonedDateTime createTime) {
        this.createTime = createTime;
    }

    public String getLastModifierId() {
        return lastModifierId;
    }

    public AppUser lastModifierId(String lastModifierId) {
        this.lastModifierId = lastModifierId;
        return this;
    }

    public void setLastModifierId(String lastModifierId) {
        this.lastModifierId = lastModifierId;
    }

    public String getLastModifierName() {
        return lastModifierName;
    }

    public AppUser lastModifierName(String lastModifierName) {
        this.lastModifierName = lastModifierName;
        return this;
    }

    public void setLastModifierName(String lastModifierName) {
        this.lastModifierName = lastModifierName;
    }

    public ZonedDateTime getLastModifyTime() {
        return lastModifyTime;
    }

    public AppUser lastModifyTime(ZonedDateTime lastModifyTime) {
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
        if (!(o instanceof AppUser)) {
            return false;
        }
        return id != null && id.equals(((AppUser) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AppUser{" +
            "id=" + getId() +
            ", appId=" + getAppId() +
            ", userId=" + getUserId() +
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
