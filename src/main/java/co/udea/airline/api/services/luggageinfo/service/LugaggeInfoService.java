package co.udea.airline.api.services.luggageinfo.service;

import co.udea.airline.api.utils.exception.DataDuplicatedException;
import co.udea.airline.api.model.jpa.model.user.LuggageInfo;
import co.udea.airline.api.model.jpa.repository.user.ILuggageInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LugaggeInfoService implements ILugaggeInfoService {

    private final ILuggageInfoRepository repository;

    @Autowired
    public LugaggeInfoService(ILuggageInfoRepository repository) {
        this.repository = repository;
    }


    public ResponseEntity<LuggageInfo> saveLuggageInfo(LuggageInfo lugageInfo){
        try {
            LuggageInfo dbObj = repository.save(lugageInfo);
            return ResponseEntity.ok(dbObj);
        } catch (DataDuplicatedException e) {
            throw new DataDuplicatedException("");
        }
    }
}
