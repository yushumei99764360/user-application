package com.tk.test.user.service.mapper;


import com.tk.test.user.domain.*;
import com.tk.test.user.service.dto.AppStackDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link AppStack} and its DTO {@link AppStackDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface AppStackMapper extends EntityMapper<AppStackDTO, AppStack> {



    default AppStack fromId(Long id) {
        if (id == null) {
            return null;
        }
        AppStack appStack = new AppStack();
        appStack.setId(id);
        return appStack;
    }
}
