package com.tk.test.user.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.ZonedDateTime;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.tk.test.user.domain.AppServiceNote} entity.
 */
@ApiModel(description = "应用服务说明")
public class AppServiceNoteDTO implements Serializable {
    
    private Long id;

    /**
     * 服务id
     */
    @NotNull
    @ApiModelProperty(value = "服务id", required = true)
    private Long serviceId;

    /**
     * 服务说明标题
     */
    @Size(max = 200)
    @ApiModelProperty(value = "服务说明标题")
    private String title;

    /**
     * 服务说明内容
     */
    @Size(max = 300)
    @ApiModelProperty(value = "服务说明内容")
    private String content;

    /**
     * 序号
     */
    @ApiModelProperty(value = "序号")
    private Integer noteOrder;

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

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getNoteOrder() {
        return noteOrder;
    }

    public void setNoteOrder(Integer noteOrder) {
        this.noteOrder = noteOrder;
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
        if (!(o instanceof AppServiceNoteDTO)) {
            return false;
        }

        return id != null && id.equals(((AppServiceNoteDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AppServiceNoteDTO{" +
            "id=" + getId() +
            ", serviceId=" + getServiceId() +
            ", title='" + getTitle() + "'" +
            ", content='" + getContent() + "'" +
            ", noteOrder=" + getNoteOrder() +
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
