package cakar.springframework.sfgapidoc.config;

import cakar.springframework.sfgapidoc.entities.Pet;
import cakar.springframework.sfgapidoc.repositories.PetRepository;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import reactor.core.publisher.Flux;

import java.util.concurrent.ThreadLocalRandom;


@Configuration
@EnableMongoRepositories
public class MongoConfiguration extends AbstractReactiveMongoConfiguration {

    @Override
    protected String getDatabaseName() {
        return "sfg";
    }

    @Override
    @Bean
    public MongoClient reactiveMongoClient() {
        return MongoClients.create("mongodb://root:example@localhost:2727/sfg?authSource=admin");
    }

    @Bean
    public ReactiveMongoTemplate reactiveMongoTemplate() {
        return new ReactiveMongoTemplate(reactiveMongoClient(), getDatabaseName());
    }

    @Bean
    @ConditionalOnProperty(prefix = "job.autorun", name = "enabled", havingValue = "true", matchIfMissing = true)
    public CommandLineRunner loadData(PetRepository repository) {
        return (args) -> {
            // save a couple of users
            var pets = Flux.just(
                    new Pet("1","Gökhan","Köpek"),
                    new Pet("2","Betül","Kedi")
            );
            repository.saveAll(pets).subscribe();
        };
    }
}