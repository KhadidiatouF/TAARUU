package com.example.makeupplatform.service;

import com.example.makeupplatform.dto.AuthRequest;
import com.example.makeupplatform.dto.AuthResponse;
import com.example.makeupplatform.entity.Role;
import com.example.makeupplatform.entity.User;
import com.example.makeupplatform.exception.ApiException;
import com.example.makeupplatform.repository.UserRepository;
import com.example.makeupplatform.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthResponse register(AuthRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new ApiException("Email already exists");
        }
        User user = User.builder()
                .fullName(request.getFullName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .roles(Set.of(Role.CLIENT))
                .build();
        userRepository.save(user);
        return login(request.getEmail(), request.getPassword());
    }

    public AuthResponse login(String email, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        User user = userRepository.findByEmail(email).orElseThrow(() -> new ApiException("Invalid credentials"));
        String token = jwtService.generateToken(user.getEmail());
        return AuthResponse.builder()
                .token(token)
                .fullName(user.getFullName())
                .email(user.getEmail())
                .role(user.getRoles().stream().findFirst().map(Enum::name).orElse("CLIENT"))
                .build();
    }
}
