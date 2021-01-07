package com.tk.test.user.web.rest;

import com.tk.test.user.service.AppProjectService;
import com.tk.test.user.web.rest.errors.BadRequestAlertException;
import com.tk.test.user.service.dto.AppProjectDTO;

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
 * REST controller for managing {@link com.tk.test.user.domain.AppProject}.
 */
@RestController
@RequestMapping("/api")
public class AppProjectResource {

    private final Logger log = LoggerFactory.getLogger(AppProjectResource.class);

    private static final String ENTITY_NAME = "userApplicationAppProject";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final AppProjectService appProjectService;

    public AppProjectResource(AppProjectService appProjectService) {
        this.appProjectService = appProjectService;
    }

    /**
     * {@code POST  /app-projects} : Create a new appProject.
     *
     * @param appProjectDTO the appProjectDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new appProjectDTO, or with status {@code 400 (Bad Request)} if the appProject has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/app-projects")
    public ResponseEntity<AppProjectDTO> createAppProject(@Valid @RequestBody AppProjectDTO appProjectDTO) throws URISyntaxException {
        log.debug("REST request to save AppProject : {}", appProjectDTO);
        if (appProjectDTO.getId() != null) {
            throw new BadRequestAlertException("A new appProject cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AppProjectDTO result = appProjectService.save(appProjectDTO);
        return ResponseEntity.created(new URI("/api/app-projects/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /app-projects} : Updates an existing appProject.
     *
     * @param appProjectDTO the appProjectDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated appProjectDTO,
     * or with status {@code 400 (Bad Request)} if the appProjectDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the appProjectDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/app-projects")
    public ResponseEntity<AppProjectDTO> updateAppProject(@Valid @RequestBody AppProjectDTO appProjectDTO) throws URISyntaxException {
        log.debug("REST request to update AppProject : {}", appProjectDTO);
        if (appProjectDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        AppProjectDTO result = appProjectService.save(appProjectDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, appProjectDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /app-projects} : get all the appProjects.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of appProjects in body.
     */
    @GetMapping("/app-projects")
    public ResponseEntity<List<AppProjectDTO>> getAllAppProjects(Pageable pageable) {
        log.debug("REST request to get a page of AppProjects");
        Page<AppProjectDTO> page = appProjectService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /app-projects/:id} : get the "id" appProject.
     *
     * @param id the id of the appProjectDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the appProjectDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/app-projects/{id}")
    public ResponseEntity<AppProjectDTO> getAppProject(@PathVariable Long id) {
        log.debug("REST request to get AppProject : {}", id);
        Optional<AppProjectDTO> appProjectDTO = appProjectService.findOne(id);
        return ResponseUtil.wrapOrNotFound(appProjectDTO);
    }

    /**
     * {@code DELETE  /app-projects/:id} : delete the "id" appProject.
     *
     * @param id the id of the appProjectDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/app-projects/{id}")
    public ResponseEntity<Void> deleteAppProject(@PathVariable Long id) {
        log.debug("REST request to delete AppProject : {}", id);
        appProjectService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
