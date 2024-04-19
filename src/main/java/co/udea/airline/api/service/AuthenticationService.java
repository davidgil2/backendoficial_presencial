package co.udea.airline.api.service;

import co.udea.airline.api.model.jpa.model.security.AuthenticationResponse;
import co.udea.airline.api.model.jpa.model.security.Token;
import co.udea.airline.api.model.jpa.model.security.Person;
import co.udea.airline.api.model.jpa.repository.security.TokenRepository;
import co.udea.airline.api.model.jpa.repository.security.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    private final TokenRepository tokenRepository;

    private final AuthenticationManager authenticationManager;

    public AuthenticationService(UserRepository repository,
                                 PasswordEncoder passwordEncoder,
                                 JwtService jwtService,
                                 TokenRepository tokenRepository,
                                 AuthenticationManager authenticationManager) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.tokenRepository = tokenRepository;
        this.authenticationManager = authenticationManager;
    }

    public AuthenticationResponse register(Person request) {

        // check if user already exist. if exist than authenticate the user
        if(repository.findByEmail(request.getEmail()).isPresent()) {
            return new AuthenticationResponse(null, "User already exist");
        }

        Person user = new Person();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setIdentificationNumber(request.getIdentificationNumber());
        user.setIdentificationType(request.getIdentificationType());
        user.setCity(request.getCity());
        user.setCountry(request.getCountry());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setGenre(request.getGenre());
        user.setRoles(request.getRoles());

        user = repository.save(user);

        String jwt = jwtService.generateToken(user);

        saveUserToken(jwt, user);

        return new AuthenticationResponse(jwt, "User registration was successful");

    }

    public AuthenticationResponse authenticate(Person request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        Person user = repository.findByEmail(request.getUsername()).orElseThrow();
        String jwt = jwtService.generateToken(user);

        revokeAllTokenByUser(user);
        saveUserToken(jwt, user);

        return new AuthenticationResponse(jwt, "User login was successful");

    }
    private void revokeAllTokenByUser(Person user) {
        List<Token> validTokens = tokenRepository.findAllTokensByUser(user.getPersonId());
        if(validTokens.isEmpty()) {
            return;
        }

        validTokens.forEach(t-> {
            t.setLoggedOut(true);
        });

        tokenRepository.saveAll(validTokens);
    }
    private void saveUserToken(String jwt, Person user) {
        Token token = new Token();
        token.setToken(jwt);
        token.setLoggedOut(false);
        token.setPerson(user);
        tokenRepository.save(token);
    }
}
