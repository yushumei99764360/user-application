package com.tk.test.user.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class AppStackMapperTest {

    private AppStackMapper appStackMapper;

    @BeforeEach
    public void setUp() {
        appStackMapper = new AppStackMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(appStackMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(appStackMapper.fromId(null)).isNull();
    }
}
