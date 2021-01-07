package com.tk.test.user.service;

import com.tk.test.user.domain.AppProject;
import com.tk.test.user.repository.AppProjectRepository;
import com.tk.test.user.service.dto.AppProjectDTO;
import com.tk.test.user.service.mapper.AppProjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link AppProject}.
 */
@Service
@Transactional
public class AppProjectService {

    private final Logger log = LoggerFactory.getLogger(AppProjectService.class);

    private final AppProjectRepository appProjectRepository;

    private final AppProjectMapper appProjectMapper;

    public AppProjectService(AppProjectRepository appProjectRepository, AppProjectMapper appProjectMapper) {
        this.appProjectRepository = appProjectRepository;
        this.appProjectMapper = appProjectMapper;
    }

    /**
     * Save a appProject.
     *
     * @param appProjectDTO the entity to save.
     * @return the persisted entity.
     */
    public AppProjectDTO save(AppProjectDTO appProjectDTO) {
        log.debug("Request to save AppProject : {}", appProjectDTO);
        AppProject appProject = appProjectMapper.toEntity(appProjectDTO);
        appProject = appProjectRepository.save(appProject);
        return appProjectMapper.toDto(appProject);
    }

    /**
     * Get all the appProjects.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<AppProjectDTO> findAll(Pageable pageable) {
        log.debug("Request to get all AppProjects");
        return appProjectRepository.findAll(pageable)
            .map(appProjectMapper::toDto);
    }


    /**
     * Get one appProject by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<AppProjectDTO> findOne(Long id) {
        log.debug("Request to get AppProject : {}", id);
        return appProjectRepository.findById(id)
            .map(appProjectMapper::toDto);
    }

    /**
     * Delete the appProject by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete AppProject : {}", id);
        appProjectRepository.deleteById(id);
    }
}
