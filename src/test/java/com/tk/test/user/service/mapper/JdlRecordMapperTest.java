package com.tk.test.user.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class JdlRecordMapperTest {

    private JdlRecordMapper jdlRecordMapper;

    @BeforeEach
    public void setUp() {
        jdlRecordMapper = new JdlRecordMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(jdlRecordMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(jdlRecordMapper.fromId(null)).isNull();
    }
}
