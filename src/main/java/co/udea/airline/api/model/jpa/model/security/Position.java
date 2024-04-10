package co.udea.airline.api.model.jpa.model.security;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Position { // == Role

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "POSITION_ID")
    private Long positionId;

    @Column(name = "POSITION_NAME")
    private String name;

    @Column(name = "DETAIL")
    private String detail;

    @OneToMany(mappedBy = "position")
    private List<PersonPosition> personAssoc;

    @OneToMany(mappedBy = "position")
    private List<PositionPrivilege> privilegeAssoc;

}
