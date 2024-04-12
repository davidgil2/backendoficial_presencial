package co.udea.airline.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import co.udea.airline.api.model.jpa.model.security.Person;
import co.udea.airline.api.model.jpa.repository.security.PersonRepository;
import co.udea.airline.api.utils.common.JwtUtils;

@Service
public class LoginService {

        @Autowired
        PersonRepository personRepository;

        @Autowired
        JwtUtils jwtUtils;

        public Jwt loginUser(Authentication authentication) throws AuthenticationException {

                if (authentication.isAuthenticated()) {
                        Person person = personRepository.findByEmail(authentication.getName()).orElseThrow();
                        return jwtUtils.createToken(person);
                }
                throw new AuthenticationServiceException(
                                "cannot authenticate user %s".formatted(authentication.getName()));
        }

}
