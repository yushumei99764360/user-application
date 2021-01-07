package com.tk.test.user.web.rest;

import com.tk.test.user.UserApplicationApp;
import com.tk.test.user.domain.AppProject;
import com.tk.test.user.repository.AppProjectRepository;
import com.tk.test.user.service.AppProjectService;
import com.tk.test.user.service.dto.AppProjectDTO;
import com.tk.test.user.service.mapper.AppProjectMapper;

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
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link AppProjectResource} REST controller.
 */
@SpringBootTest(classes = UserApplicationApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class AppProjectResourceIT {

    private static final String DEFAULT_PROJECT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_PROJECT_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_PROJECT_DESCRIPTION = "AAAAAAAAAA";
    private static final String UPDATED_PROJECT_DESCRIPTION = "BBBBBBBBBB";

    @Autowired
    private AppProjectRepository appProjectRepository;

    @Autowired
    private AppProjectMapper appProjectMapper;

    @Autowired
    private AppProjectService appProjectService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restAppProjectMockMvc;

    private AppProject appProject;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static AppProject createEntity(EntityManager em) {
        AppProject appProject = new AppProject()
            .projectName(DEFAULT_PROJECT_NAME)
            .projectDescription(DEFAULT_PROJECT_DESCRIPTION);
        return appProject;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static AppProject createUpdatedEntity(EntityManager em) {
        AppProject appProject = new AppProject()
            .projectName(UPDATED_PROJECT_NAME)
            .projectDescription(UPDATED_PROJECT_DESCRIPTION);
        return appProject;
    }

    @BeforeEach
    public void initTest() {
        appProject = createEntity(em);
    }

    @Test
    @Transactional
    public void createAppProject() throws Exception {
        int databaseSizeBeforeCreate = appProjectRepository.findAll().size();
        // Create the AppProject
        AppProjectDTO appProjectDTO = appProjectMapper.toDto(appProject);
        restAppProjectMockMvc.perform(post("/api/app-projects")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(appProjectDTO)))
            .andExpect(status().isCreated());

        // Validate the AppProject in the database
        List<AppProject> appProjectList = appProjectRepository.findAll();
        assertThat(appProjectList).hasSize(databaseSizeBeforeCreate + 1);
        AppProject testAppProject = appProjectList.get(appProjectList.size() - 1);
        assertThat(testAppProject.getProjectName()).isEqualTo(DEFAULT_PROJECT_NAME);
        assertThat(testAppProject.getProjectDescription()).isEqualTo(DEFAULT_PROJECT_DESCRIPTION);
    }

    @Test
    @Transactional
    public void createAppProjectWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = appProjectRepository.findAll().size();

        // Create the AppProject with an existing ID
        appProject.setId(1L);
        AppProjectDTO appProjectDTO = appProjectMapper.toDto(appProject);

        // An entity with an existing ID cannot be created, so this API call must fail
        restAppProjectMockMvc.perform(post("/api/app-projects")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(appProjectDTO)))
            .andExpect(status().isBadRequest());

        // Validate the AppProject in the database
        List<AppProject> appProjectList = appProjectRepository.findAll();
        assertThat(appProjectList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllAppProjects() throws Exception {
        // Initialize the database
        appProjectRepository.saveAndFlush(appProject);

        // Get all the appProjectList
        restAppProjectMockMvc.perform(get("/api/app-projects?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(appProject.getId().intValue())))
            .andExpect(jsonPath("$.[*].projectName").value(hasItem(DEFAULT_PROJECT_NAME)))
            .andExpect(jsonPath("$.[*].projectDescription").value(hasItem(DEFAULT_PROJECT_DESCRIPTION)));
    }
    
    @Test
    @Transactional
    public void getAppProject() throws Exception {
        // Initialize the database
        appProjectRepository.saveAndFlush(appProject);

        // Get the appProject
        restAppProjectMockMvc.perform(get("/api/app-projects/{id}", appProject.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(appProject.getId().intValue()))
            .andExpect(jsonPath("$.projectName").value(DEFAULT_PROJECT_NAME))
            .andExpect(jsonPath("$.projectDescription").value(DEFAULT_PROJECT_DESCRIPTION));
    }
    @Test
    @Transactional
    public void getNonExistingAppProject() throws Exception {
        // Get the appProject
        restAppProjectMockMvc.perform(get("/api/app-projects/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateAppProject() throws Exception {
        // Initialize the database
        appProjectRepository.saveAndFlush(appProject);

        int databaseSizeBeforeUpdate = appProjectRepository.findAll().size();

        // Update the appProject
        AppProject updatedAppProject = appProjectRepository.findById(appProject.getId()).get();
        // Disconnect from session so that the updates on updatedAppProject are not directly saved in db
        em.detach(updatedAppProject);
        updatedAppProject
            .projectName(UPDATED_PROJECT_NAME)
            .projectDescription(UPDATED_PROJECT_DESCRIPTION);
        AppProjectDTO appProjectDTO = appProjectMapper.toDto(updatedAppProject);

        restAppProjectMockMvc.perform(put("/api/app-projects")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(appProjectDTO)))
            .andExpect(status().isOk());

        // Validate the AppProject in the database
        List<AppProject> appProjectList = appProjectRepository.findAll();
        assertThat(appProjectList).hasSize(databaseSizeBeforeUpdate);
        AppProject testAppProject = appProjectList.get(appProjectList.size() - 1);
        assertThat(testAppProject.getProjectName()).isEqualTo(UPDATED_PROJECT_NAME);
        assertThat(testAppProject.getProjectDescription()).isEqualTo(UPDATED_PROJECT_DESCRIPTION);
    }

    @Test
    @Transactional
    public void updateNonExistingAppProject() throws Exception {
        int databaseSizeBeforeUpdate = appProjectRepository.findAll().size();

        // Create the AppProject
        AppProjectDTO appProjectDTO = appProjectMapper.toDto(appProject);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restAppProjectMockMvc.perform(put("/api/app-projects")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(appProjectDTO)))
            .andExpect(status().isBadRequest());

        // Validate the AppProject in the database
        List<AppProject> appProjectList = appProjectRepository.findAll();
        assertThat(appProjectList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteAppProject() throws Exception {
        // Initialize the database
        appProjectRepository.saveAndFlush(appProject);

        int databaseSizeBeforeDelete = appProjectRepository.findAll().size();

        // Delete the appProject
        restAppProjectMockMvc.perform(delete("/api/app-projects/{id}", appProject.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<AppProject> appProjectList = appProjectRepository.findAll();
        assertThat(appProjectList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
