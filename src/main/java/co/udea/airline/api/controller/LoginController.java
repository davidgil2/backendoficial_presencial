package co.udea.airline.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.udea.airline.api.services.LoginService;

@RestController
public class LoginController {

    record LoginRequest(String email, String password) {
    }

    @Autowired
    LoginService loginService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {

        Authentication auth = new UsernamePasswordAuthenticationToken(loginRequest.email, loginRequest.password);
        auth = authenticationManager.authenticate(auth);
        try {

            Jwt token = loginService.loginUser(auth);
            return ResponseEntity.ok().body(token.getTokenValue());

        } catch (AuthenticationException exception) {

            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("bad username or password");
        }

    }

}
