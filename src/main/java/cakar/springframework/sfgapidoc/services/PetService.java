package cakar.springframework.sfgapidoc.services;


import cakar.springframework.sfgapidoc.dtos.PetDTO;
import cakar.springframework.sfgapidoc.entities.Pet;
import cakar.springframework.sfgapidoc.mapper.PetMapper;
import cakar.springframework.sfgapidoc.repositories.PetRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Slf4j
public class PetService {

    private final PetRepository petRepository;

    private final PetMapper petMapper;

    public Flux<PetDTO> getList() {
          //List<Pet> petList  = new ArrayList<>();
//        petList.add(Pet.builder().id("1").name("Fido").type("Dog").build());
//        petList.add(Pet.builder().id("2").name("Garfield").type("Cat").build());
//        petList.add(Pet.builder().id("3").name("Bingo").type("Dog").build());
//        petList.add(Pet.builder().id("4").name("Bella").type("Dog").build());
//        Flux<Pet> petFlux = Flux.just(petList.get(0), petList.get(1), petList.get(2), petList.get(3));
          Flux<Pet> petFlux = petRepository.findAll();
        log.info(petFlux.toString());
        return petFlux.map(petMapper::petToPetDTO);
    }
}
