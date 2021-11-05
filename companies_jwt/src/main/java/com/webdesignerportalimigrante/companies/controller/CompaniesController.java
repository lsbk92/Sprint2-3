package com.webdesignerportalimigrante.companies.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.webdesignerportalimigrante.companies.domain.Companies;
import com.webdesignerportalimigrante.companies.Exception.CompaniesNotFoundException;
import com.webdesignerportalimigrante.companies.repository.CompaniesRepository;

@RestController
public class CompaniesController {

    @Autowired
    CompaniesRepository repository;

    @GetMapping("/Companies")
    List<Companies> findAllCompanies() {
        return repository.findAll();
    }

    @PostMapping("/Companies")
    Companies createNewOngEntity(@RequestBody Companies newCompanies) {
        return repository.save(newCompanies);
    }

    @GetMapping("/Companies/{id}")
    Companies findOngById(@PathVariable Long id) { return repository.findById(id).orElseThrow(() -> new CompaniesNotFoundException(id)); }

    @PutMapping("/Companies/{id}")
    Companies updateOngById(@RequestBody Companies newCompanies, @PathVariable Long id) {
        return repository.findById(id)
                .map(Companies -> {
                    Companies.setNameCompanies(newCompanies.getNameCompanies());
                    Companies.setEmail(newCompanies.getEmail());
                    Companies.setNameCompanies(newCompanies.getNameCompanies());
                    Companies.setCidade(newCompanies.getCidade());
                    Companies.setCNPJ(newCompanies.getCNPJ());
                    Companies.setEstado(newCompanies.getEstado());
                    Companies.setJobOportunity(newCompanies.getJobOportunity());
                    Companies.setMunicipio(newCompanies.getMunicipio());
                    return repository.save(Companies);
                })
                .orElseGet(() -> {
                    newCompanies.setId(id);
                    return repository.save(newCompanies);
                });
    }

    public Companies getByEmail(String email) {
        return repository.findByEmail(email);
    }

    @DeleteMapping("/Companies/{id}")
    void deleteCompanies(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
