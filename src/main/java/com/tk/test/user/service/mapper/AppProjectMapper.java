package com.tk.test.user.service.mapper;


import com.tk.test.user.domain.*;
import com.tk.test.user.service.dto.AppProjectDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link AppProject} and its DTO {@link AppProjectDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface AppProjectMapper extends EntityMapper<AppProjectDTO, AppProject> {



    default AppProject fromId(Long id) {
        if (id == null) {
            return null;
        }
        AppProject appProject = new AppProject();
        appProject.setId(id);
        return appProject;
    }
}
