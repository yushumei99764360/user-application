package com.tk.test.user.repository;

import com.tk.test.user.domain.AppService;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the AppService entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AppServiceRepository extends JpaRepository<AppService, Long> {
}
