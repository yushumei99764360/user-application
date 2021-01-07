package com.tk.test.user.repository;

import com.tk.test.user.domain.AppServiceNote;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the AppServiceNote entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AppServiceNoteRepository extends JpaRepository<AppServiceNote, Long> {
}
