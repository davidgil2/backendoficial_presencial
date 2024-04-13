package co.udea.airline.api.utils.exceptions;

public class NumberNotValidException extends RestException{

    public NumberNotValidException(String message) {
        super(message);
    }

    public NumberNotValidException(ErrorMessage errorMessage) {
        super(errorMessage);
    }
    
}
