package com.webdesignerportalimigrante.users.domain;

import java.util.Collection;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Entity
public class User implements UserDetails, CredentialsContainer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String nomeUsuario;

    @NotBlank(message = "Senha is mandatory")
    private String senha;

    @NotBlank(message = "Email is mandatory")
    private String email;

    private String vagaDesejada;

    @NotBlank(message = "Endereço is mandatory")
    private String enderecoCompleto;

    public User() {
    }

    public User(Long id, String nomeUsuario, String senha, String email, String vagaDesejada,
            String enderecoCompleto) {
        this.id = id;
        this.nomeUsuario = nomeUsuario;
        this.senha = senha;
        this.email = email;
        this.vagaDesejada = vagaDesejada;
        this.enderecoCompleto = enderecoCompleto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getVagaDesejada() {
        return vagaDesejada;
    }

    public void setVagaDesejada(String vagaDesejada) {
        this.vagaDesejada = vagaDesejada;
    }

    public String getEnderecoCompleto() {
        return enderecoCompleto;
    }

    public void setEnderecoCompleto(String enderecoCompleto) {
        this.enderecoCompleto = enderecoCompleto;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nomeUsuario='" + nomeUsuario + '\'' +
                ", senha='" + senha + '\'' +
                ", email='" + email + '\'' +
                ", vagaDesejada='" + vagaDesejada + '\'' +
                ", enderecoCompleto='" + enderecoCompleto + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return id.equals(user.id) && nomeUsuario.equals(user.nomeUsuario) && senha.equals(user.senha) && email.equals(user.email) && Objects.equals(vagaDesejada, user.vagaDesejada) && enderecoCompleto.equals(user.enderecoCompleto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomeUsuario, senha, email, vagaDesejada, enderecoCompleto);
    }

    @Override
    public void eraseCredentials() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getPassword() {
    
        return null;
    }

    @Override
    public String getUsername() {

        return null;
    }

    @Override
    public boolean isAccountNonExpired() { return true; }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
