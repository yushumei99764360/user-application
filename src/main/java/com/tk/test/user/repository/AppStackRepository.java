package com.tk.test.user.repository;

import com.tk.test.user.domain.AppStack;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the AppStack entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AppStackRepository extends JpaRepository<AppStack, Long> {
}
