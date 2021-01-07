package com.tk.test.user.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.tk.test.user.web.rest.TestUtil;

public class AppServiceDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(AppServiceDTO.class);
        AppServiceDTO appServiceDTO1 = new AppServiceDTO();
        appServiceDTO1.setId(1L);
        AppServiceDTO appServiceDTO2 = new AppServiceDTO();
        assertThat(appServiceDTO1).isNotEqualTo(appServiceDTO2);
        appServiceDTO2.setId(appServiceDTO1.getId());
        assertThat(appServiceDTO1).isEqualTo(appServiceDTO2);
        appServiceDTO2.setId(2L);
        assertThat(appServiceDTO1).isNotEqualTo(appServiceDTO2);
        appServiceDTO1.setId(null);
        assertThat(appServiceDTO1).isNotEqualTo(appServiceDTO2);
    }
}
