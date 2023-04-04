package cat.itacademy.barcelonactiva.santasusana.anna.s05.t01.n03.model.services;

import cat.itacademy.barcelonactiva.santasusana.anna.s05.t01.n03.model.dto.FlowerDTO;
import cat.itacademy.barcelonactiva.santasusana.anna.s05.t01.n03.model.dto.Message;
import cat.itacademy.barcelonactiva.santasusana.anna.s05.t01.n03.model.exceptions.FlowerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.util.Date;

@Service
public class ClientFlowerServiceImpl implements IClientFlowerService {

    @Autowired
    private WebClient webClient;

    @Override
    public Mono<Message> saveFlower(FlowerDTO flowerDTO) {
        return webClient.post()
                .uri(uriBuilder -> uriBuilder.path("/add").build())
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(flowerDTO)
                .retrieve()
                .bodyToMono(Void.class)
                .thenReturn(new Message(HttpStatus.CREATED.value(), new Date(), "Flower added correctly"));
    }

    @Override
    public Mono<Message> updateFlower(int pk_FlowerID, FlowerDTO flowerDTO) {
        return webClient.put()
                .uri(uriBuilder -> uriBuilder.path("/update/{flowerID}").build(pk_FlowerID))
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(flowerDTO)
                .retrieve()
                .bodyToMono(Void.class)
                .thenReturn(new Message(HttpStatus.OK.value(), new Date(), "Flower updated correctly"))
                .onErrorMap(WebClientResponseException.NotFound.class, ex -> new FlowerNotFoundException("Flower not found by id: " + pk_FlowerID));
    }

    @Override
    public Mono<FlowerDTO> getFlowerById(int pk_FlowerID) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/getOne/{pk_FlowerID}").build(pk_FlowerID))
                .retrieve()
                .bodyToMono(FlowerDTO.class)
                .onErrorMap(WebClientResponseException.NotFound.class, ex -> new FlowerNotFoundException("Flower not found by id: " + pk_FlowerID));
    }

    @Override
    public Mono<Message> deleteFlower(int pk_FlowerID) {
        return webClient.delete()
                .uri(uriBuilder -> uriBuilder.path("/delete/{flowerID}").build(pk_FlowerID))
                .retrieve()
                .bodyToMono(Void.class)
                .thenReturn(new Message(HttpStatus.OK.value(), new Date(), "Flower removed correctly"))
                .onErrorMap(WebClientResponseException.NotFound.class, ex -> new FlowerNotFoundException("Flower not found by id: " + pk_FlowerID));
    }

    @Override
    public Flux<FlowerDTO> listFlowers() {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/getAll").build())
                .retrieve()
                .bodyToFlux(FlowerDTO.class)
                .onErrorMap(WebClientResponseException.NotFound.class, ex -> new FlowerNotFoundException("The database is empty"));
    }

}
