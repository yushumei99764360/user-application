package com.tk.test.user.web.rest;

import com.tk.test.user.service.AppStackService;
import com.tk.test.user.web.rest.errors.BadRequestAlertException;
import com.tk.test.user.service.dto.AppStackDTO;

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
 * REST controller for managing {@link com.tk.test.user.domain.AppStack}.
 */
@RestController
@RequestMapping("/api")
public class AppStackResource {

    private final Logger log = LoggerFactory.getLogger(AppStackResource.class);

    private static final String ENTITY_NAME = "userApplicationAppStack";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final AppStackService appStackService;

    public AppStackResource(AppStackService appStackService) {
        this.appStackService = appStackService;
    }

    /**
     * {@code POST  /app-stacks} : Create a new appStack.
     *
     * @param appStackDTO the appStackDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new appStackDTO, or with status {@code 400 (Bad Request)} if the appStack has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/app-stacks")
    public ResponseEntity<AppStackDTO> createAppStack(@Valid @RequestBody AppStackDTO appStackDTO) throws URISyntaxException {
        log.debug("REST request to save AppStack : {}", appStackDTO);
        if (appStackDTO.getId() != null) {
            throw new BadRequestAlertException("A new appStack cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AppStackDTO result = appStackService.save(appStackDTO);
        return ResponseEntity.created(new URI("/api/app-stacks/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /app-stacks} : Updates an existing appStack.
     *
     * @param appStackDTO the appStackDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated appStackDTO,
     * or with status {@code 400 (Bad Request)} if the appStackDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the appStackDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/app-stacks")
    public ResponseEntity<AppStackDTO> updateAppStack(@Valid @RequestBody AppStackDTO appStackDTO) throws URISyntaxException {
        log.debug("REST request to update AppStack : {}", appStackDTO);
        if (appStackDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        AppStackDTO result = appStackService.save(appStackDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, appStackDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /app-stacks} : get all the appStacks.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of appStacks in body.
     */
    @GetMapping("/app-stacks")
    public ResponseEntity<List<AppStackDTO>> getAllAppStacks(Pageable pageable) {
        log.debug("REST request to get a page of AppStacks");
        Page<AppStackDTO> page = appStackService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /app-stacks/:id} : get the "id" appStack.
     *
     * @param id the id of the appStackDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the appStackDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/app-stacks/{id}")
    public ResponseEntity<AppStackDTO> getAppStack(@PathVariable Long id) {
        log.debug("REST request to get AppStack : {}", id);
        Optional<AppStackDTO> appStackDTO = appStackService.findOne(id);
        return ResponseUtil.wrapOrNotFound(appStackDTO);
    }

    /**
     * {@code DELETE  /app-stacks/:id} : delete the "id" appStack.
     *
     * @param id the id of the appStackDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/app-stacks/{id}")
    public ResponseEntity<Void> deleteAppStack(@PathVariable Long id) {
        log.debug("REST request to delete AppStack : {}", id);
        appStackService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
