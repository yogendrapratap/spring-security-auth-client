package com.spring.springsecurityauthclient.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/users")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<String> getUser() {
        return ResponseEntity.ok("User details");
    }

    @GetMapping("/myAccount")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<String> getMyAccount() {
        return ResponseEntity.ok("User getMyAccount");
    }

    @GetMapping("/dealer")
    @PreAuthorize("hasAnyRole('DEALER')")
    public ResponseEntity<String> getDealer() {
        return ResponseEntity.ok("User getDealer");
    }

    @GetMapping("/contact")
    public ResponseEntity<String> getContact() {
        return ResponseEntity.ok("User contact");
    }

    @GetMapping("/info")
    public ResponseEntity<String> getInfo() {
        return ResponseEntity.ok("User Info");
    }


}
