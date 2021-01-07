package com.tk.test.user.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.tk.test.user.web.rest.TestUtil;

public class JdlRecordDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(JdlRecordDTO.class);
        JdlRecordDTO jdlRecordDTO1 = new JdlRecordDTO();
        jdlRecordDTO1.setId(1L);
        JdlRecordDTO jdlRecordDTO2 = new JdlRecordDTO();
        assertThat(jdlRecordDTO1).isNotEqualTo(jdlRecordDTO2);
        jdlRecordDTO2.setId(jdlRecordDTO1.getId());
        assertThat(jdlRecordDTO1).isEqualTo(jdlRecordDTO2);
        jdlRecordDTO2.setId(2L);
        assertThat(jdlRecordDTO1).isNotEqualTo(jdlRecordDTO2);
        jdlRecordDTO1.setId(null);
        assertThat(jdlRecordDTO1).isNotEqualTo(jdlRecordDTO2);
    }
}
