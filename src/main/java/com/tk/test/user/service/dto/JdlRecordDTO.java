package com.tk.test.user.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.ZonedDateTime;
import javax.validation.constraints.*;
import java.io.Serializable;
import javax.persistence.Lob;

/**
 * A DTO for the {@link com.tk.test.user.domain.JdlRecord} entity.
 */
@ApiModel(description = "jdl文件记录表")
public class JdlRecordDTO implements Serializable {
    
    private Long id;

    /**
     * 服务id
     */
    @NotNull
    @ApiModelProperty(value = "服务id", required = true)
    private Long serviceId;

    /**
     * 文件内容
     */
    
    @ApiModelProperty(value = "文件内容", required = true)
    @Lob
    private byte[] content;

    private String contentContentType;
    /**
     * 执行信息
     */
    @Size(max = 200)
    @ApiModelProperty(value = "执行信息")
    private String message;

    /**
     * 服务全局唯一id
     */
    @NotNull
    @Size(max = 40)
    @ApiModelProperty(value = "服务全局唯一id", required = true)
    private String guid;

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

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String getContentContentType() {
        return contentContentType;
    }

    public void setContentContentType(String contentContentType) {
        this.contentContentType = contentContentType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
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
        if (!(o instanceof JdlRecordDTO)) {
            return false;
        }

        return id != null && id.equals(((JdlRecordDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "JdlRecordDTO{" +
            "id=" + getId() +
            ", serviceId=" + getServiceId() +
            ", content='" + getContent() + "'" +
            ", message='" + getMessage() + "'" +
            ", guid='" + getGuid() + "'" +
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
