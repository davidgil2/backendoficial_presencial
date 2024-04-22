package co.udea.airline.api.controller.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.udea.airline.api.model.jpa.model.user.MedicalInfo;
import co.udea.airline.api.services.medicalinfo.service.IMedicalInfoService;

@RestController
@RequestMapping("/v1/medical-info")
public class MedicalInfoController {
    @Autowired
    private IMedicalInfoService service;
    @PostMapping("/add-medical-info")
    public MedicalInfo addMedicalInfo(@RequestBody MedicalInfo medicalInfo){
        return service.saveMedicalInfo(medicalInfo);
    }
}
