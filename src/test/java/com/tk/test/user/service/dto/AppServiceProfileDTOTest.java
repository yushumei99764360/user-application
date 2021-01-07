package com.tk.test.user.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.tk.test.user.web.rest.TestUtil;

public class AppServiceProfileDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(AppServiceProfileDTO.class);
        AppServiceProfileDTO appServiceProfileDTO1 = new AppServiceProfileDTO();
        appServiceProfileDTO1.setId(1L);
        AppServiceProfileDTO appServiceProfileDTO2 = new AppServiceProfileDTO();
        assertThat(appServiceProfileDTO1).isNotEqualTo(appServiceProfileDTO2);
        appServiceProfileDTO2.setId(appServiceProfileDTO1.getId());
        assertThat(appServiceProfileDTO1).isEqualTo(appServiceProfileDTO2);
        appServiceProfileDTO2.setId(2L);
        assertThat(appServiceProfileDTO1).isNotEqualTo(appServiceProfileDTO2);
        appServiceProfileDTO1.setId(null);
        assertThat(appServiceProfileDTO1).isNotEqualTo(appServiceProfileDTO2);
    }
}
