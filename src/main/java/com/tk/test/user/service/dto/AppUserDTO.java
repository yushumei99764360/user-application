package com.tk.test.user.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.ZonedDateTime;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.tk.test.user.domain.AppUser} entity.
 */
@ApiModel(description = "应用用户表")
public class AppUserDTO implements Serializable {
    
    private Long id;

    /**
     * 应用id
     */
    @NotNull
    @ApiModelProperty(value = "应用id", required = true)
    private Long appId;

    /**
     * 用户id
     */
    @NotNull
    @ApiModelProperty(value = "用户id", required = true)
    private Long userId;

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

    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
        if (!(o instanceof AppUserDTO)) {
            return false;
        }

        return id != null && id.equals(((AppUserDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AppUserDTO{" +
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
