package co.udea.airline.api.model.jpa.model.flights;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "AIRPLANE_MODEL")
public class AirplaneModel implements java.io.Serializable {

    @Id
    @Column(name = "airplane_model")
    private String id;

    @Column(name = "family")
    private String family;

    @Column(name = "capacity", precision = 3)
    private int capacity;

    @Column(name = "cargo_capacity", precision = 10, scale = 2)
    private long cargoCapacity;

    @Column(name = "volume_capacity", precision = 10, scale = 2)
    private long volumeCapacity;

    @OneToMany(mappedBy = "airplaneModel")
    private Set<Scale> scales = new HashSet<Scale>();
}
