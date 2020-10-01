package com.example.jwt.jpa.sample.com.example.jwt.jpa.sample.rest;

import com.example.jwt.jpa.sample.com.example.jwt.jpa.sample.util.JwtTokenUtil;
import com.example.jwt.jpa.sample.com.example.jwt.jpa.sample.rest.model.Credentials;
import com.example.jwt.jpa.sample.com.example.jwt.jpa.sample.rest.model.JwtResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

/**
 * @author: martinsaporiti
 * @date: 29/09/2020
 */
@RestController
@RequestMapping("/authenticate")
@CrossOrigin
public class AuthenticationController {


    private AuthenticationManager authenticationManager;
    private UserDetailsService userDetailsService;
    private JwtTokenUtil jwtTokenUtil;


    public AuthenticationController(AuthenticationManager authenticationManager,
                                    @Qualifier("userDetailServiceImpl") UserDetailsService userDetailsService,
                                    JwtTokenUtil jwtTokenUtil) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtTokenUtil = jwtTokenUtil;
    }


    @PostMapping("/")
    public ResponseEntity<?> authenticate(@RequestBody Credentials credentials) {
        try {
            this.authenticate(credentials.getUsername(), credentials.getPassword());
            final UserDetails userDetails = userDetailsService.loadUserByUsername(credentials.getUsername());
            final String token = jwtTokenUtil.generateToken(userDetails);
            JwtResponse response = new JwtResponse(credentials.getUsername(), token);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
