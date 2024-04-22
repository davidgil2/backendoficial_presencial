package co.udea.airline.api.model.jpa.model.bookings;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Data
@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "Person", schema = "Code_factory2")
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

    @Column(name = "GENRE")
    private Character genre;

    @Column(name = "BIRTH_DATE")
    private Date birthDate;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "COUNTRY")
    private String country;

    @Column(name = "PROVINCE")
    private String province;

    @Column(name = "CITY")
    private String city;

    @Column(name = "RESIDENCE")
    private String residence;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "ACCESS_KEY")
    private String password;
}
