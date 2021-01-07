package com.tk.test.user.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * A DTO for the {@link com.tk.test.user.domain.AppProject} entity.
 */
@ApiModel(description = "应用项目表")
public class AppProjectDTO implements Serializable {
    
    private Long id;

    /**
     * 项目名称
     */
    @ApiModelProperty(value = "项目名称")
    private String projectName;

    /**
     * 项目描述
     */
    @Size(max = 100)
    @ApiModelProperty(value = "项目描述")
    private String projectDescription;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AppProjectDTO)) {
            return false;
        }

        return id != null && id.equals(((AppProjectDTO) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AppProjectDTO{" +
            "id=" + getId() +
            ", projectName='" + getProjectName() + "'" +
            ", projectDescription='" + getProjectDescription() + "'" +
            "}";
    }
}
