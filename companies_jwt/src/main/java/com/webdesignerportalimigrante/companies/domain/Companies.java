package com.webdesignerportalimigrante.companies.domain;

import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.Collection;

import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class Companies implements UserDetails, CredentialsContainer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "NameCompanies is mandatory")
    private String nameCompanies;

    @NotBlank(message = "CNPJ is mandatory")
    private String CNPJ;

    @NotBlank(message = "Email is mandatory")
    private String email;

    @NotBlank(message = "NameCompanies is mandatory")
    private String Password;

    @NotBlank(message = "jobOportunity is mandatory")
    private String jobOportunity;

    private String estado;

    private String cidade;

    private String municipio;


    public Companies(long id, String nameCompanies, String CNPJ, String email, String password, String jobOportunity, String estado, String cidade, String municipio) {
        this.id = id;
        this.nameCompanies = nameCompanies;
        this.CNPJ = CNPJ;
        this.email = email;
        this.Password = password;
        this.jobOportunity = jobOportunity;
        this.estado = estado;
        this.cidade = cidade;
        this.municipio = municipio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameCompanies() {
        return nameCompanies;
    }

    public void setNameCompanies(String nameCompanies) {
        this.nameCompanies = nameCompanies;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getJobOportunity() {
        return jobOportunity;
    }

    public void setJobOportunity(String jobOportunity) {
        this.jobOportunity = jobOportunity;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public void eraseCredentials() {

    }

}

