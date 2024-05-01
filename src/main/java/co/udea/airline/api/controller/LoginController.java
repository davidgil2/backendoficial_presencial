package co.udea.airline.api.controller;

import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.udea.airline.api.dto.JWTResponseDTO;
import co.udea.airline.api.dto.LoginRequestDTO;
import co.udea.airline.api.dto.OAuth2LoginRequestDTO;
import co.udea.airline.api.service.LoginService;
import co.udea.airline.api.utils.common.StandardResponse;

@RestController
public class LoginController {

    @Autowired
    LoginService loginService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<StandardResponse<JWTResponseDTO>> login(@RequestBody LoginRequestDTO loginRequest) {

        StandardResponse<JWTResponseDTO> sr = new StandardResponse<>();

        try {

            Jwt jwt = loginService.authenticateUser(loginRequest.email(), loginRequest.password());
            sr.setStatus(0);
            sr.setMessage("success");
            sr.setBody(new JWTResponseDTO(jwt.getSubject(), jwt.getExpiresAt().atZone(ZoneId.systemDefault()),
                    jwt.getTokenValue()));

            return ResponseEntity.ok().body(sr);

        } catch (AuthenticationException exception) {

            sr.setStatus(1);
            sr.setMessage("incorrect email or password");
            sr.setDevMesssage(exception.getMessage());
            sr.setBody(null);

            return ResponseEntity.badRequest().body(sr);

        }
    }

    @PostMapping("/login/google")
    public ResponseEntity<StandardResponse<JWTResponseDTO>> loginWithOauth2(
            @RequestBody OAuth2LoginRequestDTO loginRequest) {

        StandardResponse<JWTResponseDTO> sr = new StandardResponse<>();

        try {

            Jwt jwt = loginService.authenticateIdToken(loginRequest.idToken());
            sr.setStatus(0);
            sr.setMessage("success");
            sr.setBody(new JWTResponseDTO(jwt.getSubject(), jwt.getExpiresAt().atZone(ZoneId.systemDefault()),
                    jwt.getTokenValue()));
            return ResponseEntity.ok().body(sr);

        } catch (AuthenticationException exception) {

            sr.setStatus(1);
            sr.setMessage("authentication error");
            sr.setDevMesssage(exception.getMessage());

            if (exception instanceof UsernameNotFoundException) {
                return ResponseEntity.badRequest().body(sr);
            } else {
                return ResponseEntity.internalServerError().body(sr);
            }

        }
    }

}
