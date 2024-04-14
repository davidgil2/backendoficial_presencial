package co.udea.airline.api.model.jpa.model.user;

import jakarta.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents medical information related to a person.
 * This class is mapped to the "MEDICAL_INFO" table in the database.
 */
@Entity
@NoArgsConstructor
@Data
@Table(name = "MEDICAL_INFO")
public class MedicalInfo {
    /**
     * Unique identifier for medical information.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int medicalInfoId;

    /**
     * Identifier of the person associated with this medical information.
     */
    @JoinColumn(name = "PERSON", referencedColumnName = "PERSON_ID")
    @Column(name = "PERSON_ID")
    private Integer personId;

    /**
     * Medical conditions of the person.
     */
    @Column(name = "MEDICAL_CONDITIONS")
    private String medicalConditions;

    /**
     * Name of the emergency contact person.
     */
    @Column(name = "EMERGENCY_CONTACT_NAME")
    private String contactName;

    /**
     * Phone number of the emergency contact person.
     */
    @Column(name = "EMERGENCY_CONTACT_PHONE")
    private String contactPhone;
}
