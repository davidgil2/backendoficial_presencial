package co.udea.airline.api.model.jpa.model.user;

import jakarta.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * Represents luggage information related to a user.
 * This class is mapped to the "LUGGAGE_INFO" table in the database.
 */
@Entity
@Data
@NoArgsConstructor
@Table (name = "LUGGAGE_INFO")
public class LuggageInfo {
    /**
     * Unique identifier for luggage information.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int luggageInfoId;

    /**
     * Shipping address for the luggage.
     * Non-null field.
     */
    @Column(name = "SHIPPING_ADDRESS")
    @NonNull
    private String shippingAddress;

    /**
     * Identifier for the luggage.
     */
    @Column(name = "LUGGAGE_ID")
    private int luggageId;
}
