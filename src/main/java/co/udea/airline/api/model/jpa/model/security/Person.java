package co.udea.airline.api.model.jpa.model.security;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

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
public class Person implements UserDetails {

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

    public List<Position> getPositions() {
        return getPositionAssoc().stream().map(posAssoc -> posAssoc.getPosition()).collect(Collectors.toList());
    }

    public Set<Privilege> getPrivileges() {
        return getPositions().stream()
                .map(pos -> pos.getPrivileges())
                .flatMap(List::stream)
                .collect(Collectors.toSet());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // prefix all roles with 'ROLE_' and uppercase them
        Set<GrantedAuthority> authorities = getPositions().stream()
                .map(pos -> new SimpleGrantedAuthority("ROLE_".concat(pos.getName().toUpperCase())))
                .collect(Collectors.toSet());

        // add all privleges
        authorities.addAll(getPrivileges());

        return authorities;
    }

    @Override
    public String getUsername() {
        return getEmail();
    }

    // TODO: implement in the db all of the below methods

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
