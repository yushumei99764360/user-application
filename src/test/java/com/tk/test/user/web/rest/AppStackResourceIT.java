package com.tk.test.user.web.rest;

import com.tk.test.user.UserApplicationApp;
import com.tk.test.user.domain.AppStack;
import com.tk.test.user.repository.AppStackRepository;
import com.tk.test.user.service.AppStackService;
import com.tk.test.user.service.dto.AppStackDTO;
import com.tk.test.user.service.mapper.AppStackMapper;

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
 * Integration tests for the {@link AppStackResource} REST controller.
 */
@SpringBootTest(classes = UserApplicationApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class AppStackResourceIT {

    private static final String DEFAULT_APP_STACK_NAME = "AAAAAAAAAA";
    private static final String UPDATED_APP_STACK_NAME = "BBBBBBBBBB";

    private static final Long DEFAULT_APP_PROJECT_ID = 1L;
    private static final Long UPDATED_APP_PROJECT_ID = 2L;

    private static final String DEFAULT_PROJECT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_PROJECT_NAME = "BBBBBBBBBB";

    private static final Integer DEFAULT_APP_STACK_ORDER = 1;
    private static final Integer UPDATED_APP_STACK_ORDER = 2;

    private static final Long DEFAULT_ENTRANCE_SERVICE_ID = 1L;
    private static final Long UPDATED_ENTRANCE_SERVICE_ID = 2L;

    private static final Integer DEFAULT_APP_STACK_TYPE = 1;
    private static final Integer UPDATED_APP_STACK_TYPE = 2;

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
    private AppStackRepository appStackRepository;

    @Autowired
    private AppStackMapper appStackMapper;

    @Autowired
    private AppStackService appStackService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restAppStackMockMvc;

    private AppStack appStack;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static AppStack createEntity(EntityManager em) {
        AppStack appStack = new AppStack()
            .appStackName(DEFAULT_APP_STACK_NAME)
            .appProjectId(DEFAULT_APP_PROJECT_ID)
            .projectName(DEFAULT_PROJECT_NAME)
            .appStackOrder(DEFAULT_APP_STACK_ORDER)
            .entranceServiceId(DEFAULT_ENTRANCE_SERVICE_ID)
            .appStackType(DEFAULT_APP_STACK_TYPE)
            .delFlag(DEFAULT_DEL_FLAG)
            .createById(DEFAULT_CREATE_BY_ID)
            .createByName(DEFAULT_CREATE_BY_NAME)
            .createTime(DEFAULT_CREATE_TIME)
            .lastModifierId(DEFAULT_LAST_MODIFIER_ID)
            .lastModifierName(DEFAULT_LAST_MODIFIER_NAME)
            .lastModifyTime(DEFAULT_LAST_MODIFY_TIME);
        return appStack;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static AppStack createUpdatedEntity(EntityManager em) {
        AppStack appStack = new AppStack()
            .appStackName(UPDATED_APP_STACK_NAME)
            .appProjectId(UPDATED_APP_PROJECT_ID)
            .projectName(UPDATED_PROJECT_NAME)
            .appStackOrder(UPDATED_APP_STACK_ORDER)
            .entranceServiceId(UPDATED_ENTRANCE_SERVICE_ID)
            .appStackType(UPDATED_APP_STACK_TYPE)
            .delFlag(UPDATED_DEL_FLAG)
            .createById(UPDATED_CREATE_BY_ID)
            .createByName(UPDATED_CREATE_BY_NAME)
            .createTime(UPDATED_CREATE_TIME)
            .lastModifierId(UPDATED_LAST_MODIFIER_ID)
            .lastModifierName(UPDATED_LAST_MODIFIER_NAME)
            .lastModifyTime(UPDATED_LAST_MODIFY_TIME);
        return appStack;
    }

    @BeforeEach
    public void initTest() {
        appStack = createEntity(em);
    }

    @Test
    @Transactional
    public void createAppStack() throws Exception {
        int databaseSizeBeforeCreate = appStackRepository.findAll().size();
        // Create the AppStack
        AppStackDTO appStackDTO = appStackMapper.toDto(appStack);
        restAppStackMockMvc.perform(post("/api/app-stacks")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(appStackDTO)))
            .andExpect(status().isCreated());

        // Validate the AppStack in the database
        List<AppStack> appStackList = appStackRepository.findAll();
        assertThat(appStackList).hasSize(databaseSizeBeforeCreate + 1);
        AppStack testAppStack = appStackList.get(appStackList.size() - 1);
        assertThat(testAppStack.getAppStackName()).isEqualTo(DEFAULT_APP_STACK_NAME);
        assertThat(testAppStack.getAppProjectId()).isEqualTo(DEFAULT_APP_PROJECT_ID);
        assertThat(testAppStack.getProjectName()).isEqualTo(DEFAULT_PROJECT_NAME);
        assertThat(testAppStack.getAppStackOrder()).isEqualTo(DEFAULT_APP_STACK_ORDER);
        assertThat(testAppStack.getEntranceServiceId()).isEqualTo(DEFAULT_ENTRANCE_SERVICE_ID);
        assertThat(testAppStack.getAppStackType()).isEqualTo(DEFAULT_APP_STACK_TYPE);
        assertThat(testAppStack.getDelFlag()).isEqualTo(DEFAULT_DEL_FLAG);
        assertThat(testAppStack.getCreateById()).isEqualTo(DEFAULT_CREATE_BY_ID);
        assertThat(testAppStack.getCreateByName()).isEqualTo(DEFAULT_CREATE_BY_NAME);
        assertThat(testAppStack.getCreateTime()).isEqualTo(DEFAULT_CREATE_TIME);
        assertThat(testAppStack.getLastModifierId()).isEqualTo(DEFAULT_LAST_MODIFIER_ID);
        assertThat(testAppStack.getLastModifierName()).isEqualTo(DEFAULT_LAST_MODIFIER_NAME);
        assertThat(testAppStack.getLastModifyTime()).isEqualTo(DEFAULT_LAST_MODIFY_TIME);
    }

    @Test
    @Transactional
    public void createAppStackWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = appStackRepository.findAll().size();

        // Create the AppStack with an existing ID
        appStack.setId(1L);
        AppStackDTO appStackDTO = appStackMapper.toDto(appStack);

        // An entity with an existing ID cannot be created, so this API call must fail
        restAppStackMockMvc.perform(post("/api/app-stacks")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(appStackDTO)))
            .andExpect(status().isBadRequest());

        // Validate the AppStack in the database
        List<AppStack> appStackList = appStackRepository.findAll();
        assertThat(appStackList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void checkAppStackNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = appStackRepository.findAll().size();
        // set the field null
        appStack.setAppStackName(null);

        // Create the AppStack, which fails.
        AppStackDTO appStackDTO = appStackMapper.toDto(appStack);


        restAppStackMockMvc.perform(post("/api/app-stacks")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(appStackDTO)))
            .andExpect(status().isBadRequest());

        List<AppStack> appStackList = appStackRepository.findAll();
        assertThat(appStackList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkAppProjectIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = appStackRepository.findAll().size();
        // set the field null
        appStack.setAppProjectId(null);

        // Create the AppStack, which fails.
        AppStackDTO appStackDTO = appStackMapper.toDto(appStack);


        restAppStackMockMvc.perform(post("/api/app-stacks")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(appStackDTO)))
            .andExpect(status().isBadRequest());

        List<AppStack> appStackList = appStackRepository.findAll();
        assertThat(appStackList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkProjectNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = appStackRepository.findAll().size();
        // set the field null
        appStack.setProjectName(null);

        // Create the AppStack, which fails.
        AppStackDTO appStackDTO = appStackMapper.toDto(appStack);


        restAppStackMockMvc.perform(post("/api/app-stacks")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(appStackDTO)))
            .andExpect(status().isBadRequest());

        List<AppStack> appStackList = appStackRepository.findAll();
        assertThat(appStackList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkEntranceServiceIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = appStackRepository.findAll().size();
        // set the field null
        appStack.setEntranceServiceId(null);

        // Create the AppStack, which fails.
        AppStackDTO appStackDTO = appStackMapper.toDto(appStack);


        restAppStackMockMvc.perform(post("/api/app-stacks")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(appStackDTO)))
            .andExpect(status().isBadRequest());

        List<AppStack> appStackList = appStackRepository.findAll();
        assertThat(appStackList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkAppStackTypeIsRequired() throws Exception {
        int databaseSizeBeforeTest = appStackRepository.findAll().size();
        // set the field null
        appStack.setAppStackType(null);

        // Create the AppStack, which fails.
        AppStackDTO appStackDTO = appStackMapper.toDto(appStack);


        restAppStackMockMvc.perform(post("/api/app-stacks")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(appStackDTO)))
            .andExpect(status().isBadRequest());

        List<AppStack> appStackList = appStackRepository.findAll();
        assertThat(appStackList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkDelFlagIsRequired() throws Exception {
        int databaseSizeBeforeTest = appStackRepository.findAll().size();
        // set the field null
        appStack.setDelFlag(null);

        // Create the AppStack, which fails.
        AppStackDTO appStackDTO = appStackMapper.toDto(appStack);


        restAppStackMockMvc.perform(post("/api/app-stacks")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(appStackDTO)))
            .andExpect(status().isBadRequest());

        List<AppStack> appStackList = appStackRepository.findAll();
        assertThat(appStackList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllAppStacks() throws Exception {
        // Initialize the database
        appStackRepository.saveAndFlush(appStack);

        // Get all the appStackList
        restAppStackMockMvc.perform(get("/api/app-stacks?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(appStack.getId().intValue())))
            .andExpect(jsonPath("$.[*].appStackName").value(hasItem(DEFAULT_APP_STACK_NAME)))
            .andExpect(jsonPath("$.[*].appProjectId").value(hasItem(DEFAULT_APP_PROJECT_ID.intValue())))
            .andExpect(jsonPath("$.[*].projectName").value(hasItem(DEFAULT_PROJECT_NAME)))
            .andExpect(jsonPath("$.[*].appStackOrder").value(hasItem(DEFAULT_APP_STACK_ORDER)))
            .andExpect(jsonPath("$.[*].entranceServiceId").value(hasItem(DEFAULT_ENTRANCE_SERVICE_ID.intValue())))
            .andExpect(jsonPath("$.[*].appStackType").value(hasItem(DEFAULT_APP_STACK_TYPE)))
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
    public void getAppStack() throws Exception {
        // Initialize the database
        appStackRepository.saveAndFlush(appStack);

        // Get the appStack
        restAppStackMockMvc.perform(get("/api/app-stacks/{id}", appStack.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(appStack.getId().intValue()))
            .andExpect(jsonPath("$.appStackName").value(DEFAULT_APP_STACK_NAME))
            .andExpect(jsonPath("$.appProjectId").value(DEFAULT_APP_PROJECT_ID.intValue()))
            .andExpect(jsonPath("$.projectName").value(DEFAULT_PROJECT_NAME))
            .andExpect(jsonPath("$.appStackOrder").value(DEFAULT_APP_STACK_ORDER))
            .andExpect(jsonPath("$.entranceServiceId").value(DEFAULT_ENTRANCE_SERVICE_ID.intValue()))
            .andExpect(jsonPath("$.appStackType").value(DEFAULT_APP_STACK_TYPE))
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
    public void getNonExistingAppStack() throws Exception {
        // Get the appStack
        restAppStackMockMvc.perform(get("/api/app-stacks/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateAppStack() throws Exception {
        // Initialize the database
        appStackRepository.saveAndFlush(appStack);

        int databaseSizeBeforeUpdate = appStackRepository.findAll().size();

        // Update the appStack
        AppStack updatedAppStack = appStackRepository.findById(appStack.getId()).get();
        // Disconnect from session so that the updates on updatedAppStack are not directly saved in db
        em.detach(updatedAppStack);
        updatedAppStack
            .appStackName(UPDATED_APP_STACK_NAME)
            .appProjectId(UPDATED_APP_PROJECT_ID)
            .projectName(UPDATED_PROJECT_NAME)
            .appStackOrder(UPDATED_APP_STACK_ORDER)
            .entranceServiceId(UPDATED_ENTRANCE_SERVICE_ID)
            .appStackType(UPDATED_APP_STACK_TYPE)
            .delFlag(UPDATED_DEL_FLAG)
            .createById(UPDATED_CREATE_BY_ID)
            .createByName(UPDATED_CREATE_BY_NAME)
            .createTime(UPDATED_CREATE_TIME)
            .lastModifierId(UPDATED_LAST_MODIFIER_ID)
            .lastModifierName(UPDATED_LAST_MODIFIER_NAME)
            .lastModifyTime(UPDATED_LAST_MODIFY_TIME);
        AppStackDTO appStackDTO = appStackMapper.toDto(updatedAppStack);

        restAppStackMockMvc.perform(put("/api/app-stacks")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(appStackDTO)))
            .andExpect(status().isOk());

        // Validate the AppStack in the database
        List<AppStack> appStackList = appStackRepository.findAll();
        assertThat(appStackList).hasSize(databaseSizeBeforeUpdate);
        AppStack testAppStack = appStackList.get(appStackList.size() - 1);
        assertThat(testAppStack.getAppStackName()).isEqualTo(UPDATED_APP_STACK_NAME);
        assertThat(testAppStack.getAppProjectId()).isEqualTo(UPDATED_APP_PROJECT_ID);
        assertThat(testAppStack.getProjectName()).isEqualTo(UPDATED_PROJECT_NAME);
        assertThat(testAppStack.getAppStackOrder()).isEqualTo(UPDATED_APP_STACK_ORDER);
        assertThat(testAppStack.getEntranceServiceId()).isEqualTo(UPDATED_ENTRANCE_SERVICE_ID);
        assertThat(testAppStack.getAppStackType()).isEqualTo(UPDATED_APP_STACK_TYPE);
        assertThat(testAppStack.getDelFlag()).isEqualTo(UPDATED_DEL_FLAG);
        assertThat(testAppStack.getCreateById()).isEqualTo(UPDATED_CREATE_BY_ID);
        assertThat(testAppStack.getCreateByName()).isEqualTo(UPDATED_CREATE_BY_NAME);
        assertThat(testAppStack.getCreateTime()).isEqualTo(UPDATED_CREATE_TIME);
        assertThat(testAppStack.getLastModifierId()).isEqualTo(UPDATED_LAST_MODIFIER_ID);
        assertThat(testAppStack.getLastModifierName()).isEqualTo(UPDATED_LAST_MODIFIER_NAME);
        assertThat(testAppStack.getLastModifyTime()).isEqualTo(UPDATED_LAST_MODIFY_TIME);
    }

    @Test
    @Transactional
    public void updateNonExistingAppStack() throws Exception {
        int databaseSizeBeforeUpdate = appStackRepository.findAll().size();

        // Create the AppStack
        AppStackDTO appStackDTO = appStackMapper.toDto(appStack);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restAppStackMockMvc.perform(put("/api/app-stacks")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(appStackDTO)))
            .andExpect(status().isBadRequest());

        // Validate the AppStack in the database
        List<AppStack> appStackList = appStackRepository.findAll();
        assertThat(appStackList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteAppStack() throws Exception {
        // Initialize the database
        appStackRepository.saveAndFlush(appStack);

        int databaseSizeBeforeDelete = appStackRepository.findAll().size();

        // Delete the appStack
        restAppStackMockMvc.perform(delete("/api/app-stacks/{id}", appStack.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<AppStack> appStackList = appStackRepository.findAll();
        assertThat(appStackList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
