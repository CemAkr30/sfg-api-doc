package cakar.springframework.sfgapidoc.controllers;


import cakar.springframework.sfgapidoc.dtos.PetDTO;
import cakar.springframework.sfgapidoc.services.PetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
@RequestMapping(PetController.BASE_URL)
@Api(description = "This is my Pet Controller")
public class PetController {

    public static final String BASE_URL = "/api/pet";
    private final PetService petService;
    @ApiOperation(value = "This will get a list of pets", notes = "Some API notes")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Flux<PetDTO> getPet(){
        return petService.getList();
    }
}
