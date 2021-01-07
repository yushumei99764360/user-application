package com.tk.test.user.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.tk.test.user.web.rest.TestUtil;

public class AppProjectDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(AppProjectDTO.class);
        AppProjectDTO appProjectDTO1 = new AppProjectDTO();
        appProjectDTO1.setId(1L);
        AppProjectDTO appProjectDTO2 = new AppProjectDTO();
        assertThat(appProjectDTO1).isNotEqualTo(appProjectDTO2);
        appProjectDTO2.setId(appProjectDTO1.getId());
        assertThat(appProjectDTO1).isEqualTo(appProjectDTO2);
        appProjectDTO2.setId(2L);
        assertThat(appProjectDTO1).isNotEqualTo(appProjectDTO2);
        appProjectDTO1.setId(null);
        assertThat(appProjectDTO1).isNotEqualTo(appProjectDTO2);
    }
}
