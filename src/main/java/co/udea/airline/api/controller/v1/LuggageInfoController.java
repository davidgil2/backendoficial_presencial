package co.udea.airline.api.controller.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.udea.airline.api.model.jpa.model.user.LuggageInfo;
import co.udea.airline.api.services.luggageinfo.service.ILugaggeInfoService;

@RestController
@RequestMapping("/v1/luggage-info")
public class LuggageInfoController {
    @Autowired
    private ILugaggeInfoService service;
    @PostMapping("/add-luggage-info")
    public LuggageInfo addLuggageInfo(@RequestBody LuggageInfo luggageInfo){
        return service.saveLuggageInfo(luggageInfo);
    }
}
