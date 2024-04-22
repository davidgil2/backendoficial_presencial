package co.udea.airline.api.services.boardingpass.service;

import co.udea.airline.api.model.jpa.model.user.BoardingPass;
import co.udea.airline.api.model.jpa.repository.user.IBoardingPassRepository;
import co.udea.airline.api.utils.exception.BusinessException;
import co.udea.airline.api.utils.exception.DataDuplicatedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 * Service class for managing boarding passes.
 */
@Service
public class BoardingPassService implements IBoardingPassService{

    private final IBoardingPassRepository repository;
    // TODO: create this repository
    private final IUserRepository userRepository;

    /**
     * Constructs a new BoardingPassService with the provided boarding pass repository.
     *
     * @param repository The repository for handling boarding pass data access operations.
     */
    @Autowired
    public BoardingPassService(IBoardingPassRepository repository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    /**
     * Creates a new boarding pass.
     *
     * @param boardingPass The boarding pass to create.
     * @return ResponseEntity with HTTP status 200 (OK) and the created boarding pass if successful,
     *         ResponseEntity with HTTP status 409 (CONFLICT) if the boarding pass already exists,
     *         ResponseEntity with HTTP status 500 (INTERNAL_SERVER_ERROR) if an unexpected error occurs.
     * @throws DataDuplicatedException    If the boarding pass already exists in the database.
     * @throws BusinessException          If a data integrity violation or database error occurs.
     * @throws IllegalArgumentException  If an invalid argument is passed.
     * @throws ResponseStatusException    If an unexpected error occurs during the operation.
     *
     */
    @Override
    public ResponseEntity<BoardingPass> createBoardingPass(BoardingPass boardingPass) {
        try {
            // TODO: change for the user id
            // Check if a boarding pass with the given ID already exists
            if (userRepository.existsById(boardingPass.getPassenger().getPassagerId())) {
                // Boarding pass already exists, throw HTTP exception
                throw new DataDuplicatedException("Boarding pass already exists");
            } else {
                // Boarding pass does not exist, proceed to create
                BoardingPass createdBoardingPass = repository.save(boardingPass);
                return ResponseEntity.ok(createdBoardingPass);
            }
        } catch (DataIntegrityViolationException e) {
            // Handle data integrity violations
            throw new BusinessException("Data integrity violation");
        } catch (DataAccessException e) {
            // Handle database access errors
            throw new BusinessException("Database error");
        } catch (IllegalArgumentException e) {
            // Handle illegal argument exceptions
            throw new IllegalArgumentException("Invalid argument: " + e.getMessage(), e);
        } catch (Throwable e) {
            // Handle other unexpected errors
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to create boarding pass", e);
        }
    }

    /**
     * Retrieves an existing boarding pass.
     *
     * @param userId the id of the user.
     * @return The retrieved boarding pass.
     */
    @Override
    public ResponseEntity<BoardingPass> getBoardingPass(int userId) {
        return null;
    }
}
