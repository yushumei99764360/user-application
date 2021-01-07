package com.tk.test.user.service;

import com.tk.test.user.domain.AppStack;
import com.tk.test.user.repository.AppStackRepository;
import com.tk.test.user.service.dto.AppStackDTO;
import com.tk.test.user.service.mapper.AppStackMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link AppStack}.
 */
@Service
@Transactional
public class AppStackService {

    private final Logger log = LoggerFactory.getLogger(AppStackService.class);

    private final AppStackRepository appStackRepository;

    private final AppStackMapper appStackMapper;

    public AppStackService(AppStackRepository appStackRepository, AppStackMapper appStackMapper) {
        this.appStackRepository = appStackRepository;
        this.appStackMapper = appStackMapper;
    }

    /**
     * Save a appStack.
     *
     * @param appStackDTO the entity to save.
     * @return the persisted entity.
     */
    public AppStackDTO save(AppStackDTO appStackDTO) {
        log.debug("Request to save AppStack : {}", appStackDTO);
        AppStack appStack = appStackMapper.toEntity(appStackDTO);
        appStack = appStackRepository.save(appStack);
        return appStackMapper.toDto(appStack);
    }

    /**
     * Get all the appStacks.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<AppStackDTO> findAll(Pageable pageable) {
        log.debug("Request to get all AppStacks");
        return appStackRepository.findAll(pageable)
            .map(appStackMapper::toDto);
    }


    /**
     * Get one appStack by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<AppStackDTO> findOne(Long id) {
        log.debug("Request to get AppStack : {}", id);
        return appStackRepository.findById(id)
            .map(appStackMapper::toDto);
    }

    /**
     * Delete the appStack by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete AppStack : {}", id);
        appStackRepository.deleteById(id);
    }
}
