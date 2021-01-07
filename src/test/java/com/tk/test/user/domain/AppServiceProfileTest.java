package com.tk.test.user.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.tk.test.user.web.rest.TestUtil;

public class AppServiceProfileTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(AppServiceProfile.class);
        AppServiceProfile appServiceProfile1 = new AppServiceProfile();
        appServiceProfile1.setId(1L);
        AppServiceProfile appServiceProfile2 = new AppServiceProfile();
        appServiceProfile2.setId(appServiceProfile1.getId());
        assertThat(appServiceProfile1).isEqualTo(appServiceProfile2);
        appServiceProfile2.setId(2L);
        assertThat(appServiceProfile1).isNotEqualTo(appServiceProfile2);
        appServiceProfile1.setId(null);
        assertThat(appServiceProfile1).isNotEqualTo(appServiceProfile2);
    }
}
