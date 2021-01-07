package com.tk.test.user.service;

import com.tk.test.user.domain.AppService;
import com.tk.test.user.repository.AppServiceRepository;
import com.tk.test.user.service.dto.AppServiceDTO;
import com.tk.test.user.service.mapper.AppServiceMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link AppService}.
 */
@Service
@Transactional
public class AppServiceService {

    private final Logger log = LoggerFactory.getLogger(AppServiceService.class);

    private final AppServiceRepository appServiceRepository;

    private final AppServiceMapper appServiceMapper;

    public AppServiceService(AppServiceRepository appServiceRepository, AppServiceMapper appServiceMapper) {
        this.appServiceRepository = appServiceRepository;
        this.appServiceMapper = appServiceMapper;
    }

    /**
     * Save a appService.
     *
     * @param appServiceDTO the entity to save.
     * @return the persisted entity.
     */
    public AppServiceDTO save(AppServiceDTO appServiceDTO) {
        log.debug("Request to save AppService : {}", appServiceDTO);
        AppService appService = appServiceMapper.toEntity(appServiceDTO);
        appService = appServiceRepository.save(appService);
        return appServiceMapper.toDto(appService);
    }

    /**
     * Get all the appServices.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<AppServiceDTO> findAll(Pageable pageable) {
        log.debug("Request to get all AppServices");
        return appServiceRepository.findAll(pageable)
            .map(appServiceMapper::toDto);
    }


    /**
     * Get one appService by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<AppServiceDTO> findOne(Long id) {
        log.debug("Request to get AppService : {}", id);
        return appServiceRepository.findById(id)
            .map(appServiceMapper::toDto);
    }

    /**
     * Delete the appService by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete AppService : {}", id);
        appServiceRepository.deleteById(id);
    }
}
