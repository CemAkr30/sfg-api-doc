package cakar.springframework.sfgapidoc.fn;


import cakar.springframework.sfgapidoc.dtos.PetDTO;
import cakar.springframework.sfgapidoc.services.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class PetHandler {

    private final PetService petService;

    public Mono<ServerResponse> getPetList(ServerRequest request){
        Flux<PetDTO> flux = petService.getList();
        PetDTO petDTO = new PetDTO();
        return ServerResponse.ok().body(flux, PetDTO.class);
    }
}
