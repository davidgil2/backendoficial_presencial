package co.udea.airline.api.infraestructure.exceptions;

public class NumberNotValidException extends RestException{

    public NumberNotValidException(String message) {
        super(message);
    }

    public NumberNotValidException(ErrorMessage errorMessage) {
        super(errorMessage);
    }
    
}
