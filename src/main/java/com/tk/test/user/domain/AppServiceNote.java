package com.tk.test.user.domain;


import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.ZonedDateTime;

/**
 * 应用服务说明
 */
@Entity
@Table(name = "app_service_note")
public class AppServiceNote implements Serializable {

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
     * 服务说明标题
     */
    @Size(max = 200)
    @Column(name = "title", length = 200)
    private String title;

    /**
     * 服务说明内容
     */
    @Size(max = 300)
    @Column(name = "content", length = 300)
    private String content;

    /**
     * 序号
     */
    @Column(name = "note_order")
    private Integer noteOrder;

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

    public Long getServiceId() {
        return serviceId;
    }

    public AppServiceNote serviceId(Long serviceId) {
        this.serviceId = serviceId;
        return this;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public String getTitle() {
        return title;
    }

    public AppServiceNote title(String title) {
        this.title = title;
        return this;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public AppServiceNote content(String content) {
        this.content = content;
        return this;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getNoteOrder() {
        return noteOrder;
    }

    public AppServiceNote noteOrder(Integer noteOrder) {
        this.noteOrder = noteOrder;
        return this;
    }

    public void setNoteOrder(Integer noteOrder) {
        this.noteOrder = noteOrder;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public AppServiceNote delFlag(Integer delFlag) {
        this.delFlag = delFlag;
        return this;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public String getCreateById() {
        return createById;
    }

    public AppServiceNote createById(String createById) {
        this.createById = createById;
        return this;
    }

    public void setCreateById(String createById) {
        this.createById = createById;
    }

    public String getCreateByName() {
        return createByName;
    }

    public AppServiceNote createByName(String createByName) {
        this.createByName = createByName;
        return this;
    }

    public void setCreateByName(String createByName) {
        this.createByName = createByName;
    }

    public ZonedDateTime getCreateTime() {
        return createTime;
    }

    public AppServiceNote createTime(ZonedDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public void setCreateTime(ZonedDateTime createTime) {
        this.createTime = createTime;
    }

    public String getLastModifierId() {
        return lastModifierId;
    }

    public AppServiceNote lastModifierId(String lastModifierId) {
        this.lastModifierId = lastModifierId;
        return this;
    }

    public void setLastModifierId(String lastModifierId) {
        this.lastModifierId = lastModifierId;
    }

    public String getLastModifierName() {
        return lastModifierName;
    }

    public AppServiceNote lastModifierName(String lastModifierName) {
        this.lastModifierName = lastModifierName;
        return this;
    }

    public void setLastModifierName(String lastModifierName) {
        this.lastModifierName = lastModifierName;
    }

    public ZonedDateTime getLastModifyTime() {
        return lastModifyTime;
    }

    public AppServiceNote lastModifyTime(ZonedDateTime lastModifyTime) {
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
        if (!(o instanceof AppServiceNote)) {
            return false;
        }
        return id != null && id.equals(((AppServiceNote) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AppServiceNote{" +
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
