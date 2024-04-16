package co.udea.airline.api.services.medicalinfo.service;

import co.udea.airline.api.model.jpa.model.user.MedicalInfo;

public interface IMedicalInfoService {

    public MedicalInfo saveMedicalInfo(MedicalInfo medicalInfo);
}
