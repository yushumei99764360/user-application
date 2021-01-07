package com.tk.test.user.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.tk.test.user.web.rest.TestUtil;

public class AppStackDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(AppStackDTO.class);
        AppStackDTO appStackDTO1 = new AppStackDTO();
        appStackDTO1.setId(1L);
        AppStackDTO appStackDTO2 = new AppStackDTO();
        assertThat(appStackDTO1).isNotEqualTo(appStackDTO2);
        appStackDTO2.setId(appStackDTO1.getId());
        assertThat(appStackDTO1).isEqualTo(appStackDTO2);
        appStackDTO2.setId(2L);
        assertThat(appStackDTO1).isNotEqualTo(appStackDTO2);
        appStackDTO1.setId(null);
        assertThat(appStackDTO1).isNotEqualTo(appStackDTO2);
    }
}
