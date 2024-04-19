package co.udea.airline.api.services.luggageinfo.service;

import co.udea.airline.api.utils.exception.DataDuplicatedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.udea.airline.api.model.jpa.model.user.LuggageInfo;
import co.udea.airline.api.model.jpa.repository.user.ILuggageInfoRepository;

@Service
public class LugaggeInfoService implements ILugaggeInfoService {

    @Autowired
    private ILuggageInfoRepository repository;

    public LuggageInfo saveLuggageInfo(LuggageInfo lugageInfo){
        try {
            LuggageInfo dbObj = repository.save(lugageInfo);
            return dbObj;
        } catch (DataDuplicatedException e) {
            throw new DataDuplicatedException("");
        }
    }
}
