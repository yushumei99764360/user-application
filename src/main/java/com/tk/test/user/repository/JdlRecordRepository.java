package com.tk.test.user.repository;

import com.tk.test.user.domain.JdlRecord;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the JdlRecord entity.
 */
@SuppressWarnings("unused")
@Repository
public interface JdlRecordRepository extends JpaRepository<JdlRecord, Long> {
}
