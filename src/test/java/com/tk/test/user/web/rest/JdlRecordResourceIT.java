package com.tk.test.user.web.rest;

import com.tk.test.user.UserApplicationApp;
import com.tk.test.user.domain.JdlRecord;
import com.tk.test.user.repository.JdlRecordRepository;
import com.tk.test.user.service.JdlRecordService;
import com.tk.test.user.service.dto.JdlRecordDTO;
import com.tk.test.user.service.mapper.JdlRecordMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Base64Utils;
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
 * Integration tests for the {@link JdlRecordResource} REST controller.
 */
@SpringBootTest(classes = UserApplicationApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class JdlRecordResourceIT {

    private static final Long DEFAULT_SERVICE_ID = 1L;
    private static final Long UPDATED_SERVICE_ID = 2L;

    private static final byte[] DEFAULT_CONTENT = TestUtil.createByteArray(1, "0");
    private static final byte[] UPDATED_CONTENT = TestUtil.createByteArray(1, "1");
    private static final String DEFAULT_CONTENT_CONTENT_TYPE = "image/jpg";
    private static final String UPDATED_CONTENT_CONTENT_TYPE = "image/png";

    private static final String DEFAULT_MESSAGE = "AAAAAAAAAA";
    private static final String UPDATED_MESSAGE = "BBBBBBBBBB";

    private static final String DEFAULT_GUID = "AAAAAAAAAA";
    private static final String UPDATED_GUID = "BBBBBBBBBB";

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
    private JdlRecordRepository jdlRecordRepository;

    @Autowired
    private JdlRecordMapper jdlRecordMapper;

    @Autowired
    private JdlRecordService jdlRecordService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restJdlRecordMockMvc;

    private JdlRecord jdlRecord;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static JdlRecord createEntity(EntityManager em) {
        JdlRecord jdlRecord = new JdlRecord()
            .serviceId(DEFAULT_SERVICE_ID)
            .content(DEFAULT_CONTENT)
            .contentContentType(DEFAULT_CONTENT_CONTENT_TYPE)
            .message(DEFAULT_MESSAGE)
            .guid(DEFAULT_GUID)
            .delFlag(DEFAULT_DEL_FLAG)
            .createById(DEFAULT_CREATE_BY_ID)
            .createByName(DEFAULT_CREATE_BY_NAME)
            .createTime(DEFAULT_CREATE_TIME)
            .lastModifierId(DEFAULT_LAST_MODIFIER_ID)
            .lastModifierName(DEFAULT_LAST_MODIFIER_NAME)
            .lastModifyTime(DEFAULT_LAST_MODIFY_TIME);
        return jdlRecord;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static JdlRecord createUpdatedEntity(EntityManager em) {
        JdlRecord jdlRecord = new JdlRecord()
            .serviceId(UPDATED_SERVICE_ID)
            .content(UPDATED_CONTENT)
            .contentContentType(UPDATED_CONTENT_CONTENT_TYPE)
            .message(UPDATED_MESSAGE)
            .guid(UPDATED_GUID)
            .delFlag(UPDATED_DEL_FLAG)
            .createById(UPDATED_CREATE_BY_ID)
            .createByName(UPDATED_CREATE_BY_NAME)
            .createTime(UPDATED_CREATE_TIME)
            .lastModifierId(UPDATED_LAST_MODIFIER_ID)
            .lastModifierName(UPDATED_LAST_MODIFIER_NAME)
            .lastModifyTime(UPDATED_LAST_MODIFY_TIME);
        return jdlRecord;
    }

    @BeforeEach
    public void initTest() {
        jdlRecord = createEntity(em);
    }

    @Test
    @Transactional
    public void createJdlRecord() throws Exception {
        int databaseSizeBeforeCreate = jdlRecordRepository.findAll().size();
        // Create the JdlRecord
        JdlRecordDTO jdlRecordDTO = jdlRecordMapper.toDto(jdlRecord);
        restJdlRecordMockMvc.perform(post("/api/jdl-records")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(jdlRecordDTO)))
            .andExpect(status().isCreated());

        // Validate the JdlRecord in the database
        List<JdlRecord> jdlRecordList = jdlRecordRepository.findAll();
        assertThat(jdlRecordList).hasSize(databaseSizeBeforeCreate + 1);
        JdlRecord testJdlRecord = jdlRecordList.get(jdlRecordList.size() - 1);
        assertThat(testJdlRecord.getServiceId()).isEqualTo(DEFAULT_SERVICE_ID);
        assertThat(testJdlRecord.getContent()).isEqualTo(DEFAULT_CONTENT);
        assertThat(testJdlRecord.getContentContentType()).isEqualTo(DEFAULT_CONTENT_CONTENT_TYPE);
        assertThat(testJdlRecord.getMessage()).isEqualTo(DEFAULT_MESSAGE);
        assertThat(testJdlRecord.getGuid()).isEqualTo(DEFAULT_GUID);
        assertThat(testJdlRecord.getDelFlag()).isEqualTo(DEFAULT_DEL_FLAG);
        assertThat(testJdlRecord.getCreateById()).isEqualTo(DEFAULT_CREATE_BY_ID);
        assertThat(testJdlRecord.getCreateByName()).isEqualTo(DEFAULT_CREATE_BY_NAME);
        assertThat(testJdlRecord.getCreateTime()).isEqualTo(DEFAULT_CREATE_TIME);
        assertThat(testJdlRecord.getLastModifierId()).isEqualTo(DEFAULT_LAST_MODIFIER_ID);
        assertThat(testJdlRecord.getLastModifierName()).isEqualTo(DEFAULT_LAST_MODIFIER_NAME);
        assertThat(testJdlRecord.getLastModifyTime()).isEqualTo(DEFAULT_LAST_MODIFY_TIME);
    }

    @Test
    @Transactional
    public void createJdlRecordWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = jdlRecordRepository.findAll().size();

        // Create the JdlRecord with an existing ID
        jdlRecord.setId(1L);
        JdlRecordDTO jdlRecordDTO = jdlRecordMapper.toDto(jdlRecord);

        // An entity with an existing ID cannot be created, so this API call must fail
        restJdlRecordMockMvc.perform(post("/api/jdl-records")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(jdlRecordDTO)))
            .andExpect(status().isBadRequest());

        // Validate the JdlRecord in the database
        List<JdlRecord> jdlRecordList = jdlRecordRepository.findAll();
        assertThat(jdlRecordList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void checkServiceIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = jdlRecordRepository.findAll().size();
        // set the field null
        jdlRecord.setServiceId(null);

        // Create the JdlRecord, which fails.
        JdlRecordDTO jdlRecordDTO = jdlRecordMapper.toDto(jdlRecord);


        restJdlRecordMockMvc.perform(post("/api/jdl-records")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(jdlRecordDTO)))
            .andExpect(status().isBadRequest());

        List<JdlRecord> jdlRecordList = jdlRecordRepository.findAll();
        assertThat(jdlRecordList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkGuidIsRequired() throws Exception {
        int databaseSizeBeforeTest = jdlRecordRepository.findAll().size();
        // set the field null
        jdlRecord.setGuid(null);

        // Create the JdlRecord, which fails.
        JdlRecordDTO jdlRecordDTO = jdlRecordMapper.toDto(jdlRecord);


        restJdlRecordMockMvc.perform(post("/api/jdl-records")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(jdlRecordDTO)))
            .andExpect(status().isBadRequest());

        List<JdlRecord> jdlRecordList = jdlRecordRepository.findAll();
        assertThat(jdlRecordList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkDelFlagIsRequired() throws Exception {
        int databaseSizeBeforeTest = jdlRecordRepository.findAll().size();
        // set the field null
        jdlRecord.setDelFlag(null);

        // Create the JdlRecord, which fails.
        JdlRecordDTO jdlRecordDTO = jdlRecordMapper.toDto(jdlRecord);


        restJdlRecordMockMvc.perform(post("/api/jdl-records")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(jdlRecordDTO)))
            .andExpect(status().isBadRequest());

        List<JdlRecord> jdlRecordList = jdlRecordRepository.findAll();
        assertThat(jdlRecordList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllJdlRecords() throws Exception {
        // Initialize the database
        jdlRecordRepository.saveAndFlush(jdlRecord);

        // Get all the jdlRecordList
        restJdlRecordMockMvc.perform(get("/api/jdl-records?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(jdlRecord.getId().intValue())))
            .andExpect(jsonPath("$.[*].serviceId").value(hasItem(DEFAULT_SERVICE_ID.intValue())))
            .andExpect(jsonPath("$.[*].contentContentType").value(hasItem(DEFAULT_CONTENT_CONTENT_TYPE)))
            .andExpect(jsonPath("$.[*].content").value(hasItem(Base64Utils.encodeToString(DEFAULT_CONTENT))))
            .andExpect(jsonPath("$.[*].message").value(hasItem(DEFAULT_MESSAGE)))
            .andExpect(jsonPath("$.[*].guid").value(hasItem(DEFAULT_GUID)))
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
    public void getJdlRecord() throws Exception {
        // Initialize the database
        jdlRecordRepository.saveAndFlush(jdlRecord);

        // Get the jdlRecord
        restJdlRecordMockMvc.perform(get("/api/jdl-records/{id}", jdlRecord.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(jdlRecord.getId().intValue()))
            .andExpect(jsonPath("$.serviceId").value(DEFAULT_SERVICE_ID.intValue()))
            .andExpect(jsonPath("$.contentContentType").value(DEFAULT_CONTENT_CONTENT_TYPE))
            .andExpect(jsonPath("$.content").value(Base64Utils.encodeToString(DEFAULT_CONTENT)))
            .andExpect(jsonPath("$.message").value(DEFAULT_MESSAGE))
            .andExpect(jsonPath("$.guid").value(DEFAULT_GUID))
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
    public void getNonExistingJdlRecord() throws Exception {
        // Get the jdlRecord
        restJdlRecordMockMvc.perform(get("/api/jdl-records/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateJdlRecord() throws Exception {
        // Initialize the database
        jdlRecordRepository.saveAndFlush(jdlRecord);

        int databaseSizeBeforeUpdate = jdlRecordRepository.findAll().size();

        // Update the jdlRecord
        JdlRecord updatedJdlRecord = jdlRecordRepository.findById(jdlRecord.getId()).get();
        // Disconnect from session so that the updates on updatedJdlRecord are not directly saved in db
        em.detach(updatedJdlRecord);
        updatedJdlRecord
            .serviceId(UPDATED_SERVICE_ID)
            .content(UPDATED_CONTENT)
            .contentContentType(UPDATED_CONTENT_CONTENT_TYPE)
            .message(UPDATED_MESSAGE)
            .guid(UPDATED_GUID)
            .delFlag(UPDATED_DEL_FLAG)
            .createById(UPDATED_CREATE_BY_ID)
            .createByName(UPDATED_CREATE_BY_NAME)
            .createTime(UPDATED_CREATE_TIME)
            .lastModifierId(UPDATED_LAST_MODIFIER_ID)
            .lastModifierName(UPDATED_LAST_MODIFIER_NAME)
            .lastModifyTime(UPDATED_LAST_MODIFY_TIME);
        JdlRecordDTO jdlRecordDTO = jdlRecordMapper.toDto(updatedJdlRecord);

        restJdlRecordMockMvc.perform(put("/api/jdl-records")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(jdlRecordDTO)))
            .andExpect(status().isOk());

        // Validate the JdlRecord in the database
        List<JdlRecord> jdlRecordList = jdlRecordRepository.findAll();
        assertThat(jdlRecordList).hasSize(databaseSizeBeforeUpdate);
        JdlRecord testJdlRecord = jdlRecordList.get(jdlRecordList.size() - 1);
        assertThat(testJdlRecord.getServiceId()).isEqualTo(UPDATED_SERVICE_ID);
        assertThat(testJdlRecord.getContent()).isEqualTo(UPDATED_CONTENT);
        assertThat(testJdlRecord.getContentContentType()).isEqualTo(UPDATED_CONTENT_CONTENT_TYPE);
        assertThat(testJdlRecord.getMessage()).isEqualTo(UPDATED_MESSAGE);
        assertThat(testJdlRecord.getGuid()).isEqualTo(UPDATED_GUID);
        assertThat(testJdlRecord.getDelFlag()).isEqualTo(UPDATED_DEL_FLAG);
        assertThat(testJdlRecord.getCreateById()).isEqualTo(UPDATED_CREATE_BY_ID);
        assertThat(testJdlRecord.getCreateByName()).isEqualTo(UPDATED_CREATE_BY_NAME);
        assertThat(testJdlRecord.getCreateTime()).isEqualTo(UPDATED_CREATE_TIME);
        assertThat(testJdlRecord.getLastModifierId()).isEqualTo(UPDATED_LAST_MODIFIER_ID);
        assertThat(testJdlRecord.getLastModifierName()).isEqualTo(UPDATED_LAST_MODIFIER_NAME);
        assertThat(testJdlRecord.getLastModifyTime()).isEqualTo(UPDATED_LAST_MODIFY_TIME);
    }

    @Test
    @Transactional
    public void updateNonExistingJdlRecord() throws Exception {
        int databaseSizeBeforeUpdate = jdlRecordRepository.findAll().size();

        // Create the JdlRecord
        JdlRecordDTO jdlRecordDTO = jdlRecordMapper.toDto(jdlRecord);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restJdlRecordMockMvc.perform(put("/api/jdl-records")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(jdlRecordDTO)))
            .andExpect(status().isBadRequest());

        // Validate the JdlRecord in the database
        List<JdlRecord> jdlRecordList = jdlRecordRepository.findAll();
        assertThat(jdlRecordList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteJdlRecord() throws Exception {
        // Initialize the database
        jdlRecordRepository.saveAndFlush(jdlRecord);

        int databaseSizeBeforeDelete = jdlRecordRepository.findAll().size();

        // Delete the jdlRecord
        restJdlRecordMockMvc.perform(delete("/api/jdl-records/{id}", jdlRecord.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<JdlRecord> jdlRecordList = jdlRecordRepository.findAll();
        assertThat(jdlRecordList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
