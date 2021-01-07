package com.tk.test.user.repository;

import com.tk.test.user.domain.AppProject;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the AppProject entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AppProjectRepository extends JpaRepository<AppProject, Long> {
}
