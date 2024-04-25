package co.udea.airline.api.model.jpa.mapper.user;

import co.udea.airline.api.model.jpa.dto.user.BoardingPassDTO;
import co.udea.airline.api.model.jpa.model.user.BoardingPass;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * Mapper interface for mapping between the BoardingPass entity and its corresponding DTO.
 * This interface defines methods to map BoardingPass entities to BoardingPassDTOs and vice versa.
 */
@Mapper
public interface IBoardingPassMapper {

    /**
     * Singleton instance of the IBoardingPassMapper interface.
     */
    IBoardingPassMapper INSTANCE = Mappers.getMapper(IBoardingPassMapper.class);

    /**
     * Maps a BoardingPass entity to a BoardingPassDTO.
     *
     * @param boardingPass The BoardingPass entity to be mapped.
     * @return The mapped BoardingPassDTO.
     */
    @Mapping(target = "passengerId", source = "passenger.id")
    BoardingPassDTO boardingPassToBoardingPassDTO(BoardingPass boardingPass);

    /**
     * Maps a BoardingPassDTO to a BoardingPass entity.
     *
     * @param boardingPassDTO The BoardingPassDTO to be mapped.
     * @return The mapped BoardingPass entity.
     */
    @Mapping(target = "passenger.id", source = "passengerId")
    BoardingPass boardingPassDTOToBoardingPass(BoardingPassDTO boardingPassDTO);
}

