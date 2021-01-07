package com.tk.test.user.service;

import com.tk.test.user.domain.AppServiceNote;
import com.tk.test.user.repository.AppServiceNoteRepository;
import com.tk.test.user.service.dto.AppServiceNoteDTO;
import com.tk.test.user.service.mapper.AppServiceNoteMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link AppServiceNote}.
 */
@Service
@Transactional
public class AppServiceNoteService {

    private final Logger log = LoggerFactory.getLogger(AppServiceNoteService.class);

    private final AppServiceNoteRepository appServiceNoteRepository;

    private final AppServiceNoteMapper appServiceNoteMapper;

    public AppServiceNoteService(AppServiceNoteRepository appServiceNoteRepository, AppServiceNoteMapper appServiceNoteMapper) {
        this.appServiceNoteRepository = appServiceNoteRepository;
        this.appServiceNoteMapper = appServiceNoteMapper;
    }

    /**
     * Save a appServiceNote.
     *
     * @param appServiceNoteDTO the entity to save.
     * @return the persisted entity.
     */
    public AppServiceNoteDTO save(AppServiceNoteDTO appServiceNoteDTO) {
        log.debug("Request to save AppServiceNote : {}", appServiceNoteDTO);
        AppServiceNote appServiceNote = appServiceNoteMapper.toEntity(appServiceNoteDTO);
        appServiceNote = appServiceNoteRepository.save(appServiceNote);
        return appServiceNoteMapper.toDto(appServiceNote);
    }

    /**
     * Get all the appServiceNotes.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<AppServiceNoteDTO> findAll(Pageable pageable) {
        log.debug("Request to get all AppServiceNotes");
        return appServiceNoteRepository.findAll(pageable)
            .map(appServiceNoteMapper::toDto);
    }


    /**
     * Get one appServiceNote by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<AppServiceNoteDTO> findOne(Long id) {
        log.debug("Request to get AppServiceNote : {}", id);
        return appServiceNoteRepository.findById(id)
            .map(appServiceNoteMapper::toDto);
    }

    /**
     * Delete the appServiceNote by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete AppServiceNote : {}", id);
        appServiceNoteRepository.deleteById(id);
    }
}
