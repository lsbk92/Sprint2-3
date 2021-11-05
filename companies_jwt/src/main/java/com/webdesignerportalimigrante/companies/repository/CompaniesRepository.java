package com.webdesignerportalimigrante.companies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webdesignerportalimigrante.companies.domain.Companies;

@Repository
public interface CompaniesRepository extends JpaRepository<Companies, Long> {

    Companies findByEmail(String email);
}
