package com.tk.test.user.domain;


import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;

/**
 * 应用项目表
 */
@Entity
@Table(name = "app_project")
public class AppProject implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 项目名称
     */
    @Column(name = "project_name")
    private String projectName;

    /**
     * 项目描述
     */
    @Size(max = 100)
    @Column(name = "project_description", length = 100)
    private String projectDescription;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public AppProject projectName(String projectName) {
        this.projectName = projectName;
        return this;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public AppProject projectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
        return this;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AppProject)) {
            return false;
        }
        return id != null && id.equals(((AppProject) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AppProject{" +
            "id=" + getId() +
            ", projectName='" + getProjectName() + "'" +
            ", projectDescription='" + getProjectDescription() + "'" +
            "}";
    }
}
