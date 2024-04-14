package co.udea.airline.api.model.jpa.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;

import co.udea.airline.api.model.jpa.model.user.LuggageInfo;

public interface ILuggageInfoRepository extends JpaRepository<LuggageInfo,Integer> {
}
