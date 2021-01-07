package com.tk.test.user.web.rest;

import com.tk.test.user.UserApplicationApp;
import com.tk.test.user.domain.AppServiceProfile;
import com.tk.test.user.repository.AppServiceProfileRepository;
import com.tk.test.user.service.AppServiceProfileService;
import com.tk.test.user.service.dto.AppServiceProfileDTO;
import com.tk.test.user.service.mapper.AppServiceProfileMapper;

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
 * Integration tests for the {@link AppServiceProfileResource} REST controller.
 */
@SpringBootTest(classes = UserApplicationApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class AppServiceProfileResourceIT {

    private static final Long DEFAULT_SERVICE_ID = 1L;
    private static final Long UPDATED_SERVICE_ID = 2L;

    private static final Integer DEFAULT_NOTE_ORDER = 1;
    private static final Integer UPDATED_NOTE_ORDER = 2;

    private static final String DEFAULT_ENV_NAME = "AAAAAAAAAA";
    private static final String UPDATED_ENV_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_ENV_DESCRIBE = "AAAAAAAAAA";
    private static final String UPDATED_ENV_DESCRIBE = "BBBBBBBBBB";

    private static final String DEFAULT_BRANCH_NAME = "AAAAAAAAAA";
    private static final String UPDATED_BRANCH_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_IMAGE_TAG = "AAAAAAAAAA";
    private static final String UPDATED_IMAGE_TAG = "BBBBBBBBBB";

    private static final String DEFAULT_SERVICE_VERSION = "AAAAAAAAAA";
    private static final String UPDATED_SERVICE_VERSION = "BBBBBBBBBB";

    private static final Integer DEFAULT_STATUS = 1;
    private static final Integer UPDATED_STATUS = 2;

    private static final Integer DEFAULT_SERVICE_PORT = 1;
    private static final Integer UPDATED_SERVICE_PORT = 2;

    private static final String DEFAULT_ENTRANCE_URL = "AAAAAAAAAA";
    private static final String UPDATED_ENTRANCE_URL = "BBBBBBBBBB";

    private static final String DEFAULT_API_URL = "AAAAAAAAAA";
    private static final String UPDATED_API_URL = "BBBBBBBBBB";

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
    private AppServiceProfileRepository appServiceProfileRepository;

    @Autowired
    private AppServiceProfileMapper appServiceProfileMapper;

    @Autowired
    private AppServiceProfileService appServiceProfileService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restAppServiceProfileMockMvc;

    private AppServiceProfile appServiceProfile;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static AppServiceProfile createEntity(EntityManager em) {
        AppServiceProfile appServiceProfile = new AppServiceProfile()
            .serviceId(DEFAULT_SERVICE_ID)
            .noteOrder(DEFAULT_NOTE_ORDER)
            .envName(DEFAULT_ENV_NAME)
            .envDescribe(DEFAULT_ENV_DESCRIBE)
            .branchName(DEFAULT_BRANCH_NAME)
            .imageTag(DEFAULT_IMAGE_TAG)
            .serviceVersion(DEFAULT_SERVICE_VERSION)
            .status(DEFAULT_STATUS)
            .servicePort(DEFAULT_SERVICE_PORT)
            .entranceUrl(DEFAULT_ENTRANCE_URL)
            .apiUrl(DEFAULT_API_URL)
            .delFlag(DEFAULT_DEL_FLAG)
            .createById(DEFAULT_CREATE_BY_ID)
            .createByName(DEFAULT_CREATE_BY_NAME)
            .createTime(DEFAULT_CREATE_TIME)
            .lastModifierId(DEFAULT_LAST_MODIFIER_ID)
            .lastModifierName(DEFAULT_LAST_MODIFIER_NAME)
            .lastModifyTime(DEFAULT_LAST_MODIFY_TIME);
        return appServiceProfile;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static AppServiceProfile createUpdatedEntity(EntityManager em) {
        AppServiceProfile appServiceProfile = new AppServiceProfile()
            .serviceId(UPDATED_SERVICE_ID)
            .noteOrder(UPDATED_NOTE_ORDER)
            .envName(UPDATED_ENV_NAME)
            .envDescribe(UPDATED_ENV_DESCRIBE)
            .branchName(UPDATED_BRANCH_NAME)
            .imageTag(UPDATED_IMAGE_TAG)
            .serviceVersion(UPDATED_SERVICE_VERSION)
            .status(UPDATED_STATUS)
            .servicePort(UPDATED_SERVICE_PORT)
            .entranceUrl(UPDATED_ENTRANCE_URL)
            .apiUrl(UPDATED_API_URL)
            .delFlag(UPDATED_DEL_FLAG)
            .createById(UPDATED_CREATE_BY_ID)
            .createByName(UPDATED_CREATE_BY_NAME)
            .createTime(UPDATED_CREATE_TIME)
            .lastModifierId(UPDATED_LAST_MODIFIER_ID)
            .lastModifierName(UPDATED_LAST_MODIFIER_NAME)
            .lastModifyTime(UPDATED_LAST_MODIFY_TIME);
        return appServiceProfile;
    }

    @BeforeEach
    public void initTest() {
        appServiceProfile = createEntity(em);
    }

    @Test
    @Transactional
    public void createAppServiceProfile() throws Exception {
        int databaseSizeBeforeCreate = appServiceProfileRepository.findAll().size();
        // Create the AppServiceProfile
        AppServiceProfileDTO appServiceProfileDTO = appServiceProfileMapper.toDto(appServiceProfile);
        restAppServiceProfileMockMvc.perform(post("/api/app-service-profiles")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(appServiceProfileDTO)))
            .andExpect(status().isCreated());

        // Validate the AppServiceProfile in the database
        List<AppServiceProfile> appServiceProfileList = appServiceProfileRepository.findAll();
        assertThat(appServiceProfileList).hasSize(databaseSizeBeforeCreate + 1);
        AppServiceProfile testAppServiceProfile = appServiceProfileList.get(appServiceProfileList.size() - 1);
        assertThat(testAppServiceProfile.getServiceId()).isEqualTo(DEFAULT_SERVICE_ID);
        assertThat(testAppServiceProfile.getNoteOrder()).isEqualTo(DEFAULT_NOTE_ORDER);
        assertThat(testAppServiceProfile.getEnvName()).isEqualTo(DEFAULT_ENV_NAME);
        assertThat(testAppServiceProfile.getEnvDescribe()).isEqualTo(DEFAULT_ENV_DESCRIBE);
        assertThat(testAppServiceProfile.getBranchName()).isEqualTo(DEFAULT_BRANCH_NAME);
        assertThat(testAppServiceProfile.getImageTag()).isEqualTo(DEFAULT_IMAGE_TAG);
        assertThat(testAppServiceProfile.getServiceVersion()).isEqualTo(DEFAULT_SERVICE_VERSION);
        assertThat(testAppServiceProfile.getStatus()).isEqualTo(DEFAULT_STATUS);
        assertThat(testAppServiceProfile.getServicePort()).isEqualTo(DEFAULT_SERVICE_PORT);
        assertThat(testAppServiceProfile.getEntranceUrl()).isEqualTo(DEFAULT_ENTRANCE_URL);
        assertThat(testAppServiceProfile.getApiUrl()).isEqualTo(DEFAULT_API_URL);
        assertThat(testAppServiceProfile.getDelFlag()).isEqualTo(DEFAULT_DEL_FLAG);
        assertThat(testAppServiceProfile.getCreateById()).isEqualTo(DEFAULT_CREATE_BY_ID);
        assertThat(testAppServiceProfile.getCreateByName()).isEqualTo(DEFAULT_CREATE_BY_NAME);
        assertThat(testAppServiceProfile.getCreateTime()).isEqualTo(DEFAULT_CREATE_TIME);
        assertThat(testAppServiceProfile.getLastModifierId()).isEqualTo(DEFAULT_LAST_MODIFIER_ID);
        assertThat(testAppServiceProfile.getLastModifierName()).isEqualTo(DEFAULT_LAST_MODIFIER_NAME);
        assertThat(testAppServiceProfile.getLastModifyTime()).isEqualTo(DEFAULT_LAST_MODIFY_TIME);
    }

    @Test
    @Transactional
    public void createAppServiceProfileWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = appServiceProfileRepository.findAll().size();

        // Create the AppServiceProfile with an existing ID
        appServiceProfile.setId(1L);
        AppServiceProfileDTO appServiceProfileDTO = appServiceProfileMapper.toDto(appServiceProfile);

        // An entity with an existing ID cannot be created, so this API call must fail
        restAppServiceProfileMockMvc.perform(post("/api/app-service-profiles")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(appServiceProfileDTO)))
            .andExpect(status().isBadRequest());

        // Validate the AppServiceProfile in the database
        List<AppServiceProfile> appServiceProfileList = appServiceProfileRepository.findAll();
        assertThat(appServiceProfileList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void checkServiceIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = appServiceProfileRepository.findAll().size();
        // set the field null
        appServiceProfile.setServiceId(null);

        // Create the AppServiceProfile, which fails.
        AppServiceProfileDTO appServiceProfileDTO = appServiceProfileMapper.toDto(appServiceProfile);


        restAppServiceProfileMockMvc.perform(post("/api/app-service-profiles")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(appServiceProfileDTO)))
            .andExpect(status().isBadRequest());

        List<AppServiceProfile> appServiceProfileList = appServiceProfileRepository.findAll();
        assertThat(appServiceProfileList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkStatusIsRequired() throws Exception {
        int databaseSizeBeforeTest = appServiceProfileRepository.findAll().size();
        // set the field null
        appServiceProfile.setStatus(null);

        // Create the AppServiceProfile, which fails.
        AppServiceProfileDTO appServiceProfileDTO = appServiceProfileMapper.toDto(appServiceProfile);


        restAppServiceProfileMockMvc.perform(post("/api/app-service-profiles")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(appServiceProfileDTO)))
            .andExpect(status().isBadRequest());

        List<AppServiceProfile> appServiceProfileList = appServiceProfileRepository.findAll();
        assertThat(appServiceProfileList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkServicePortIsRequired() throws Exception {
        int databaseSizeBeforeTest = appServiceProfileRepository.findAll().size();
        // set the field null
        appServiceProfile.setServicePort(null);

        // Create the AppServiceProfile, which fails.
        AppServiceProfileDTO appServiceProfileDTO = appServiceProfileMapper.toDto(appServiceProfile);


        restAppServiceProfileMockMvc.perform(post("/api/app-service-profiles")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(appServiceProfileDTO)))
            .andExpect(status().isBadRequest());

        List<AppServiceProfile> appServiceProfileList = appServiceProfileRepository.findAll();
        assertThat(appServiceProfileList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkDelFlagIsRequired() throws Exception {
        int databaseSizeBeforeTest = appServiceProfileRepository.findAll().size();
        // set the field null
        appServiceProfile.setDelFlag(null);

        // Create the AppServiceProfile, which fails.
        AppServiceProfileDTO appServiceProfileDTO = appServiceProfileMapper.toDto(appServiceProfile);


        restAppServiceProfileMockMvc.perform(post("/api/app-service-profiles")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(appServiceProfileDTO)))
            .andExpect(status().isBadRequest());

        List<AppServiceProfile> appServiceProfileList = appServiceProfileRepository.findAll();
        assertThat(appServiceProfileList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllAppServiceProfiles() throws Exception {
        // Initialize the database
        appServiceProfileRepository.saveAndFlush(appServiceProfile);

        // Get all the appServiceProfileList
        restAppServiceProfileMockMvc.perform(get("/api/app-service-profiles?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(appServiceProfile.getId().intValue())))
            .andExpect(jsonPath("$.[*].serviceId").value(hasItem(DEFAULT_SERVICE_ID.intValue())))
            .andExpect(jsonPath("$.[*].noteOrder").value(hasItem(DEFAULT_NOTE_ORDER)))
            .andExpect(jsonPath("$.[*].envName").value(hasItem(DEFAULT_ENV_NAME)))
            .andExpect(jsonPath("$.[*].envDescribe").value(hasItem(DEFAULT_ENV_DESCRIBE)))
            .andExpect(jsonPath("$.[*].branchName").value(hasItem(DEFAULT_BRANCH_NAME)))
            .andExpect(jsonPath("$.[*].imageTag").value(hasItem(DEFAULT_IMAGE_TAG)))
            .andExpect(jsonPath("$.[*].serviceVersion").value(hasItem(DEFAULT_SERVICE_VERSION)))
            .andExpect(jsonPath("$.[*].status").value(hasItem(DEFAULT_STATUS)))
            .andExpect(jsonPath("$.[*].servicePort").value(hasItem(DEFAULT_SERVICE_PORT)))
            .andExpect(jsonPath("$.[*].entranceUrl").value(hasItem(DEFAULT_ENTRANCE_URL)))
            .andExpect(jsonPath("$.[*].apiUrl").value(hasItem(DEFAULT_API_URL)))
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
    public void getAppServiceProfile() throws Exception {
        // Initialize the database
        appServiceProfileRepository.saveAndFlush(appServiceProfile);

        // Get the appServiceProfile
        restAppServiceProfileMockMvc.perform(get("/api/app-service-profiles/{id}", appServiceProfile.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(appServiceProfile.getId().intValue()))
            .andExpect(jsonPath("$.serviceId").value(DEFAULT_SERVICE_ID.intValue()))
            .andExpect(jsonPath("$.noteOrder").value(DEFAULT_NOTE_ORDER))
            .andExpect(jsonPath("$.envName").value(DEFAULT_ENV_NAME))
            .andExpect(jsonPath("$.envDescribe").value(DEFAULT_ENV_DESCRIBE))
            .andExpect(jsonPath("$.branchName").value(DEFAULT_BRANCH_NAME))
            .andExpect(jsonPath("$.imageTag").value(DEFAULT_IMAGE_TAG))
            .andExpect(jsonPath("$.serviceVersion").value(DEFAULT_SERVICE_VERSION))
            .andExpect(jsonPath("$.status").value(DEFAULT_STATUS))
            .andExpect(jsonPath("$.servicePort").value(DEFAULT_SERVICE_PORT))
            .andExpect(jsonPath("$.entranceUrl").value(DEFAULT_ENTRANCE_URL))
            .andExpect(jsonPath("$.apiUrl").value(DEFAULT_API_URL))
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
    public void getNonExistingAppServiceProfile() throws Exception {
        // Get the appServiceProfile
        restAppServiceProfileMockMvc.perform(get("/api/app-service-profiles/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateAppServiceProfile() throws Exception {
        // Initialize the database
        appServiceProfileRepository.saveAndFlush(appServiceProfile);

        int databaseSizeBeforeUpdate = appServiceProfileRepository.findAll().size();

        // Update the appServiceProfile
        AppServiceProfile updatedAppServiceProfile = appServiceProfileRepository.findById(appServiceProfile.getId()).get();
        // Disconnect from session so that the updates on updatedAppServiceProfile are not directly saved in db
        em.detach(updatedAppServiceProfile);
        updatedAppServiceProfile
            .serviceId(UPDATED_SERVICE_ID)
            .noteOrder(UPDATED_NOTE_ORDER)
            .envName(UPDATED_ENV_NAME)
            .envDescribe(UPDATED_ENV_DESCRIBE)
            .branchName(UPDATED_BRANCH_NAME)
            .imageTag(UPDATED_IMAGE_TAG)
            .serviceVersion(UPDATED_SERVICE_VERSION)
            .status(UPDATED_STATUS)
            .servicePort(UPDATED_SERVICE_PORT)
            .entranceUrl(UPDATED_ENTRANCE_URL)
            .apiUrl(UPDATED_API_URL)
            .delFlag(UPDATED_DEL_FLAG)
            .createById(UPDATED_CREATE_BY_ID)
            .createByName(UPDATED_CREATE_BY_NAME)
            .createTime(UPDATED_CREATE_TIME)
            .lastModifierId(UPDATED_LAST_MODIFIER_ID)
            .lastModifierName(UPDATED_LAST_MODIFIER_NAME)
            .lastModifyTime(UPDATED_LAST_MODIFY_TIME);
        AppServiceProfileDTO appServiceProfileDTO = appServiceProfileMapper.toDto(updatedAppServiceProfile);

        restAppServiceProfileMockMvc.perform(put("/api/app-service-profiles")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(appServiceProfileDTO)))
            .andExpect(status().isOk());

        // Validate the AppServiceProfile in the database
        List<AppServiceProfile> appServiceProfileList = appServiceProfileRepository.findAll();
        assertThat(appServiceProfileList).hasSize(databaseSizeBeforeUpdate);
        AppServiceProfile testAppServiceProfile = appServiceProfileList.get(appServiceProfileList.size() - 1);
        assertThat(testAppServiceProfile.getServiceId()).isEqualTo(UPDATED_SERVICE_ID);
        assertThat(testAppServiceProfile.getNoteOrder()).isEqualTo(UPDATED_NOTE_ORDER);
        assertThat(testAppServiceProfile.getEnvName()).isEqualTo(UPDATED_ENV_NAME);
        assertThat(testAppServiceProfile.getEnvDescribe()).isEqualTo(UPDATED_ENV_DESCRIBE);
        assertThat(testAppServiceProfile.getBranchName()).isEqualTo(UPDATED_BRANCH_NAME);
        assertThat(testAppServiceProfile.getImageTag()).isEqualTo(UPDATED_IMAGE_TAG);
        assertThat(testAppServiceProfile.getServiceVersion()).isEqualTo(UPDATED_SERVICE_VERSION);
        assertThat(testAppServiceProfile.getStatus()).isEqualTo(UPDATED_STATUS);
        assertThat(testAppServiceProfile.getServicePort()).isEqualTo(UPDATED_SERVICE_PORT);
        assertThat(testAppServiceProfile.getEntranceUrl()).isEqualTo(UPDATED_ENTRANCE_URL);
        assertThat(testAppServiceProfile.getApiUrl()).isEqualTo(UPDATED_API_URL);
        assertThat(testAppServiceProfile.getDelFlag()).isEqualTo(UPDATED_DEL_FLAG);
        assertThat(testAppServiceProfile.getCreateById()).isEqualTo(UPDATED_CREATE_BY_ID);
        assertThat(testAppServiceProfile.getCreateByName()).isEqualTo(UPDATED_CREATE_BY_NAME);
        assertThat(testAppServiceProfile.getCreateTime()).isEqualTo(UPDATED_CREATE_TIME);
        assertThat(testAppServiceProfile.getLastModifierId()).isEqualTo(UPDATED_LAST_MODIFIER_ID);
        assertThat(testAppServiceProfile.getLastModifierName()).isEqualTo(UPDATED_LAST_MODIFIER_NAME);
        assertThat(testAppServiceProfile.getLastModifyTime()).isEqualTo(UPDATED_LAST_MODIFY_TIME);
    }

    @Test
    @Transactional
    public void updateNonExistingAppServiceProfile() throws Exception {
        int databaseSizeBeforeUpdate = appServiceProfileRepository.findAll().size();

        // Create the AppServiceProfile
        AppServiceProfileDTO appServiceProfileDTO = appServiceProfileMapper.toDto(appServiceProfile);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restAppServiceProfileMockMvc.perform(put("/api/app-service-profiles")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(appServiceProfileDTO)))
            .andExpect(status().isBadRequest());

        // Validate the AppServiceProfile in the database
        List<AppServiceProfile> appServiceProfileList = appServiceProfileRepository.findAll();
        assertThat(appServiceProfileList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteAppServiceProfile() throws Exception {
        // Initialize the database
        appServiceProfileRepository.saveAndFlush(appServiceProfile);

        int databaseSizeBeforeDelete = appServiceProfileRepository.findAll().size();

        // Delete the appServiceProfile
        restAppServiceProfileMockMvc.perform(delete("/api/app-service-profiles/{id}", appServiceProfile.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<AppServiceProfile> appServiceProfileList = appServiceProfileRepository.findAll();
        assertThat(appServiceProfileList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
