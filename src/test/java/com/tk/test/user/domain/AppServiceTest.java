package com.tk.test.user.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.tk.test.user.web.rest.TestUtil;

public class AppServiceTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(AppService.class);
        AppService appService1 = new AppService();
        appService1.setId(1L);
        AppService appService2 = new AppService();
        appService2.setId(appService1.getId());
        assertThat(appService1).isEqualTo(appService2);
        appService2.setId(2L);
        assertThat(appService1).isNotEqualTo(appService2);
        appService1.setId(null);
        assertThat(appService1).isNotEqualTo(appService2);
    }
}
