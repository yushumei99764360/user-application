package com.tk.test.user.service.mapper;


import com.tk.test.user.domain.*;
import com.tk.test.user.service.dto.AppServiceDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link AppService} and its DTO {@link AppServiceDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface AppServiceMapper extends EntityMapper<AppServiceDTO, AppService> {



    default AppService fromId(Long id) {
        if (id == null) {
            return null;
        }
        AppService appService = new AppService();
        appService.setId(id);
        return appService;
    }
}
