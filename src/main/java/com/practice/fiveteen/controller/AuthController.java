package com.practice.fiveteen.controller;

import com.practice.fiveteen.dto.AuthRequest;
import com.practice.fiveteen.dto.AuthResponse;
import com.practice.fiveteen.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest authRequest) {
        return authService.login(authRequest);
    }
}
