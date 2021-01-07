package com.tk.test.user.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.tk.test.user.web.rest.TestUtil;

public class JdlRecordTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(JdlRecord.class);
        JdlRecord jdlRecord1 = new JdlRecord();
        jdlRecord1.setId(1L);
        JdlRecord jdlRecord2 = new JdlRecord();
        jdlRecord2.setId(jdlRecord1.getId());
        assertThat(jdlRecord1).isEqualTo(jdlRecord2);
        jdlRecord2.setId(2L);
        assertThat(jdlRecord1).isNotEqualTo(jdlRecord2);
        jdlRecord1.setId(null);
        assertThat(jdlRecord1).isNotEqualTo(jdlRecord2);
    }
}
