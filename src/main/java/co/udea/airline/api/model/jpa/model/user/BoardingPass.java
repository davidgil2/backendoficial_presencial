package co.udea.airline.api.model.jpa.model.user;

import jakarta.persistence.*;

import lombok.*;

import java.sql.Timestamp;

/**
 * Represents Boording Pass information.
 * This class is mapped to the "BOARDING_PASS" table in the database.
 */
@Entity
@Data
@NoArgsConstructor
@Table(name = "BOARDING_PASS")
public class BoardingPass {

    /**
     * Unique identifier for Boarding Pass.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOARDING_PASS_ID")
    private Long boardingPassId;

    // TODO: Create all this models
    //@ManyToOne
    //@JoinColumn(name = "passenger_id")
    //@NonNull
    //private Passeger passenger;

    //@ManyToOne
    //@JoinColumn(name = "booking_id")
    //@NonNull
    //private Booking booking;

    //@ManyToOne
    //@JoinColumn(name = "Flight_ID")
    //@NonNull
    // Flight flight;

    /**
     * Medical information associated with this boarding pass.
     * Represents a many-to-one relationship with the MedicalInfo entity.
     */
    @ManyToOne
    @JoinColumn(name = "MEDICAL_INFO_ID")
    @NonNull
    private MedicalInfo medicalInfo;


    /**
     * Luggage information associated with this boarding pass.
     * Represents a many-to-one relationship with the LuggageInfo entity.
     */
    @ManyToOne
    @JoinColumn(name = "LUGGAGE_INFO_ID")
    @NonNull
    private LuggageInfo luggageInfo;

    /**
     * Timestamp indicating the boarding time.
     * This column is mapped to the "BOARDING_TIME" column in the database.
     */
    @Column(name = "BOARDING_TIME", nullable = false)
    @NonNull
    private Timestamp boardingTime;
}
