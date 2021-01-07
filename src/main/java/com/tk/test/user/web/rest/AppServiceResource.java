package com.tk.test.user.web.rest;

import com.tk.test.user.service.AppServiceService;
import com.tk.test.user.web.rest.errors.BadRequestAlertException;
import com.tk.test.user.service.dto.AppServiceDTO;

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
 * REST controller for managing {@link com.tk.test.user.domain.AppService}.
 */
@RestController
@RequestMapping("/api")
public class AppServiceResource {

    private final Logger log = LoggerFactory.getLogger(AppServiceResource.class);

    private static final String ENTITY_NAME = "userApplicationAppService";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final AppServiceService appServiceService;

    public AppServiceResource(AppServiceService appServiceService) {
        this.appServiceService = appServiceService;
    }

    /**
     * {@code POST  /app-services} : Create a new appService.
     *
     * @param appServiceDTO the appServiceDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new appServiceDTO, or with status {@code 400 (Bad Request)} if the appService has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/app-services")
    public ResponseEntity<AppServiceDTO> createAppService(@Valid @RequestBody AppServiceDTO appServiceDTO) throws URISyntaxException {
        log.debug("REST request to save AppService : {}", appServiceDTO);
        if (appServiceDTO.getId() != null) {
            throw new BadRequestAlertException("A new appService cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AppServiceDTO result = appServiceService.save(appServiceDTO);
        return ResponseEntity.created(new URI("/api/app-services/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /app-services} : Updates an existing appService.
     *
     * @param appServiceDTO the appServiceDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated appServiceDTO,
     * or with status {@code 400 (Bad Request)} if the appServiceDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the appServiceDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/app-services")
    public ResponseEntity<AppServiceDTO> updateAppService(@Valid @RequestBody AppServiceDTO appServiceDTO) throws URISyntaxException {
        log.debug("REST request to update AppService : {}", appServiceDTO);
        if (appServiceDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        AppServiceDTO result = appServiceService.save(appServiceDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, appServiceDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /app-services} : get all the appServices.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of appServices in body.
     */
    @GetMapping("/app-services")
    public ResponseEntity<List<AppServiceDTO>> getAllAppServices(Pageable pageable) {
        log.debug("REST request to get a page of AppServices");
        Page<AppServiceDTO> page = appServiceService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /app-services/:id} : get the "id" appService.
     *
     * @param id the id of the appServiceDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the appServiceDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/app-services/{id}")
    public ResponseEntity<AppServiceDTO> getAppService(@PathVariable Long id) {
        log.debug("REST request to get AppService : {}", id);
        Optional<AppServiceDTO> appServiceDTO = appServiceService.findOne(id);
        return ResponseUtil.wrapOrNotFound(appServiceDTO);
    }

    /**
     * {@code DELETE  /app-services/:id} : delete the "id" appService.
     *
     * @param id the id of the appServiceDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/app-services/{id}")
    public ResponseEntity<Void> deleteAppService(@PathVariable Long id) {
        log.debug("REST request to delete AppService : {}", id);
        appServiceService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
