package com.spring_security.controller;

import com.spring_security.dto.RegisterRequest;
import com.spring_security.entity.Role;
import com.spring_security.entity.User;
import com.spring_security.repository.RoleRepository;
import com.spring_security.repository.UserRepository;
import com.spring_security.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;


    //Register User API
    @PostMapping("/register") // Register endpoint http://localhost:8080/auth/register
    public ResponseEntity<String> register(@RequestBody RegisterRequest registerRequest) {

        //Check if username already exists
        if (userRepository.findByUsername(registerRequest.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("Username is already taken");
        }

        User newUser = new User();

        newUser.setUsername(registerRequest.getUsername());
        newUser.setPassword(registerRequest.getPassword());

        String encodedPassword = passwordEncoder.encode(registerRequest.getPassword());

        newUser.setPassword(encodedPassword);

        log.info("Encoded password : " + encodedPassword);

        // Convert role names to role entities and assign to user

        Set<Role> roles = new HashSet<>();
        for (String roleName : registerRequest.getRoles()) {
            Role role = roleRepository.findByName(roleName).orElseThrow(() -> new RuntimeException("Role not found " + roleName));
            roles.add(role);
        }

        newUser.setRoles(roles);

        userRepository.save(newUser);

        return ResponseEntity.ok("User Registered Successfully");
    }


    // Login API - // Login endpoint http:localhost:8080/auth/login
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User loginRequest) {


        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        } catch (Exception e) {
            log.info("Exception : " + e);
        }

        String token = jwtUtil.generateToken(loginRequest.getUsername());

        return ResponseEntity.ok(token);

    }
}
