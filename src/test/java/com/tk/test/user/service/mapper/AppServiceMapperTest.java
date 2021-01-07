package com.tk.test.user.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class AppServiceMapperTest {

    private AppServiceMapper appServiceMapper;

    @BeforeEach
    public void setUp() {
        appServiceMapper = new AppServiceMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(appServiceMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(appServiceMapper.fromId(null)).isNull();
    }
}
