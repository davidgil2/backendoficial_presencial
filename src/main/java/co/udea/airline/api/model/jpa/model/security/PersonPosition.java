package co.udea.airline.api.model.jpa.model.security;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "PERSONPOSITION")
public class PersonPosition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PERSON_POSITION_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "PERSON_ID")
    private User user;
    
    @ManyToOne
    @JoinColumn(name = "POSITION_ID")
    private Position position;

}
