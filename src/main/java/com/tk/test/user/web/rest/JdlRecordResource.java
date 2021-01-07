package com.tk.test.user.web.rest;

import com.tk.test.user.service.JdlRecordService;
import com.tk.test.user.web.rest.errors.BadRequestAlertException;
import com.tk.test.user.service.dto.JdlRecordDTO;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.tk.test.user.domain.JdlRecord}.
 */
@RestController
@RequestMapping("/api")
public class JdlRecordResource {

    private final Logger log = LoggerFactory.getLogger(JdlRecordResource.class);

    private static final String ENTITY_NAME = "userApplicationJdlRecord";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final JdlRecordService jdlRecordService;

    public JdlRecordResource(JdlRecordService jdlRecordService) {
        this.jdlRecordService = jdlRecordService;
    }

    /**
     * {@code POST  /jdl-records} : Create a new jdlRecord.
     *
     * @param jdlRecordDTO the jdlRecordDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new jdlRecordDTO, or with status {@code 400 (Bad Request)} if the jdlRecord has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/jdl-records")
    public ResponseEntity<JdlRecordDTO> createJdlRecord(@Valid @RequestBody JdlRecordDTO jdlRecordDTO) throws URISyntaxException {
        log.debug("REST request to save JdlRecord : {}", jdlRecordDTO);
        if (jdlRecordDTO.getId() != null) {
            throw new BadRequestAlertException("A new jdlRecord cannot already have an ID", ENTITY_NAME, "idexists");
        }
        JdlRecordDTO result = jdlRecordService.save(jdlRecordDTO);
        return ResponseEntity.created(new URI("/api/jdl-records/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /jdl-records} : Updates an existing jdlRecord.
     *
     * @param jdlRecordDTO the jdlRecordDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated jdlRecordDTO,
     * or with status {@code 400 (Bad Request)} if the jdlRecordDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the jdlRecordDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/jdl-records")
    public ResponseEntity<JdlRecordDTO> updateJdlRecord(@Valid @RequestBody JdlRecordDTO jdlRecordDTO) throws URISyntaxException {
        log.debug("REST request to update JdlRecord : {}", jdlRecordDTO);
        if (jdlRecordDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        JdlRecordDTO result = jdlRecordService.save(jdlRecordDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, jdlRecordDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /jdl-records} : get all the jdlRecords.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of jdlRecords in body.
     */
    @GetMapping("/jdl-records")
    public ResponseEntity<List<JdlRecordDTO>> getAllJdlRecords(Pageable pageable) {
        log.debug("REST request to get a page of JdlRecords");
        Page<JdlRecordDTO> page = jdlRecordService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /jdl-records/:id} : get the "id" jdlRecord.
     *
     * @param id the id of the jdlRecordDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the jdlRecordDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/jdl-records/{id}")
    public ResponseEntity<JdlRecordDTO> getJdlRecord(@PathVariable Long id) {
        log.debug("REST request to get JdlRecord : {}", id);
        Optional<JdlRecordDTO> jdlRecordDTO = jdlRecordService.findOne(id);
        return ResponseUtil.wrapOrNotFound(jdlRecordDTO);
    }

    /**
     * {@code DELETE  /jdl-records/:id} : delete the "id" jdlRecord.
     *
     * @param id the id of the jdlRecordDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/jdl-records/{id}")
    public ResponseEntity<Void> deleteJdlRecord(@PathVariable Long id) {
        log.debug("REST request to delete JdlRecord : {}", id);
        jdlRecordService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
