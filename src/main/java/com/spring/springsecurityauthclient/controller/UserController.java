package com.spring.springsecurityauthclient.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/users")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<String> getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return ResponseEntity.ok("User details: "+ authentication.getName());
    }

    @GetMapping("/myAccount")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<String> getMyAccount() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return ResponseEntity.ok("User getMyAccount " + authentication.getName());
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
