package co.udea.airline.api;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AirlineApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(AirlineApiApplication.class, args);
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(new Info()
                .title("RESERVATIONS SITAS")
                .description("REST API for SITAS app, reservations")
                .version("v1.0.0")
                .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }
}
