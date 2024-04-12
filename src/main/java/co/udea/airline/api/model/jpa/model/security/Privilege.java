package co.udea.airline.api.model.jpa.model.security;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Privilege implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRIVILEGE_ID")
    private Long privilegeId;

    @Column(name = "PRIVILEGE_NAME")
    private String name;

    @Column(name = "DETAIL")
    private String detail;

    @OneToMany(mappedBy = "privilege")
    private List<PositionPrivilege> positionAssoc;

    @Override
    public String getAuthority() {
        return getName().toLowerCase();
    }
}
