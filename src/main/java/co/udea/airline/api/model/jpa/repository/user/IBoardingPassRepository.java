package co.udea.airline.api.model.jpa.repository.user;

import co.udea.airline.api.model.jpa.model.user.BoardingPass;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface for accessing and managing BoardingPass entities in the database.
 * Extends JpaRepository interface to inherit CRUD methods.
 */
public interface IBoardingPassRepository extends JpaRepository<BoardingPass,Integer> {

    /**
     * Checks if a boarding pass exists for a given passenger ID.
     *
     * @param passengerId The ID of the passenger to check for boarding pass existence.
     * @return {@code true} if a boarding pass exists for the given passenger ID, {@code false} otherwise.
     */
    boolean existsByPassengerId(int passengerId);
}
