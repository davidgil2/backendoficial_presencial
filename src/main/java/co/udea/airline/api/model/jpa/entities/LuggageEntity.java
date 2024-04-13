package co.udea.airline.api.model.jpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Setter;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Setter
@Table(name = "luggage")
@NoArgsConstructor
public class LuggageEntity {

    public LuggageEntity(String luggageType, Double extraCharge, Integer quantity, Double width, Double height,
            Double length, Double weight, String description, Long userId, Long flightId, Long bookingId) {
        this.luggageType = luggageType;
        this.extraCharge = extraCharge;
        this.quantity = quantity;
        this.width = width;
        this.height = height;
        this.length = length;
        this.weight = weight;
        this.description = description;
        this.userId = userId;
        this.flightId = flightId;
        this.bookingId = bookingId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    Long id;

    @Column(nullable = false, length = 100, name = "luggage_type")
    String luggageType;

    @Column(name = "extra_charge")
    Double extraCharge;

    @Column
    Integer quantity;

    @Column(nullable = false)
    Double width;

    @Column(nullable = false)
    Double height;

    @Column(nullable = false)
    Double length;

    @Column(nullable = false)
    Double weight;

    @Column(nullable = false, length = 150)
    String description;

    @Column(nullable = false, name = "user_id")
    Long userId;

    @Column(nullable = false, name = "flight_id")
    Long flightId;

    @Column(nullable = false, name = "booking_id")
    Long bookingId;

    @ManyToOne
    @JoinColumn(name = "placement_area_id", nullable = false)
    PlacementAreaEntity placementArea;

    @PrePersist
    public void prePersist() {
        if (extraCharge == null) {
            extraCharge = 0.0;
        }

        if (quantity == null) {
            quantity = 1;
        }
    }

}
