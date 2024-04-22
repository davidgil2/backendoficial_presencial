package co.udea.airline.api.infraestructure.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// This class represents the error message
public class ErrorMessage {

    private String message;

    private String details;

    public ErrorMessage(String message) {
        this.message = message;
    }

    public ErrorMessage(String message, String details) {
        this.message = message;
        this.details = details;
    }
    
}
