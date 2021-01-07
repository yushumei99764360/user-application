package com.tk.test.user.web.rest;

import com.tk.test.user.UserApplicationApp;
import com.tk.test.user.domain.AppService;
import com.tk.test.user.repository.AppServiceRepository;
import com.tk.test.user.service.AppServiceService;
import com.tk.test.user.service.dto.AppServiceDTO;
import com.tk.test.user.service.mapper.AppServiceMapper;

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
 * Integration tests for the {@link AppServiceResource} REST controller.
 */
@SpringBootTest(classes = UserApplicationApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class AppServiceResourceIT {

    private static final Long DEFAULT_APP_STACK_ID = 1L;
    private static final Long UPDATED_APP_STACK_ID = 2L;

    private static final String DEFAULT_SERVICE_NAME = "AAAAAAAAAA";
    private static final String UPDATED_SERVICE_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_SERVICE_NAME_ZH = "AAAAAAAAAA";
    private static final String UPDATED_SERVICE_NAME_ZH = "BBBBBBBBBB";

    private static final String DEFAULT_SERVICE_DESCRIBE = "AAAAAAAAAA";
    private static final String UPDATED_SERVICE_DESCRIBE = "BBBBBBBBBB";

    private static final Integer DEFAULT_SERVICE_TYPE = 1;
    private static final Integer UPDATED_SERVICE_TYPE = 2;

    private static final String DEFAULT_GUID = "AAAAAAAAAA";
    private static final String UPDATED_GUID = "BBBBBBBBBB";

    private static final String DEFAULT_GIT_COMPANY = "AAAAAAAAAA";
    private static final String UPDATED_GIT_COMPANY = "BBBBBBBBBB";

    private static final String DEFAULT_GIT_URL = "AAAAAAAAAA";
    private static final String UPDATED_GIT_URL = "BBBBBBBBBB";

    private static final String DEFAULT_REPOSITORY_NAME = "AAAAAAAAAA";
    private static final String UPDATED_REPOSITORY_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_PACKAGE_NAME_SUFFIX = "AAAAAAAAAA";
    private static final String UPDATED_PACKAGE_NAME_SUFFIX = "BBBBBBBBBB";

    private static final Integer DEFAULT_SERVICE_ODER = 1;
    private static final Integer UPDATED_SERVICE_ODER = 2;

    private static final String DEFAULT_COMPANY_ID = "AAAAAAAAAA";
    private static final String UPDATED_COMPANY_ID = "BBBBBBBBBB";

    private static final String DEFAULT_SERVICE_PROVIDER = "AAAAAAAAAA";
    private static final String UPDATED_SERVICE_PROVIDER = "BBBBBBBBBB";

    private static final String DEFAULT_REMARK = "AAAAAAAAAA";
    private static final String UPDATED_REMARK = "BBBBBBBBBB";

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
    private AppServiceRepository appServiceRepository;

    @Autowired
    private AppServiceMapper appServiceMapper;

    @Autowired
    private AppServiceService appServiceService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restAppServiceMockMvc;

    private AppService appService;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static AppService createEntity(EntityManager em) {
        AppService appService = new AppService()
            .appStackId(DEFAULT_APP_STACK_ID)
            .serviceName(DEFAULT_SERVICE_NAME)
            .serviceNameZh(DEFAULT_SERVICE_NAME_ZH)
            .serviceDescribe(DEFAULT_SERVICE_DESCRIBE)
            .serviceType(DEFAULT_SERVICE_TYPE)
            .guid(DEFAULT_GUID)
            .gitCompany(DEFAULT_GIT_COMPANY)
            .gitUrl(DEFAULT_GIT_URL)
            .repositoryName(DEFAULT_REPOSITORY_NAME)
            .packageNameSuffix(DEFAULT_PACKAGE_NAME_SUFFIX)
            .serviceOder(DEFAULT_SERVICE_ODER)
            .companyId(DEFAULT_COMPANY_ID)
            .serviceProvider(DEFAULT_SERVICE_PROVIDER)
            .remark(DEFAULT_REMARK)
            .delFlag(DEFAULT_DEL_FLAG)
            .createById(DEFAULT_CREATE_BY_ID)
            .createByName(DEFAULT_CREATE_BY_NAME)
            .createTime(DEFAULT_CREATE_TIME)
            .lastModifierId(DEFAULT_LAST_MODIFIER_ID)
            .lastModifierName(DEFAULT_LAST_MODIFIER_NAME)
            .lastModifyTime(DEFAULT_LAST_MODIFY_TIME);
        return appService;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static AppService createUpdatedEntity(EntityManager em) {
        AppService appService = new AppService()
            .appStackId(UPDATED_APP_STACK_ID)
            .serviceName(UPDATED_SERVICE_NAME)
            .serviceNameZh(UPDATED_SERVICE_NAME_ZH)
            .serviceDescribe(UPDATED_SERVICE_DESCRIBE)
            .serviceType(UPDATED_SERVICE_TYPE)
            .guid(UPDATED_GUID)
            .gitCompany(UPDATED_GIT_COMPANY)
            .gitUrl(UPDATED_GIT_URL)
            .repositoryName(UPDATED_REPOSITORY_NAME)
            .packageNameSuffix(UPDATED_PACKAGE_NAME_SUFFIX)
            .serviceOder(UPDATED_SERVICE_ODER)
            .companyId(UPDATED_COMPANY_ID)
            .serviceProvider(UPDATED_SERVICE_PROVIDER)
            .remark(UPDATED_REMARK)
            .delFlag(UPDATED_DEL_FLAG)
            .createById(UPDATED_CREATE_BY_ID)
            .createByName(UPDATED_CREATE_BY_NAME)
            .createTime(UPDATED_CREATE_TIME)
            .lastModifierId(UPDATED_LAST_MODIFIER_ID)
            .lastModifierName(UPDATED_LAST_MODIFIER_NAME)
            .lastModifyTime(UPDATED_LAST_MODIFY_TIME);
        return appService;
    }

    @BeforeEach
    public void initTest() {
        appService = createEntity(em);
    }

    @Test
    @Transactional
    public void createAppService() throws Exception {
        int databaseSizeBeforeCreate = appServiceRepository.findAll().size();
        // Create the AppService
        AppServiceDTO appServiceDTO = appServiceMapper.toDto(appService);
        restAppServiceMockMvc.perform(post("/api/app-services")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(appServiceDTO)))
            .andExpect(status().isCreated());

        // Validate the AppService in the database
        List<AppService> appServiceList = appServiceRepository.findAll();
        assertThat(appServiceList).hasSize(databaseSizeBeforeCreate + 1);
        AppService testAppService = appServiceList.get(appServiceList.size() - 1);
        assertThat(testAppService.getAppStackId()).isEqualTo(DEFAULT_APP_STACK_ID);
        assertThat(testAppService.getServiceName()).isEqualTo(DEFAULT_SERVICE_NAME);
        assertThat(testAppService.getServiceNameZh()).isEqualTo(DEFAULT_SERVICE_NAME_ZH);
        assertThat(testAppService.getServiceDescribe()).isEqualTo(DEFAULT_SERVICE_DESCRIBE);
        assertThat(testAppService.getServiceType()).isEqualTo(DEFAULT_SERVICE_TYPE);
        assertThat(testAppService.getGuid()).isEqualTo(DEFAULT_GUID);
        assertThat(testAppService.getGitCompany()).isEqualTo(DEFAULT_GIT_COMPANY);
        assertThat(testAppService.getGitUrl()).isEqualTo(DEFAULT_GIT_URL);
        assertThat(testAppService.getRepositoryName()).isEqualTo(DEFAULT_REPOSITORY_NAME);
        assertThat(testAppService.getPackageNameSuffix()).isEqualTo(DEFAULT_PACKAGE_NAME_SUFFIX);
        assertThat(testAppService.getServiceOder()).isEqualTo(DEFAULT_SERVICE_ODER);
        assertThat(testAppService.getCompanyId()).isEqualTo(DEFAULT_COMPANY_ID);
        assertThat(testAppService.getServiceProvider()).isEqualTo(DEFAULT_SERVICE_PROVIDER);
        assertThat(testAppService.getRemark()).isEqualTo(DEFAULT_REMARK);
        assertThat(testAppService.getDelFlag()).isEqualTo(DEFAULT_DEL_FLAG);
        assertThat(testAppService.getCreateById()).isEqualTo(DEFAULT_CREATE_BY_ID);
        assertThat(testAppService.getCreateByName()).isEqualTo(DEFAULT_CREATE_BY_NAME);
        assertThat(testAppService.getCreateTime()).isEqualTo(DEFAULT_CREATE_TIME);
        assertThat(testAppService.getLastModifierId()).isEqualTo(DEFAULT_LAST_MODIFIER_ID);
        assertThat(testAppService.getLastModifierName()).isEqualTo(DEFAULT_LAST_MODIFIER_NAME);
        assertThat(testAppService.getLastModifyTime()).isEqualTo(DEFAULT_LAST_MODIFY_TIME);
    }

    @Test
    @Transactional
    public void createAppServiceWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = appServiceRepository.findAll().size();

        // Create the AppService with an existing ID
        appService.setId(1L);
        AppServiceDTO appServiceDTO = appServiceMapper.toDto(appService);

        // An entity with an existing ID cannot be created, so this API call must fail
        restAppServiceMockMvc.perform(post("/api/app-services")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(appServiceDTO)))
            .andExpect(status().isBadRequest());

        // Validate the AppService in the database
        List<AppService> appServiceList = appServiceRepository.findAll();
        assertThat(appServiceList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void checkAppStackIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = appServiceRepository.findAll().size();
        // set the field null
        appService.setAppStackId(null);

        // Create the AppService, which fails.
        AppServiceDTO appServiceDTO = appServiceMapper.toDto(appService);


        restAppServiceMockMvc.perform(post("/api/app-services")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(appServiceDTO)))
            .andExpect(status().isBadRequest());

        List<AppService> appServiceList = appServiceRepository.findAll();
        assertThat(appServiceList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkServiceNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = appServiceRepository.findAll().size();
        // set the field null
        appService.setServiceName(null);

        // Create the AppService, which fails.
        AppServiceDTO appServiceDTO = appServiceMapper.toDto(appService);


        restAppServiceMockMvc.perform(post("/api/app-services")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(appServiceDTO)))
            .andExpect(status().isBadRequest());

        List<AppService> appServiceList = appServiceRepository.findAll();
        assertThat(appServiceList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkServiceTypeIsRequired() throws Exception {
        int databaseSizeBeforeTest = appServiceRepository.findAll().size();
        // set the field null
        appService.setServiceType(null);

        // Create the AppService, which fails.
        AppServiceDTO appServiceDTO = appServiceMapper.toDto(appService);


        restAppServiceMockMvc.perform(post("/api/app-services")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(appServiceDTO)))
            .andExpect(status().isBadRequest());

        List<AppService> appServiceList = appServiceRepository.findAll();
        assertThat(appServiceList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkGitCompanyIsRequired() throws Exception {
        int databaseSizeBeforeTest = appServiceRepository.findAll().size();
        // set the field null
        appService.setGitCompany(null);

        // Create the AppService, which fails.
        AppServiceDTO appServiceDTO = appServiceMapper.toDto(appService);


        restAppServiceMockMvc.perform(post("/api/app-services")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(appServiceDTO)))
            .andExpect(status().isBadRequest());

        List<AppService> appServiceList = appServiceRepository.findAll();
        assertThat(appServiceList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkRepositoryNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = appServiceRepository.findAll().size();
        // set the field null
        appService.setRepositoryName(null);

        // Create the AppService, which fails.
        AppServiceDTO appServiceDTO = appServiceMapper.toDto(appService);


        restAppServiceMockMvc.perform(post("/api/app-services")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(appServiceDTO)))
            .andExpect(status().isBadRequest());

        List<AppService> appServiceList = appServiceRepository.findAll();
        assertThat(appServiceList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkPackageNameSuffixIsRequired() throws Exception {
        int databaseSizeBeforeTest = appServiceRepository.findAll().size();
        // set the field null
        appService.setPackageNameSuffix(null);

        // Create the AppService, which fails.
        AppServiceDTO appServiceDTO = appServiceMapper.toDto(appService);


        restAppServiceMockMvc.perform(post("/api/app-services")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(appServiceDTO)))
            .andExpect(status().isBadRequest());

        List<AppService> appServiceList = appServiceRepository.findAll();
        assertThat(appServiceList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkDelFlagIsRequired() throws Exception {
        int databaseSizeBeforeTest = appServiceRepository.findAll().size();
        // set the field null
        appService.setDelFlag(null);

        // Create the AppService, which fails.
        AppServiceDTO appServiceDTO = appServiceMapper.toDto(appService);


        restAppServiceMockMvc.perform(post("/api/app-services")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(appServiceDTO)))
            .andExpect(status().isBadRequest());

        List<AppService> appServiceList = appServiceRepository.findAll();
        assertThat(appServiceList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllAppServices() throws Exception {
        // Initialize the database
        appServiceRepository.saveAndFlush(appService);

        // Get all the appServiceList
        restAppServiceMockMvc.perform(get("/api/app-services?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(appService.getId().intValue())))
            .andExpect(jsonPath("$.[*].appStackId").value(hasItem(DEFAULT_APP_STACK_ID.intValue())))
            .andExpect(jsonPath("$.[*].serviceName").value(hasItem(DEFAULT_SERVICE_NAME)))
            .andExpect(jsonPath("$.[*].serviceNameZh").value(hasItem(DEFAULT_SERVICE_NAME_ZH)))
            .andExpect(jsonPath("$.[*].serviceDescribe").value(hasItem(DEFAULT_SERVICE_DESCRIBE)))
            .andExpect(jsonPath("$.[*].serviceType").value(hasItem(DEFAULT_SERVICE_TYPE)))
            .andExpect(jsonPath("$.[*].guid").value(hasItem(DEFAULT_GUID)))
            .andExpect(jsonPath("$.[*].gitCompany").value(hasItem(DEFAULT_GIT_COMPANY)))
            .andExpect(jsonPath("$.[*].gitUrl").value(hasItem(DEFAULT_GIT_URL)))
            .andExpect(jsonPath("$.[*].repositoryName").value(hasItem(DEFAULT_REPOSITORY_NAME)))
            .andExpect(jsonPath("$.[*].packageNameSuffix").value(hasItem(DEFAULT_PACKAGE_NAME_SUFFIX)))
            .andExpect(jsonPath("$.[*].serviceOder").value(hasItem(DEFAULT_SERVICE_ODER)))
            .andExpect(jsonPath("$.[*].companyId").value(hasItem(DEFAULT_COMPANY_ID)))
            .andExpect(jsonPath("$.[*].serviceProvider").value(hasItem(DEFAULT_SERVICE_PROVIDER)))
            .andExpect(jsonPath("$.[*].remark").value(hasItem(DEFAULT_REMARK)))
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
    public void getAppService() throws Exception {
        // Initialize the database
        appServiceRepository.saveAndFlush(appService);

        // Get the appService
        restAppServiceMockMvc.perform(get("/api/app-services/{id}", appService.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(appService.getId().intValue()))
            .andExpect(jsonPath("$.appStackId").value(DEFAULT_APP_STACK_ID.intValue()))
            .andExpect(jsonPath("$.serviceName").value(DEFAULT_SERVICE_NAME))
            .andExpect(jsonPath("$.serviceNameZh").value(DEFAULT_SERVICE_NAME_ZH))
            .andExpect(jsonPath("$.serviceDescribe").value(DEFAULT_SERVICE_DESCRIBE))
            .andExpect(jsonPath("$.serviceType").value(DEFAULT_SERVICE_TYPE))
            .andExpect(jsonPath("$.guid").value(DEFAULT_GUID))
            .andExpect(jsonPath("$.gitCompany").value(DEFAULT_GIT_COMPANY))
            .andExpect(jsonPath("$.gitUrl").value(DEFAULT_GIT_URL))
            .andExpect(jsonPath("$.repositoryName").value(DEFAULT_REPOSITORY_NAME))
            .andExpect(jsonPath("$.packageNameSuffix").value(DEFAULT_PACKAGE_NAME_SUFFIX))
            .andExpect(jsonPath("$.serviceOder").value(DEFAULT_SERVICE_ODER))
            .andExpect(jsonPath("$.companyId").value(DEFAULT_COMPANY_ID))
            .andExpect(jsonPath("$.serviceProvider").value(DEFAULT_SERVICE_PROVIDER))
            .andExpect(jsonPath("$.remark").value(DEFAULT_REMARK))
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
    public void getNonExistingAppService() throws Exception {
        // Get the appService
        restAppServiceMockMvc.perform(get("/api/app-services/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateAppService() throws Exception {
        // Initialize the database
        appServiceRepository.saveAndFlush(appService);

        int databaseSizeBeforeUpdate = appServiceRepository.findAll().size();

        // Update the appService
        AppService updatedAppService = appServiceRepository.findById(appService.getId()).get();
        // Disconnect from session so that the updates on updatedAppService are not directly saved in db
        em.detach(updatedAppService);
        updatedAppService
            .appStackId(UPDATED_APP_STACK_ID)
            .serviceName(UPDATED_SERVICE_NAME)
            .serviceNameZh(UPDATED_SERVICE_NAME_ZH)
            .serviceDescribe(UPDATED_SERVICE_DESCRIBE)
            .serviceType(UPDATED_SERVICE_TYPE)
            .guid(UPDATED_GUID)
            .gitCompany(UPDATED_GIT_COMPANY)
            .gitUrl(UPDATED_GIT_URL)
            .repositoryName(UPDATED_REPOSITORY_NAME)
            .packageNameSuffix(UPDATED_PACKAGE_NAME_SUFFIX)
            .serviceOder(UPDATED_SERVICE_ODER)
            .companyId(UPDATED_COMPANY_ID)
            .serviceProvider(UPDATED_SERVICE_PROVIDER)
            .remark(UPDATED_REMARK)
            .delFlag(UPDATED_DEL_FLAG)
            .createById(UPDATED_CREATE_BY_ID)
            .createByName(UPDATED_CREATE_BY_NAME)
            .createTime(UPDATED_CREATE_TIME)
            .lastModifierId(UPDATED_LAST_MODIFIER_ID)
            .lastModifierName(UPDATED_LAST_MODIFIER_NAME)
            .lastModifyTime(UPDATED_LAST_MODIFY_TIME);
        AppServiceDTO appServiceDTO = appServiceMapper.toDto(updatedAppService);

        restAppServiceMockMvc.perform(put("/api/app-services")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(appServiceDTO)))
            .andExpect(status().isOk());

        // Validate the AppService in the database
        List<AppService> appServiceList = appServiceRepository.findAll();
        assertThat(appServiceList).hasSize(databaseSizeBeforeUpdate);
        AppService testAppService = appServiceList.get(appServiceList.size() - 1);
        assertThat(testAppService.getAppStackId()).isEqualTo(UPDATED_APP_STACK_ID);
        assertThat(testAppService.getServiceName()).isEqualTo(UPDATED_SERVICE_NAME);
        assertThat(testAppService.getServiceNameZh()).isEqualTo(UPDATED_SERVICE_NAME_ZH);
        assertThat(testAppService.getServiceDescribe()).isEqualTo(UPDATED_SERVICE_DESCRIBE);
        assertThat(testAppService.getServiceType()).isEqualTo(UPDATED_SERVICE_TYPE);
        assertThat(testAppService.getGuid()).isEqualTo(UPDATED_GUID);
        assertThat(testAppService.getGitCompany()).isEqualTo(UPDATED_GIT_COMPANY);
        assertThat(testAppService.getGitUrl()).isEqualTo(UPDATED_GIT_URL);
        assertThat(testAppService.getRepositoryName()).isEqualTo(UPDATED_REPOSITORY_NAME);
        assertThat(testAppService.getPackageNameSuffix()).isEqualTo(UPDATED_PACKAGE_NAME_SUFFIX);
        assertThat(testAppService.getServiceOder()).isEqualTo(UPDATED_SERVICE_ODER);
        assertThat(testAppService.getCompanyId()).isEqualTo(UPDATED_COMPANY_ID);
        assertThat(testAppService.getServiceProvider()).isEqualTo(UPDATED_SERVICE_PROVIDER);
        assertThat(testAppService.getRemark()).isEqualTo(UPDATED_REMARK);
        assertThat(testAppService.getDelFlag()).isEqualTo(UPDATED_DEL_FLAG);
        assertThat(testAppService.getCreateById()).isEqualTo(UPDATED_CREATE_BY_ID);
        assertThat(testAppService.getCreateByName()).isEqualTo(UPDATED_CREATE_BY_NAME);
        assertThat(testAppService.getCreateTime()).isEqualTo(UPDATED_CREATE_TIME);
        assertThat(testAppService.getLastModifierId()).isEqualTo(UPDATED_LAST_MODIFIER_ID);
        assertThat(testAppService.getLastModifierName()).isEqualTo(UPDATED_LAST_MODIFIER_NAME);
        assertThat(testAppService.getLastModifyTime()).isEqualTo(UPDATED_LAST_MODIFY_TIME);
    }

    @Test
    @Transactional
    public void updateNonExistingAppService() throws Exception {
        int databaseSizeBeforeUpdate = appServiceRepository.findAll().size();

        // Create the AppService
        AppServiceDTO appServiceDTO = appServiceMapper.toDto(appService);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restAppServiceMockMvc.perform(put("/api/app-services")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(appServiceDTO)))
            .andExpect(status().isBadRequest());

        // Validate the AppService in the database
        List<AppService> appServiceList = appServiceRepository.findAll();
        assertThat(appServiceList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteAppService() throws Exception {
        // Initialize the database
        appServiceRepository.saveAndFlush(appService);

        int databaseSizeBeforeDelete = appServiceRepository.findAll().size();

        // Delete the appService
        restAppServiceMockMvc.perform(delete("/api/app-services/{id}", appService.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<AppService> appServiceList = appServiceRepository.findAll();
        assertThat(appServiceList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
