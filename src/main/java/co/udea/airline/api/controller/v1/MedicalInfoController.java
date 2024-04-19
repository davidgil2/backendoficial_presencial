package co.udea.airline.api.controller.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import co.udea.airline.api.model.jpa.model.user.MedicalInfo;
import co.udea.airline.api.services.medicalinfo.service.IMedicalInfoService;

@RestController
public class MedicalInfoController {
    @Autowired
    private IMedicalInfoService service;
    @PostMapping("/v1/medical-info/add-medical-info")
    public MedicalInfo addMedicalInfo(@RequestBody MedicalInfo medicalInfo){
        return service.saveMedicalInfo(medicalInfo);
    }
}
