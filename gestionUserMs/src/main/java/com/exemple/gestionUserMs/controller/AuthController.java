package com.exemple.gestionUserMs.controller;


import com.exemple.gestionUserMs.entity.User;
import com.exemple.gestionUserMs.payload.request.LoginRequest;
import com.exemple.gestionUserMs.payload.request.SignupRequest;
import com.exemple.gestionUserMs.payload.response.AuthResponse;
import com.exemple.gestionUserMs.payload.response.MessageResponse;
import com.exemple.gestionUserMs.repository.UserRepository;
import com.exemple.gestionUserMs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/auth")
public class AuthController {

  @Autowired
  private RestTemplate restTemplate;
  @Autowired
  UserRepository userRepository;

  @Autowired
  PasswordEncoder passwordEncoder;
  @Autowired
  UserService userService;

  @PostMapping("/signin")
  public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
    User user = userRepository.findByUsername(loginRequest.getUsername()).orElse(null);
    if (user != null && passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {

      try {
        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
        requestBody.add("grant_type", "password");
        requestBody.add("username", user.getRole().toString());
        requestBody.add("password", "password");
        requestBody.add("scope", "openid");

        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth("techtitans", "70c70de2-2653-4d9d-b31b-9a832d8407b3");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(requestBody, headers);

        ResponseEntity<Map> response = restTemplate.postForEntity(
                "http://localhost:8180/auth/realms/proShift/protocol/openid-connect/token",
                request,
                Map.class
        );

        if (response.getStatusCode().is2xxSuccessful()) {
          // Return Keycloak token along with user information
          String accessToken = response.getBody().get("access_token").toString();
          return ResponseEntity.ok(new AuthResponse(accessToken, user));
        } else {
          return ResponseEntity.badRequest().body(new MessageResponse("Authentication failed"));
        }
      } catch (Exception e) {
        return ResponseEntity.badRequest().body(new MessageResponse("Authentication failed"));
      }
    } else {
      return ResponseEntity.badRequest().body(new MessageResponse("Invalid credentials"));
    }
  }


  @PostMapping("/signup")
  public ResponseEntity<?> registerUser( @RequestBody SignupRequest signUpRequest) {
    if (userRepository.existsByUsername(signUpRequest.getUsername())) {
      return ResponseEntity
              .badRequest()
              .body(new MessageResponse("Error: Username is already taken!"));
    }
    if (userRepository.existsByEmail(signUpRequest.getEmail())) {
      return ResponseEntity
              .badRequest()
              .body(new MessageResponse("Error: Email is already in use!"));
    }
    // Create new user's account
    User user = new User(signUpRequest.getUsername(),
            signUpRequest.getEmail(),
            signUpRequest.getPassword());
    user.setRole(User.ERole.role_employee);

    /////////////////// save Employee with given input
    user.setCongeSolde(21);
    user.setCin(signUpRequest.getCin());
    user.setBlocked(false);
    user.setApproved(true);
    userService.signup(user);
    return ResponseEntity.ok(new MessageResponse("User registered successfully!\n check your email to verify your account!"));
  }

}

