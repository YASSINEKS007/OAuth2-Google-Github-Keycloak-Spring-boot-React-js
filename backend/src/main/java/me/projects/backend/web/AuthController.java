package me.projects.backend.web;

import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AuthController {

    @GetMapping("/")
    public Authentication authentication(Authentication authentication) {
        return authentication;
    }
}
