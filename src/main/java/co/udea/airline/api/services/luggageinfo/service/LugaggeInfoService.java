package co.udea.airline.api.services.luggageinfo.service;

import co.udea.airline.api.model.jpa.model.user.LuggageInfo;
import co.udea.airline.api.model.jpa.repository.user.ILuggageInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LugaggeInfoService implements ILugaggeInfoService {

    @Autowired
    private ILuggageInfoRepository repository;

    public LuggageInfo saveLuggageInfo(LuggageInfo lugageInfo){
        return repository.save(lugageInfo);
    }
}
