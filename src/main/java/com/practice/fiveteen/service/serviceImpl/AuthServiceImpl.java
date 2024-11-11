package com.practice.fiveteen.service.serviceImpl;

import com.practice.fiveteen.dto.AuthRequest;
import com.practice.fiveteen.dto.AuthResponse;
import com.practice.fiveteen.service.AuthService;
import com.practice.fiveteen.service.CustomUserDetailsService;
import com.practice.fiveteen.service.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailsService customUserDetailsService;
    private final JwtService jwtService;

    public AuthServiceImpl(AuthenticationManager authenticationManager, CustomUserDetailsService customUserDetailsService, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.customUserDetailsService = customUserDetailsService;
        this.jwtService = jwtService;
    }
    @Override
    public AuthResponse login(AuthRequest authRequest) {
        //Intenta autenticar al usuario
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
        );

        //Si la autenticación es exitosa, se obtiene el usuario
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(authRequest.getUsername());

        //Genera el token
        String token = jwtService.generateToken(userDetails);
        return new AuthResponse(token); //Devuelvel token en un objeto AuthResponse
    }
}
