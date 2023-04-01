package cakar.springframework.sfgapidoc.repositories;

import cakar.springframework.sfgapidoc.entities.Pet;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PetRepository extends ReactiveMongoRepository<Pet,String> {

}
