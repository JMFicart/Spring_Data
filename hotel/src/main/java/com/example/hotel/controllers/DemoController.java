package com.example.hotel.controllers;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/demo")
public class DemoController {
    @GetMapping("/headers")
    public ResponseEntity<?> getHeaders(@RequestHeader HttpHeaders headers){
        headers.forEach((key, value) -> {
            System.out.println(key + "-" + value.get(0));
        });

        String host = headers.get("host").get(0);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/header")
    public ResponseEntity<?> getHeader(@RequestHeader(HttpHeaders.HOST) String host) {
        System.out.println(host);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/params")
    public ResponseEntity<?> getParams(@RequestParam MultiValueMap<String, String> params){
        params.forEach((key, value) -> {
            System.out.print(key + " : ");
            value.forEach((v) -> System.out.print(v + ", "));
        });
        return ResponseEntity.ok().build();
    }

    @GetMapping("/param")
    public ResponseEntity<?> getParams(@RequestParam(required = false) Integer size) {
        System.out.println("size : " + size);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/for-all")
    @PreAuthorize("permitAll()")
    public String getForAll()   {
        return "pour tous";
    }

    @GetMapping("/for-connected")
    @PreAuthorize("isAuthenticated()")
    public String getForConnected(Authentication auth)   {
        return "pour connected";
    }

    @GetMapping("/for-user")
    @RolesAllowed("ROLE_USER")
    public String getForRoleUser()   {
        return "pour les roles USER";
    }

    @GetMapping("/for-admin")
    @Secured("ROLE_ADMIN")
    public String getForRoleAdmin()   {
        return "pour le role ADMIN";
    }
}
