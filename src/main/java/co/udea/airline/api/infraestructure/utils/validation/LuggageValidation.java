package co.udea.airline.api.infraestructure.utils.validation;

// This class validates the luggage fields
public class LuggageValidation {

    // This method validates that the luggage decimal fields are positive 
    public static boolean validatePositiveDecimals(double[] values) {
        for (double value : values) {
            if (value < 0) {
                return false;
            }
        }
        return true;
    }

    // This method validates that the extraCharge field is valid
    public static boolean validateExtraCharge(Double extraCharge) {
        if(extraCharge == null) {
            return true;
        }
        return extraCharge >= 0;
    }


    // This method validates that the quantity field is valid
    public static boolean validateQuantity(Integer quantity) {
        if(quantity == null) {
            return true;
        }
        return quantity > 0;
    }
}
