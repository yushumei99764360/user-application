package com.tk.test.user.service;

import com.tk.test.user.domain.JdlRecord;
import com.tk.test.user.repository.JdlRecordRepository;
import com.tk.test.user.service.dto.JdlRecordDTO;
import com.tk.test.user.service.mapper.JdlRecordMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link JdlRecord}.
 */
@Service
@Transactional
public class JdlRecordService {

    private final Logger log = LoggerFactory.getLogger(JdlRecordService.class);

    private final JdlRecordRepository jdlRecordRepository;

    private final JdlRecordMapper jdlRecordMapper;

    public JdlRecordService(JdlRecordRepository jdlRecordRepository, JdlRecordMapper jdlRecordMapper) {
        this.jdlRecordRepository = jdlRecordRepository;
        this.jdlRecordMapper = jdlRecordMapper;
    }

    /**
     * Save a jdlRecord.
     *
     * @param jdlRecordDTO the entity to save.
     * @return the persisted entity.
     */
    public JdlRecordDTO save(JdlRecordDTO jdlRecordDTO) {
        log.debug("Request to save JdlRecord : {}", jdlRecordDTO);
        JdlRecord jdlRecord = jdlRecordMapper.toEntity(jdlRecordDTO);
        jdlRecord = jdlRecordRepository.save(jdlRecord);
        return jdlRecordMapper.toDto(jdlRecord);
    }

    /**
     * Get all the jdlRecords.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<JdlRecordDTO> findAll(Pageable pageable) {
        log.debug("Request to get all JdlRecords");
        return jdlRecordRepository.findAll(pageable)
            .map(jdlRecordMapper::toDto);
    }


    /**
     * Get one jdlRecord by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<JdlRecordDTO> findOne(Long id) {
        log.debug("Request to get JdlRecord : {}", id);
        return jdlRecordRepository.findById(id)
            .map(jdlRecordMapper::toDto);
    }

    /**
     * Delete the jdlRecord by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete JdlRecord : {}", id);
        jdlRecordRepository.deleteById(id);
    }
}
