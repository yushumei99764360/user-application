package com.tk.test.user.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class AppServiceNoteMapperTest {

    private AppServiceNoteMapper appServiceNoteMapper;

    @BeforeEach
    public void setUp() {
        appServiceNoteMapper = new AppServiceNoteMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 1L;
        assertThat(appServiceNoteMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(appServiceNoteMapper.fromId(null)).isNull();
    }
}
