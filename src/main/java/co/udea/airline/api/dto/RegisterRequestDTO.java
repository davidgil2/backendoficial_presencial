package co.udea.airline.api.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegisterRequestDTO {
    String idType;
    String idNumber;
    String firstName;
    String lastName;
    Character genre;
    LocalDate birthDate;
    String phoneNumber;
    String country;
    String province;
    String city;
    String residence;
    String email;
    String password;

}