package com.tk.test.user.web.rest;

import com.tk.test.user.service.AppServiceNoteService;
import com.tk.test.user.web.rest.errors.BadRequestAlertException;
import com.tk.test.user.service.dto.AppServiceNoteDTO;

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
 * REST controller for managing {@link com.tk.test.user.domain.AppServiceNote}.
 */
@RestController
@RequestMapping("/api")
public class AppServiceNoteResource {

    private final Logger log = LoggerFactory.getLogger(AppServiceNoteResource.class);

    private static final String ENTITY_NAME = "userApplicationAppServiceNote";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final AppServiceNoteService appServiceNoteService;

    public AppServiceNoteResource(AppServiceNoteService appServiceNoteService) {
        this.appServiceNoteService = appServiceNoteService;
    }

    /**
     * {@code POST  /app-service-notes} : Create a new appServiceNote.
     *
     * @param appServiceNoteDTO the appServiceNoteDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new appServiceNoteDTO, or with status {@code 400 (Bad Request)} if the appServiceNote has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/app-service-notes")
    public ResponseEntity<AppServiceNoteDTO> createAppServiceNote(@Valid @RequestBody AppServiceNoteDTO appServiceNoteDTO) throws URISyntaxException {
        log.debug("REST request to save AppServiceNote : {}", appServiceNoteDTO);
        if (appServiceNoteDTO.getId() != null) {
            throw new BadRequestAlertException("A new appServiceNote cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AppServiceNoteDTO result = appServiceNoteService.save(appServiceNoteDTO);
        return ResponseEntity.created(new URI("/api/app-service-notes/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /app-service-notes} : Updates an existing appServiceNote.
     *
     * @param appServiceNoteDTO the appServiceNoteDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated appServiceNoteDTO,
     * or with status {@code 400 (Bad Request)} if the appServiceNoteDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the appServiceNoteDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/app-service-notes")
    public ResponseEntity<AppServiceNoteDTO> updateAppServiceNote(@Valid @RequestBody AppServiceNoteDTO appServiceNoteDTO) throws URISyntaxException {
        log.debug("REST request to update AppServiceNote : {}", appServiceNoteDTO);
        if (appServiceNoteDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        AppServiceNoteDTO result = appServiceNoteService.save(appServiceNoteDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, appServiceNoteDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /app-service-notes} : get all the appServiceNotes.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of appServiceNotes in body.
     */
    @GetMapping("/app-service-notes")
    public ResponseEntity<List<AppServiceNoteDTO>> getAllAppServiceNotes(Pageable pageable) {
        log.debug("REST request to get a page of AppServiceNotes");
        Page<AppServiceNoteDTO> page = appServiceNoteService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /app-service-notes/:id} : get the "id" appServiceNote.
     *
     * @param id the id of the appServiceNoteDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the appServiceNoteDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/app-service-notes/{id}")
    public ResponseEntity<AppServiceNoteDTO> getAppServiceNote(@PathVariable Long id) {
        log.debug("REST request to get AppServiceNote : {}", id);
        Optional<AppServiceNoteDTO> appServiceNoteDTO = appServiceNoteService.findOne(id);
        return ResponseUtil.wrapOrNotFound(appServiceNoteDTO);
    }

    /**
     * {@code DELETE  /app-service-notes/:id} : delete the "id" appServiceNote.
     *
     * @param id the id of the appServiceNoteDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/app-service-notes/{id}")
    public ResponseEntity<Void> deleteAppServiceNote(@PathVariable Long id) {
        log.debug("REST request to delete AppServiceNote : {}", id);
        appServiceNoteService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
