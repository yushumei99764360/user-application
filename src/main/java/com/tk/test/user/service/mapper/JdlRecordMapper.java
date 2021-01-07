package com.tk.test.user.service.mapper;


import com.tk.test.user.domain.*;
import com.tk.test.user.service.dto.JdlRecordDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link JdlRecord} and its DTO {@link JdlRecordDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface JdlRecordMapper extends EntityMapper<JdlRecordDTO, JdlRecord> {



    default JdlRecord fromId(Long id) {
        if (id == null) {
            return null;
        }
        JdlRecord jdlRecord = new JdlRecord();
        jdlRecord.setId(id);
        return jdlRecord;
    }
}
