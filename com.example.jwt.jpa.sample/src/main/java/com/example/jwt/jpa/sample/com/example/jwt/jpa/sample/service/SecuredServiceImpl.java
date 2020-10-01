package com.example.jwt.jpa.sample.com.example.jwt.jpa.sample.service;

import org.springframework.stereotype.Service;

/**
 * @author: martinsaporiti
 * @date: 30/09/2020
 */
@Service
public class SecuredServiceImpl implements SecuredService {


    @Override
    public String securedService() {
        return "Se ejecutó el servicio segurizado";
    }
}
