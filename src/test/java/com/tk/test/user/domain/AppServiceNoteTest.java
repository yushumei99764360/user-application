package com.tk.test.user.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.tk.test.user.web.rest.TestUtil;

public class AppServiceNoteTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(AppServiceNote.class);
        AppServiceNote appServiceNote1 = new AppServiceNote();
        appServiceNote1.setId(1L);
        AppServiceNote appServiceNote2 = new AppServiceNote();
        appServiceNote2.setId(appServiceNote1.getId());
        assertThat(appServiceNote1).isEqualTo(appServiceNote2);
        appServiceNote2.setId(2L);
        assertThat(appServiceNote1).isNotEqualTo(appServiceNote2);
        appServiceNote1.setId(null);
        assertThat(appServiceNote1).isNotEqualTo(appServiceNote2);
    }
}
