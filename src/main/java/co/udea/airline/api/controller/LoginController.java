package co.udea.airline.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.udea.airline.api.dto.LoginRequestDTO;
import co.udea.airline.api.dto.OAuth2LoginRequestDTO;
import co.udea.airline.api.services.LoginService;

@RestController
public class LoginController {

    @Autowired
    LoginService loginService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDTO loginRequest) {

        try {
            Jwt token = loginService.authenticateUser(loginRequest.email(), loginRequest.password());
            return ResponseEntity.ok().body(token.getTokenValue());
        } catch (AuthenticationException exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("incorrect username or password");
        }
    }

    @PostMapping("/login/google")
    public ResponseEntity<String> loginWithOauth2(@RequestBody OAuth2LoginRequestDTO loginRequest) {
        try {
            Jwt jwt = loginService.authenticateIdToken(loginRequest.idToken());
            return ResponseEntity.ok().body(jwt.getTokenValue());
        } catch (UsernameNotFoundException exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("user not found");
        } catch (AuthenticationException exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("invalid jwt");
        }
    }

}
