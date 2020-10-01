package com.example.jwt.jpa.sample.com.example.jwt.jpa.sample.service;

import org.springframework.security.access.prepost.PreAuthorize;

public interface SecuredService {

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    String securedService();
}
