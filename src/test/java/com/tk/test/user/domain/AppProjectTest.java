package com.tk.test.user.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.tk.test.user.web.rest.TestUtil;

public class AppProjectTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(AppProject.class);
        AppProject appProject1 = new AppProject();
        appProject1.setId(1L);
        AppProject appProject2 = new AppProject();
        appProject2.setId(appProject1.getId());
        assertThat(appProject1).isEqualTo(appProject2);
        appProject2.setId(2L);
        assertThat(appProject1).isNotEqualTo(appProject2);
        appProject1.setId(null);
        assertThat(appProject1).isNotEqualTo(appProject2);
    }
}
