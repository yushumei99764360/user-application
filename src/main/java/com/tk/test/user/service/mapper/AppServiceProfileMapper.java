package com.tk.test.user.service.mapper;


import com.tk.test.user.domain.*;
import com.tk.test.user.service.dto.AppServiceProfileDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link AppServiceProfile} and its DTO {@link AppServiceProfileDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface AppServiceProfileMapper extends EntityMapper<AppServiceProfileDTO, AppServiceProfile> {



    default AppServiceProfile fromId(Long id) {
        if (id == null) {
            return null;
        }
        AppServiceProfile appServiceProfile = new AppServiceProfile();
        appServiceProfile.setId(id);
        return appServiceProfile;
    }
}
