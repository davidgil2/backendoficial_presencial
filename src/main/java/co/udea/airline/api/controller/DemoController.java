package co.udea.airline.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "3. Authorization demos", description = "Basic authorization filter for user and admin roles")
public class DemoController {

    @GetMapping("/demo")
    public ResponseEntity<String> demo() {
        return ResponseEntity.ok("Hello from secured url");
    }

    @GetMapping("/admin_only")
    @SecurityRequirement(name = "JWT")
    public ResponseEntity<String> adminOnly() {
        return ResponseEntity.ok("Hello from admin only url");
    }
}
