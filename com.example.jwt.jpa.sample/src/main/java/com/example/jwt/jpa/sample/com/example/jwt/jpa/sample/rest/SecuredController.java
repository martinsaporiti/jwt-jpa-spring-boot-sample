package com.example.jwt.jpa.sample.com.example.jwt.jpa.sample.rest;

import com.example.jwt.jpa.sample.com.example.jwt.jpa.sample.service.SecuredService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: martinsaporiti
 * @date: 30/09/2020
 */
@RestController
@RequestMapping("/secured")
public class SecuredController {

    private static final Logger logger = LogManager.getLogger(SecuredController.class);
    private final SecuredService securedService;

    public SecuredController(SecuredService securedService) {
        this.securedService = securedService;
    }

    @GetMapping("/")
    private ResponseEntity<?> getAuthenticatedInfo(){
        return ResponseEntity.ok("Como usuario autenticado pudiste acceder a la info...!");
    }


    @GetMapping("/admin")
    private ResponseEntity<?> getAuthenticatedAndAdminInfo(){
        String response = this.securedService.securedService();
        logger.info(response);
        return ResponseEntity.ok(response);
    }


}
