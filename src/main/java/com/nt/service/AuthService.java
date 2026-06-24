package com.nt.service;

import com.nt.dto.auth.AuthResponse;
import com.nt.dto.auth.LoginRequest;
import com.nt.dto.auth.RegisterRequest;

public interface AuthService {

    AuthResponse register(RegisterRequest request);

    AuthResponse login(LoginRequest request);

}
