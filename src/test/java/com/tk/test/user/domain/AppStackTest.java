package com.tk.test.user.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.tk.test.user.web.rest.TestUtil;

public class AppStackTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(AppStack.class);
        AppStack appStack1 = new AppStack();
        appStack1.setId(1L);
        AppStack appStack2 = new AppStack();
        appStack2.setId(appStack1.getId());
        assertThat(appStack1).isEqualTo(appStack2);
        appStack2.setId(2L);
        assertThat(appStack1).isNotEqualTo(appStack2);
        appStack1.setId(null);
        assertThat(appStack1).isNotEqualTo(appStack2);
    }
}
