package co.udea.airline.api.services.luggageinfo.service;

import co.udea.airline.api.model.jpa.model.user.LuggageInfo;
import org.springframework.http.ResponseEntity;

public interface ILugaggeInfoService {

    public ResponseEntity<LuggageInfo> saveLuggageInfo(LuggageInfo lugageInfo);

}
