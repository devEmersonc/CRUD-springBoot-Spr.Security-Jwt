package com.practice.fiveteen.service;

import com.practice.fiveteen.dto.AuthRequest;
import com.practice.fiveteen.dto.AuthResponse;

public interface AuthService {

    public AuthResponse login(AuthRequest authRequest);
}
