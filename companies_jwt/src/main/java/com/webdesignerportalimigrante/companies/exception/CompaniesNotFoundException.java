package com.webdesignerportalimigrante.companies.Exception;

public class CompaniesNotFoundException extends RuntimeException {
    public CompaniesNotFoundException(Long id) {
        super("Could not find Company with this ID: " + id);
    }
}
