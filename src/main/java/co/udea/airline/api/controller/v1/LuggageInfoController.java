package co.udea.airline.api.controller.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import co.udea.airline.api.model.jpa.model.user.LuggageInfo;
import co.udea.airline.api.services.luggageinfo.service.ILugaggeInfoService;

@RestController
public class LuggageInfoController {
    @Autowired
    private ILugaggeInfoService service;
    @PostMapping("/v1/luggage-info/add-luggage-info")
    public LuggageInfo addLuggageInfo(@RequestBody LuggageInfo luggageInfo){
        return service.saveLuggageInfo(luggageInfo);
    }
}
