package com.tk.test.user.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class AppUserMapperTest {

    private AppUserMapper appUserMapper;

    @BeforeEach
    public void setUp() {
        appUserMapper = new AppUserMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(appUserMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(appUserMapper.fromId(null)).isNull();
    }
}
