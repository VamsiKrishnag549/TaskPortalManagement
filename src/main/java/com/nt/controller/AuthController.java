package com.nt.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.nt.dto.auth.AuthResponse;
import com.nt.dto.auth.LoginRequest;
import com.nt.dto.auth.RegisterRequest;
import com.nt.service.AuthService;
import com.nt.util.ApiResponse;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ApiResponse<AuthResponse> register(
            @Valid @RequestBody RegisterRequest request) {

        return new ApiResponse<>(
                true,
                "Registration successful",
                authService.register(request)
        );
    }

    @PostMapping("/login")
    public ApiResponse<AuthResponse> login(
            @Valid @RequestBody LoginRequest request) {

        return new ApiResponse<>(
                true,
                "Login successful",
                authService.login(request)
        );
    }
}
