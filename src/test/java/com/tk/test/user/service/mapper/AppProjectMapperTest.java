package com.tk.test.user.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class AppProjectMapperTest {

    private AppProjectMapper appProjectMapper;

    @BeforeEach
    public void setUp() {
        appProjectMapper = new AppProjectMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(appProjectMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(appProjectMapper.fromId(null)).isNull();
    }
}
