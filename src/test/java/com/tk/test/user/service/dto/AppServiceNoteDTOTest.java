package com.tk.test.user.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.tk.test.user.web.rest.TestUtil;

public class AppServiceNoteDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(AppServiceNoteDTO.class);
        AppServiceNoteDTO appServiceNoteDTO1 = new AppServiceNoteDTO();
        appServiceNoteDTO1.setId(1L);
        AppServiceNoteDTO appServiceNoteDTO2 = new AppServiceNoteDTO();
        assertThat(appServiceNoteDTO1).isNotEqualTo(appServiceNoteDTO2);
        appServiceNoteDTO2.setId(appServiceNoteDTO1.getId());
        assertThat(appServiceNoteDTO1).isEqualTo(appServiceNoteDTO2);
        appServiceNoteDTO2.setId(2L);
        assertThat(appServiceNoteDTO1).isNotEqualTo(appServiceNoteDTO2);
        appServiceNoteDTO1.setId(null);
        assertThat(appServiceNoteDTO1).isNotEqualTo(appServiceNoteDTO2);
    }
}
