package co.udea.airline.api.model.jpa.model.security;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="PRIVILAGE")
public class Privilege {

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
}
