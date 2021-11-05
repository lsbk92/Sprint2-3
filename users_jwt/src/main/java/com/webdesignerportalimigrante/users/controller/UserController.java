package com.webdesignerportalimigrante.users.controller;

import java.util.List;

import com.webdesignerportalimigrante.users.domain.User;
import com.webdesignerportalimigrante.users.exception.UserNotFoundException;
import com.webdesignerportalimigrante.users.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserRepository repository;

    @GetMapping("/users")
    List<User> findAllUser() {
        return repository.findAll();
    }

    @PostMapping("/users")
    User createNewUserEntity(@RequestBody User newUser) {
        return repository.save(newUser);
    }

    @GetMapping("/users/{id}")
    User findUserById(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @PutMapping("/users/{id}")
    User updateUserById(@RequestBody User newUser, @PathVariable Long id) {
        return repository.findById(id)
                .map(User -> {
                    User.setNomeUsuario(newUser.getNomeUsuario());
                    User.setEmail(newUser.getEmail());
                    User.setSenha(newUser.getSenha());
                    User.setEnderecoCompleto(newUser.getEnderecoCompleto());
                    User.setVagaDesejada(newUser.getEnderecoCompleto());
                    return repository.save(User);
                })
                .orElseGet(() -> {
                    newUser.setId(id);
                    return repository.save(newUser);
                });
    }

    public User getByEmail(String email) {
        return repository.findByEmail(email);
    }

    @DeleteMapping("/users/{id}")
    void deleteUser(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
