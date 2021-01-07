package com.tk.test.user.web.rest;

import com.tk.test.user.service.AppServiceProfileService;
import com.tk.test.user.web.rest.errors.BadRequestAlertException;
import com.tk.test.user.service.dto.AppServiceProfileDTO;

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
 * REST controller for managing {@link com.tk.test.user.domain.AppServiceProfile}.
 */
@RestController
@RequestMapping("/api")
public class AppServiceProfileResource {

    private final Logger log = LoggerFactory.getLogger(AppServiceProfileResource.class);

    private static final String ENTITY_NAME = "userApplicationAppServiceProfile";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final AppServiceProfileService appServiceProfileService;

    public AppServiceProfileResource(AppServiceProfileService appServiceProfileService) {
        this.appServiceProfileService = appServiceProfileService;
    }

    /**
     * {@code POST  /app-service-profiles} : Create a new appServiceProfile.
     *
     * @param appServiceProfileDTO the appServiceProfileDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new appServiceProfileDTO, or with status {@code 400 (Bad Request)} if the appServiceProfile has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/app-service-profiles")
    public ResponseEntity<AppServiceProfileDTO> createAppServiceProfile(@Valid @RequestBody AppServiceProfileDTO appServiceProfileDTO) throws URISyntaxException {
        log.debug("REST request to save AppServiceProfile : {}", appServiceProfileDTO);
        if (appServiceProfileDTO.getId() != null) {
            throw new BadRequestAlertException("A new appServiceProfile cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AppServiceProfileDTO result = appServiceProfileService.save(appServiceProfileDTO);
        return ResponseEntity.created(new URI("/api/app-service-profiles/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /app-service-profiles} : Updates an existing appServiceProfile.
     *
     * @param appServiceProfileDTO the appServiceProfileDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated appServiceProfileDTO,
     * or with status {@code 400 (Bad Request)} if the appServiceProfileDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the appServiceProfileDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/app-service-profiles")
    public ResponseEntity<AppServiceProfileDTO> updateAppServiceProfile(@Valid @RequestBody AppServiceProfileDTO appServiceProfileDTO) throws URISyntaxException {
        log.debug("REST request to update AppServiceProfile : {}", appServiceProfileDTO);
        if (appServiceProfileDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        AppServiceProfileDTO result = appServiceProfileService.save(appServiceProfileDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, appServiceProfileDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /app-service-profiles} : get all the appServiceProfiles.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of appServiceProfiles in body.
     */
    @GetMapping("/app-service-profiles")
    public ResponseEntity<List<AppServiceProfileDTO>> getAllAppServiceProfiles(Pageable pageable) {
        log.debug("REST request to get a page of AppServiceProfiles");
        Page<AppServiceProfileDTO> page = appServiceProfileService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /app-service-profiles/:id} : get the "id" appServiceProfile.
     *
     * @param id the id of the appServiceProfileDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the appServiceProfileDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/app-service-profiles/{id}")
    public ResponseEntity<AppServiceProfileDTO> getAppServiceProfile(@PathVariable Long id) {
        log.debug("REST request to get AppServiceProfile : {}", id);
        Optional<AppServiceProfileDTO> appServiceProfileDTO = appServiceProfileService.findOne(id);
        return ResponseUtil.wrapOrNotFound(appServiceProfileDTO);
    }

    /**
     * {@code DELETE  /app-service-profiles/:id} : delete the "id" appServiceProfile.
     *
     * @param id the id of the appServiceProfileDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/app-service-profiles/{id}")
    public ResponseEntity<Void> deleteAppServiceProfile(@PathVariable Long id) {
        log.debug("REST request to delete AppServiceProfile : {}", id);
        appServiceProfileService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
