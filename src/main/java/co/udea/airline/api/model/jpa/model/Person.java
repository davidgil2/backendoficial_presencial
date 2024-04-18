package co.udea.airline.api.model.jpa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PERSON_ID") // TODO: create name conversion strategy
    private Long personId;

    @Column(name = "IDENTIFICATION_NUMBER")
    private String id_number;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    private Character genre;

    @Column(name = "BIRTH_DATE")
    private Date birthDate;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    private String country;
    private String province;
    private String city;
    private String residence;

    private String email;

    @Column(name = "ACCESS_KEY")
    private String password;


}
