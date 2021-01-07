package com.tk.test.user.service.mapper;


import com.tk.test.user.domain.*;
import com.tk.test.user.service.dto.AppServiceNoteDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link AppServiceNote} and its DTO {@link AppServiceNoteDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface AppServiceNoteMapper extends EntityMapper<AppServiceNoteDTO, AppServiceNote> {



    default AppServiceNote fromId(Long id) {
        if (id == null) {
            return null;
        }
        AppServiceNote appServiceNote = new AppServiceNote();
        appServiceNote.setId(id);
        return appServiceNote;
    }
}
