package com.tk.test.user.web.rest;

import com.tk.test.user.UserApplicationApp;
import com.tk.test.user.domain.AppServiceNote;
import com.tk.test.user.repository.AppServiceNoteRepository;
import com.tk.test.user.service.AppServiceNoteService;
import com.tk.test.user.service.dto.AppServiceNoteDTO;
import com.tk.test.user.service.mapper.AppServiceNoteMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.ZoneOffset;
import java.time.ZoneId;
import java.util.List;

import static com.tk.test.user.web.rest.TestUtil.sameInstant;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link AppServiceNoteResource} REST controller.
 */
@SpringBootTest(classes = UserApplicationApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class AppServiceNoteResourceIT {

    private static final Long DEFAULT_SERVICE_ID = 1L;
    private static final Long UPDATED_SERVICE_ID = 2L;

    private static final String DEFAULT_TITLE = "AAAAAAAAAA";
    private static final String UPDATED_TITLE = "BBBBBBBBBB";

    private static final String DEFAULT_CONTENT = "AAAAAAAAAA";
    private static final String UPDATED_CONTENT = "BBBBBBBBBB";

    private static final Integer DEFAULT_NOTE_ORDER = 1;
    private static final Integer UPDATED_NOTE_ORDER = 2;

    private static final Integer DEFAULT_DEL_FLAG = 1;
    private static final Integer UPDATED_DEL_FLAG = 2;

    private static final String DEFAULT_CREATE_BY_ID = "AAAAAAAAAA";
    private static final String UPDATED_CREATE_BY_ID = "BBBBBBBBBB";

    private static final String DEFAULT_CREATE_BY_NAME = "AAAAAAAAAA";
    private static final String UPDATED_CREATE_BY_NAME = "BBBBBBBBBB";

    private static final ZonedDateTime DEFAULT_CREATE_TIME = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_CREATE_TIME = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final String DEFAULT_LAST_MODIFIER_ID = "AAAAAAAAAA";
    private static final String UPDATED_LAST_MODIFIER_ID = "BBBBBBBBBB";

    private static final String DEFAULT_LAST_MODIFIER_NAME = "AAAAAAAAAA";
    private static final String UPDATED_LAST_MODIFIER_NAME = "BBBBBBBBBB";

    private static final ZonedDateTime DEFAULT_LAST_MODIFY_TIME = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_LAST_MODIFY_TIME = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    @Autowired
    private AppServiceNoteRepository appServiceNoteRepository;

    @Autowired
    private AppServiceNoteMapper appServiceNoteMapper;

    @Autowired
    private AppServiceNoteService appServiceNoteService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restAppServiceNoteMockMvc;

    private AppServiceNote appServiceNote;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static AppServiceNote createEntity(EntityManager em) {
        AppServiceNote appServiceNote = new AppServiceNote()
            .serviceId(DEFAULT_SERVICE_ID)
            .title(DEFAULT_TITLE)
            .content(DEFAULT_CONTENT)
            .noteOrder(DEFAULT_NOTE_ORDER)
            .delFlag(DEFAULT_DEL_FLAG)
            .createById(DEFAULT_CREATE_BY_ID)
            .createByName(DEFAULT_CREATE_BY_NAME)
            .createTime(DEFAULT_CREATE_TIME)
            .lastModifierId(DEFAULT_LAST_MODIFIER_ID)
            .lastModifierName(DEFAULT_LAST_MODIFIER_NAME)
            .lastModifyTime(DEFAULT_LAST_MODIFY_TIME);
        return appServiceNote;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static AppServiceNote createUpdatedEntity(EntityManager em) {
        AppServiceNote appServiceNote = new AppServiceNote()
            .serviceId(UPDATED_SERVICE_ID)
            .title(UPDATED_TITLE)
            .content(UPDATED_CONTENT)
            .noteOrder(UPDATED_NOTE_ORDER)
            .delFlag(UPDATED_DEL_FLAG)
            .createById(UPDATED_CREATE_BY_ID)
            .createByName(UPDATED_CREATE_BY_NAME)
            .createTime(UPDATED_CREATE_TIME)
            .lastModifierId(UPDATED_LAST_MODIFIER_ID)
            .lastModifierName(UPDATED_LAST_MODIFIER_NAME)
            .lastModifyTime(UPDATED_LAST_MODIFY_TIME);
        return appServiceNote;
    }

    @BeforeEach
    public void initTest() {
        appServiceNote = createEntity(em);
    }

    @Test
    @Transactional
    public void createAppServiceNote() throws Exception {
        int databaseSizeBeforeCreate = appServiceNoteRepository.findAll().size();
        // Create the AppServiceNote
        AppServiceNoteDTO appServiceNoteDTO = appServiceNoteMapper.toDto(appServiceNote);
        restAppServiceNoteMockMvc.perform(post("/api/app-service-notes")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(appServiceNoteDTO)))
            .andExpect(status().isCreated());

        // Validate the AppServiceNote in the database
        List<AppServiceNote> appServiceNoteList = appServiceNoteRepository.findAll();
        assertThat(appServiceNoteList).hasSize(databaseSizeBeforeCreate + 1);
        AppServiceNote testAppServiceNote = appServiceNoteList.get(appServiceNoteList.size() - 1);
        assertThat(testAppServiceNote.getServiceId()).isEqualTo(DEFAULT_SERVICE_ID);
        assertThat(testAppServiceNote.getTitle()).isEqualTo(DEFAULT_TITLE);
        assertThat(testAppServiceNote.getContent()).isEqualTo(DEFAULT_CONTENT);
        assertThat(testAppServiceNote.getNoteOrder()).isEqualTo(DEFAULT_NOTE_ORDER);
        assertThat(testAppServiceNote.getDelFlag()).isEqualTo(DEFAULT_DEL_FLAG);
        assertThat(testAppServiceNote.getCreateById()).isEqualTo(DEFAULT_CREATE_BY_ID);
        assertThat(testAppServiceNote.getCreateByName()).isEqualTo(DEFAULT_CREATE_BY_NAME);
        assertThat(testAppServiceNote.getCreateTime()).isEqualTo(DEFAULT_CREATE_TIME);
        assertThat(testAppServiceNote.getLastModifierId()).isEqualTo(DEFAULT_LAST_MODIFIER_ID);
        assertThat(testAppServiceNote.getLastModifierName()).isEqualTo(DEFAULT_LAST_MODIFIER_NAME);
        assertThat(testAppServiceNote.getLastModifyTime()).isEqualTo(DEFAULT_LAST_MODIFY_TIME);
    }

    @Test
    @Transactional
    public void createAppServiceNoteWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = appServiceNoteRepository.findAll().size();

        // Create the AppServiceNote with an existing ID
        appServiceNote.setId(1L);
        AppServiceNoteDTO appServiceNoteDTO = appServiceNoteMapper.toDto(appServiceNote);

        // An entity with an existing ID cannot be created, so this API call must fail
        restAppServiceNoteMockMvc.perform(post("/api/app-service-notes")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(appServiceNoteDTO)))
            .andExpect(status().isBadRequest());

        // Validate the AppServiceNote in the database
        List<AppServiceNote> appServiceNoteList = appServiceNoteRepository.findAll();
        assertThat(appServiceNoteList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void checkServiceIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = appServiceNoteRepository.findAll().size();
        // set the field null
        appServiceNote.setServiceId(null);

        // Create the AppServiceNote, which fails.
        AppServiceNoteDTO appServiceNoteDTO = appServiceNoteMapper.toDto(appServiceNote);


        restAppServiceNoteMockMvc.perform(post("/api/app-service-notes")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(appServiceNoteDTO)))
            .andExpect(status().isBadRequest());

        List<AppServiceNote> appServiceNoteList = appServiceNoteRepository.findAll();
        assertThat(appServiceNoteList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkDelFlagIsRequired() throws Exception {
        int databaseSizeBeforeTest = appServiceNoteRepository.findAll().size();
        // set the field null
        appServiceNote.setDelFlag(null);

        // Create the AppServiceNote, which fails.
        AppServiceNoteDTO appServiceNoteDTO = appServiceNoteMapper.toDto(appServiceNote);


        restAppServiceNoteMockMvc.perform(post("/api/app-service-notes")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(appServiceNoteDTO)))
            .andExpect(status().isBadRequest());

        List<AppServiceNote> appServiceNoteList = appServiceNoteRepository.findAll();
        assertThat(appServiceNoteList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllAppServiceNotes() throws Exception {
        // Initialize the database
        appServiceNoteRepository.saveAndFlush(appServiceNote);

        // Get all the appServiceNoteList
        restAppServiceNoteMockMvc.perform(get("/api/app-service-notes?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(appServiceNote.getId().intValue())))
            .andExpect(jsonPath("$.[*].serviceId").value(hasItem(DEFAULT_SERVICE_ID.intValue())))
            .andExpect(jsonPath("$.[*].title").value(hasItem(DEFAULT_TITLE)))
            .andExpect(jsonPath("$.[*].content").value(hasItem(DEFAULT_CONTENT)))
            .andExpect(jsonPath("$.[*].noteOrder").value(hasItem(DEFAULT_NOTE_ORDER)))
            .andExpect(jsonPath("$.[*].delFlag").value(hasItem(DEFAULT_DEL_FLAG)))
            .andExpect(jsonPath("$.[*].createById").value(hasItem(DEFAULT_CREATE_BY_ID)))
            .andExpect(jsonPath("$.[*].createByName").value(hasItem(DEFAULT_CREATE_BY_NAME)))
            .andExpect(jsonPath("$.[*].createTime").value(hasItem(sameInstant(DEFAULT_CREATE_TIME))))
            .andExpect(jsonPath("$.[*].lastModifierId").value(hasItem(DEFAULT_LAST_MODIFIER_ID)))
            .andExpect(jsonPath("$.[*].lastModifierName").value(hasItem(DEFAULT_LAST_MODIFIER_NAME)))
            .andExpect(jsonPath("$.[*].lastModifyTime").value(hasItem(sameInstant(DEFAULT_LAST_MODIFY_TIME))));
    }
    
    @Test
    @Transactional
    public void getAppServiceNote() throws Exception {
        // Initialize the database
        appServiceNoteRepository.saveAndFlush(appServiceNote);

        // Get the appServiceNote
        restAppServiceNoteMockMvc.perform(get("/api/app-service-notes/{id}", appServiceNote.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(appServiceNote.getId().intValue()))
            .andExpect(jsonPath("$.serviceId").value(DEFAULT_SERVICE_ID.intValue()))
            .andExpect(jsonPath("$.title").value(DEFAULT_TITLE))
            .andExpect(jsonPath("$.content").value(DEFAULT_CONTENT))
            .andExpect(jsonPath("$.noteOrder").value(DEFAULT_NOTE_ORDER))
            .andExpect(jsonPath("$.delFlag").value(DEFAULT_DEL_FLAG))
            .andExpect(jsonPath("$.createById").value(DEFAULT_CREATE_BY_ID))
            .andExpect(jsonPath("$.createByName").value(DEFAULT_CREATE_BY_NAME))
            .andExpect(jsonPath("$.createTime").value(sameInstant(DEFAULT_CREATE_TIME)))
            .andExpect(jsonPath("$.lastModifierId").value(DEFAULT_LAST_MODIFIER_ID))
            .andExpect(jsonPath("$.lastModifierName").value(DEFAULT_LAST_MODIFIER_NAME))
            .andExpect(jsonPath("$.lastModifyTime").value(sameInstant(DEFAULT_LAST_MODIFY_TIME)));
    }
    @Test
    @Transactional
    public void getNonExistingAppServiceNote() throws Exception {
        // Get the appServiceNote
        restAppServiceNoteMockMvc.perform(get("/api/app-service-notes/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateAppServiceNote() throws Exception {
        // Initialize the database
        appServiceNoteRepository.saveAndFlush(appServiceNote);

        int databaseSizeBeforeUpdate = appServiceNoteRepository.findAll().size();

        // Update the appServiceNote
        AppServiceNote updatedAppServiceNote = appServiceNoteRepository.findById(appServiceNote.getId()).get();
        // Disconnect from session so that the updates on updatedAppServiceNote are not directly saved in db
        em.detach(updatedAppServiceNote);
        updatedAppServiceNote
            .serviceId(UPDATED_SERVICE_ID)
            .title(UPDATED_TITLE)
            .content(UPDATED_CONTENT)
            .noteOrder(UPDATED_NOTE_ORDER)
            .delFlag(UPDATED_DEL_FLAG)
            .createById(UPDATED_CREATE_BY_ID)
            .createByName(UPDATED_CREATE_BY_NAME)
            .createTime(UPDATED_CREATE_TIME)
            .lastModifierId(UPDATED_LAST_MODIFIER_ID)
            .lastModifierName(UPDATED_LAST_MODIFIER_NAME)
            .lastModifyTime(UPDATED_LAST_MODIFY_TIME);
        AppServiceNoteDTO appServiceNoteDTO = appServiceNoteMapper.toDto(updatedAppServiceNote);

        restAppServiceNoteMockMvc.perform(put("/api/app-service-notes")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(appServiceNoteDTO)))
            .andExpect(status().isOk());

        // Validate the AppServiceNote in the database
        List<AppServiceNote> appServiceNoteList = appServiceNoteRepository.findAll();
        assertThat(appServiceNoteList).hasSize(databaseSizeBeforeUpdate);
        AppServiceNote testAppServiceNote = appServiceNoteList.get(appServiceNoteList.size() - 1);
        assertThat(testAppServiceNote.getServiceId()).isEqualTo(UPDATED_SERVICE_ID);
        assertThat(testAppServiceNote.getTitle()).isEqualTo(UPDATED_TITLE);
        assertThat(testAppServiceNote.getContent()).isEqualTo(UPDATED_CONTENT);
        assertThat(testAppServiceNote.getNoteOrder()).isEqualTo(UPDATED_NOTE_ORDER);
        assertThat(testAppServiceNote.getDelFlag()).isEqualTo(UPDATED_DEL_FLAG);
        assertThat(testAppServiceNote.getCreateById()).isEqualTo(UPDATED_CREATE_BY_ID);
        assertThat(testAppServiceNote.getCreateByName()).isEqualTo(UPDATED_CREATE_BY_NAME);
        assertThat(testAppServiceNote.getCreateTime()).isEqualTo(UPDATED_CREATE_TIME);
        assertThat(testAppServiceNote.getLastModifierId()).isEqualTo(UPDATED_LAST_MODIFIER_ID);
        assertThat(testAppServiceNote.getLastModifierName()).isEqualTo(UPDATED_LAST_MODIFIER_NAME);
        assertThat(testAppServiceNote.getLastModifyTime()).isEqualTo(UPDATED_LAST_MODIFY_TIME);
    }

    @Test
    @Transactional
    public void updateNonExistingAppServiceNote() throws Exception {
        int databaseSizeBeforeUpdate = appServiceNoteRepository.findAll().size();

        // Create the AppServiceNote
        AppServiceNoteDTO appServiceNoteDTO = appServiceNoteMapper.toDto(appServiceNote);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restAppServiceNoteMockMvc.perform(put("/api/app-service-notes")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(appServiceNoteDTO)))
            .andExpect(status().isBadRequest());

        // Validate the AppServiceNote in the database
        List<AppServiceNote> appServiceNoteList = appServiceNoteRepository.findAll();
        assertThat(appServiceNoteList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteAppServiceNote() throws Exception {
        // Initialize the database
        appServiceNoteRepository.saveAndFlush(appServiceNote);

        int databaseSizeBeforeDelete = appServiceNoteRepository.findAll().size();

        // Delete the appServiceNote
        restAppServiceNoteMockMvc.perform(delete("/api/app-service-notes/{id}", appServiceNote.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<AppServiceNote> appServiceNoteList = appServiceNoteRepository.findAll();
        assertThat(appServiceNoteList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
