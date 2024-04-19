package co.udea.airline.api.model.jpa.model.security;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
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
@Table(name="PERSON")
public class Person implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PERSON_ID") // TODO: create name conversion strategy
    private Integer personId;

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
    @Column(name = "COUNTRY")
    private String country;
    @Column(name = "PROVINCE")
    private String province;
    @Column(name = "CITY")
    private String city;
    @Column(name = "RESIDENCE")
    private String residence;

    @Email
    private String email;

    @NotBlank
    @Column(name = "ACCESS_KEY")
    private String password;
    @OneToMany(mappedBy = "person", fetch = FetchType.EAGER)
    private List<PersonPosition> positionAssoc;

    @ManyToMany
    @JoinTable(name = "PERSONPOSITION", joinColumns = @JoinColumn(name = "PERSON_ID"), inverseJoinColumns = @JoinColumn(name = "POSITION_ID")) // TODO: test what happens when saving a person
    private List<Position> roles;
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

    @OneToMany(mappedBy = "person")
    private List<Token> tokens;

    public IdentificationType getIdentificationType() {
        return identificationType;
    }

    public void setIdentificationType(IdentificationType identificationType) {
        this.identificationType = identificationType;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public Integer getPersonId() {
        return personId;
    }

    public List<PersonPosition> getPositionAssoc() {
        return positionAssoc;
    }

    public void setPositionAssoc(List<PersonPosition> positionAssoc) {
        this.positionAssoc = positionAssoc;
    }

    public List<Position> getRoles() {
        return roles;
    }

    public void setRoles(List<Position> roles) {
        this.roles = roles;
    }

    public void setPersonId(Integer id) {
        this.personId = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return email;
    }

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

    public void setEmail(String email) {
        this.email = email;
    }

    @Override

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Token> getTokens() {
        return tokens;
    }

    public void setTokens(List<Token> tokens) {
        this.tokens = tokens;
    }

    public Character getGenre() {
        return genre;
    }

    public void setGenre(Character genre) {
        this.genre = genre;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public String getEmail() {
        return email;
    }
}
