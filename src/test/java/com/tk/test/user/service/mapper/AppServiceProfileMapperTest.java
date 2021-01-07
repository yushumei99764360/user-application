package com.tk.test.user.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class AppServiceProfileMapperTest {

    private AppServiceProfileMapper appServiceProfileMapper;

    @BeforeEach
    public void setUp() {
        appServiceProfileMapper = new AppServiceProfileMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(appServiceProfileMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(appServiceProfileMapper.fromId(null)).isNull();
    }
}
