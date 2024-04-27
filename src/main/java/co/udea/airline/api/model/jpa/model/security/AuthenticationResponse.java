package co.udea.airline.api.model.jpa.model.security;

import org.springframework.security.oauth2.jwt.Jwt;

public class AuthenticationResponse {
    private final Jwt token;
    private final String message;

    public AuthenticationResponse(Jwt token, String message) {
        this.token = token;
        this.message = message;
    }

    public Jwt getToken() {
        return token;
    }

    public String getMessage() {
        return message;
    }
}
