package co.udea.airline.api.model.jpa.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;

import co.udea.airline.api.model.jpa.model.user.MedicalInfo;


public interface IMedicalInfoRepository extends JpaRepository<MedicalInfo,Integer> {
}
