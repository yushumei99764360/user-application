package com.tk.test.user.repository;

import com.tk.test.user.domain.AppServiceProfile;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the AppServiceProfile entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AppServiceProfileRepository extends JpaRepository<AppServiceProfile, Long> {
}
