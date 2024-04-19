package co.udea.airline.api.model.jpa.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import co.udea.airline.api.model.jpa.model.user.LuggageInfo;

/**
 * Interface for accessing and managing LuggageInfo entities in the database.
 * Extends JpaRepository interface to inherit CRUD methods.
 */
public interface ILuggageInfoRepository extends JpaRepository<LuggageInfo,Integer> { }
