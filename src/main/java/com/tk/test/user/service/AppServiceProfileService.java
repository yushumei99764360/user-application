package com.tk.test.user.service;

import com.tk.test.user.domain.AppServiceProfile;
import com.tk.test.user.repository.AppServiceProfileRepository;
import com.tk.test.user.service.dto.AppServiceProfileDTO;
import com.tk.test.user.service.mapper.AppServiceProfileMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link AppServiceProfile}.
 */
@Service
@Transactional
public class AppServiceProfileService {

    private final Logger log = LoggerFactory.getLogger(AppServiceProfileService.class);

    private final AppServiceProfileRepository appServiceProfileRepository;

    private final AppServiceProfileMapper appServiceProfileMapper;

    public AppServiceProfileService(AppServiceProfileRepository appServiceProfileRepository, AppServiceProfileMapper appServiceProfileMapper) {
        this.appServiceProfileRepository = appServiceProfileRepository;
        this.appServiceProfileMapper = appServiceProfileMapper;
    }

    /**
     * Save a appServiceProfile.
     *
     * @param appServiceProfileDTO the entity to save.
     * @return the persisted entity.
     */
    public AppServiceProfileDTO save(AppServiceProfileDTO appServiceProfileDTO) {
        log.debug("Request to save AppServiceProfile : {}", appServiceProfileDTO);
        AppServiceProfile appServiceProfile = appServiceProfileMapper.toEntity(appServiceProfileDTO);
        appServiceProfile = appServiceProfileRepository.save(appServiceProfile);
        return appServiceProfileMapper.toDto(appServiceProfile);
    }

    /**
     * Get all the appServiceProfiles.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<AppServiceProfileDTO> findAll(Pageable pageable) {
        log.debug("Request to get all AppServiceProfiles");
        return appServiceProfileRepository.findAll(pageable)
            .map(appServiceProfileMapper::toDto);
    }


    /**
     * Get one appServiceProfile by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<AppServiceProfileDTO> findOne(Long id) {
        log.debug("Request to get AppServiceProfile : {}", id);
        return appServiceProfileRepository.findById(id)
            .map(appServiceProfileMapper::toDto);
    }

    /**
     * Delete the appServiceProfile by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete AppServiceProfile : {}", id);
        appServiceProfileRepository.deleteById(id);
    }
}
