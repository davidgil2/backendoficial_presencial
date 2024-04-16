package co.udea.airline.api.services.medicalinfo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.udea.airline.api.model.jpa.model.user.MedicalInfo;
import co.udea.airline.api.model.jpa.repository.user.IMedicalInfoRepository;

@Service
public class MedicalInfoService implements IMedicalInfoService {
    @Autowired
    private IMedicalInfoRepository repository;

    public MedicalInfo saveMedicalInfo(MedicalInfo medicalInfo){
        return repository.save(medicalInfo);
    }
}
