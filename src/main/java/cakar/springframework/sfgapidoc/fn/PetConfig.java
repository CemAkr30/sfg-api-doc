package cakar.springframework.sfgapidoc.fn;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
@RequiredArgsConstructor
public class PetConfig {
    private static final String PET_COLLECTION = "/api/pet";
    private final PetHandler petHandler;

    @Bean
    public RouterFunction<ServerResponse> getRoutes(){
        return route()
                .GET(PET_COLLECTION, petHandler::getPetList)
                .build();
    }
}
