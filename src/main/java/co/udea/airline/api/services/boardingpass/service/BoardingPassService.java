package co.udea.airline.api.services.boardingpass.service;

import co.udea.airline.api.model.jpa.model.user.BoardingPass;
import co.udea.airline.api.model.jpa.repository.user.IBoardingPassRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class BoardingPassService implements IBoardingPassService{

    @Autowired
    private IBoardingPassRepository repository;

    @Override
    public BoardingPass createBoardingPass(BoardingPass boardingPass) {

        return null;
    }
}
