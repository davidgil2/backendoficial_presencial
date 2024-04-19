package co.udea.airline.api.model.jpa.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import co.udea.airline.api.model.jpa.model.user.MedicalInfo;

/**
 * Interface for accessing and managing MedicalInfo entities in the database.
 * Extends JpaRepository interface to inherit CRUD methods.
 */
public interface IMedicalInfoRepository extends JpaRepository<MedicalInfo,Integer> { }
