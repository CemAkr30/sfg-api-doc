package cakar.springframework.sfgapidoc.utils;

import cakar.springframework.sfgapidoc.dtos.PetDTO;
import cakar.springframework.sfgapidoc.entities.Pet;
import org.springframework.beans.BeanUtils;

public class AppUtils {
    public static PetDTO entityToDto(Pet pet){
        PetDTO dto = new PetDTO();
        BeanUtils.copyProperties(pet,dto);
        return dto;
    }
}
