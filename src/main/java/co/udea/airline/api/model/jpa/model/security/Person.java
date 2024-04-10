package co.udea.airline.api.model.jpa.model.security;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PERSON_ID") // TODO: create name conversion strategy
    private Long personId;

    @OneToOne
    @NotNull
    @JoinColumn(name = "ID_IDENTIFICATION_TYPE")
    private IdentificationType identificationType;

    @NotBlank
    @Column(name = "IDENTIFICATION_NUMBER")
    private String identificationNumber;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    private Character genre;

    @Column(name = "BIRTH_DATE")
    private LocalDate birthDate;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    private String country;
    private String province;
    private String city;
    private String residence;

    @Email
    private String email;

    @NotBlank
    @Column(name = "ACCESS_KEY")
    private String password;

    @OneToMany(mappedBy = "person")
    private List<PersonPosition> positionAssoc;

}
