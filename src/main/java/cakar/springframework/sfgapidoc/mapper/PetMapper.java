package cakar.springframework.sfgapidoc.mapper;


import cakar.springframework.sfgapidoc.dtos.PetDTO;
import cakar.springframework.sfgapidoc.entities.Pet;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PetMapper {
    PetDTO petToPetDTO(Pet pet);
    Pet petDTOToPet(PetDTO petDTO);
}
