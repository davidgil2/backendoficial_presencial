package co.udea.airline.api.utils.config.security;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.DefaultAuthenticationEventPublisher;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationProvider;

import co.udea.airline.api.model.jpa.repository.security.PersonRepository;

@Configuration
public class AuthenticationConfig {

    @Bean
    AuthenticationManager authenticationManager(PasswordEncoder passwordEncoder,
            UserDetailsService userDetailsService, @Qualifier("googleJwtDecoder") JwtDecoder googleJwtDecoder,
            ApplicationEventPublisher applicationEventPublisher) {
        DaoAuthenticationProvider daoProvider = new DaoAuthenticationProvider(passwordEncoder);
        daoProvider.setUserDetailsService(userDetailsService);
        JwtAuthenticationProvider jwtProvider = new JwtAuthenticationProvider(googleJwtDecoder);

        ProviderManager manager = new ProviderManager(daoProvider, jwtProvider);
        manager.setAuthenticationEventPublisher(new DefaultAuthenticationEventPublisher(applicationEventPublisher));
        return manager;
    }

    @Bean
    UserDetailsService userDetailsService(PersonRepository personRepository) {
        return username -> personRepository.findByEmail(username) // same as email
                .orElseThrow(() -> new UsernameNotFoundException(
                        "user with email '%s' not found".formatted(username)));
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
