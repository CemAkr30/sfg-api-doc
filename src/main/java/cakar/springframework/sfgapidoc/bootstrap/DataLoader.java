package cakar.springframework.sfgapidoc.bootstrap;

import cakar.springframework.sfgapidoc.entities.Pet;
import cakar.springframework.sfgapidoc.repositories.PetRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

import java.util.UUID;


@Component
@Slf4j
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {


    private final PetRepository petRepository;

    @Override
    public void run(String... args) throws Exception {
        log.info("Loading Bootstrap Data");
        loadPets();
    }


    @Transactional
    void loadPets(){
        petRepository.saveAll(createPet("Fido", "Dog")).subscribe();
        petRepository.saveAll(createPet("Garfield", "Cat")).subscribe();
        petRepository.saveAll(createPet("Bingo", "Dog")).subscribe();
        petRepository.saveAll(createPet("Bella", "Dog")).subscribe();
        petRepository.saveAll(createPet("Milo", "Cat")).subscribe();
        petRepository.insert(createPet("Milo", "Cat")).subscribe();
    }

    private Mono<Pet> createPet(String name, String type){
        return Mono.just(Pet.builder()
                .id(UUID.randomUUID().toString())
                .name(name)
                .type(type)
                .build());
    }
}
