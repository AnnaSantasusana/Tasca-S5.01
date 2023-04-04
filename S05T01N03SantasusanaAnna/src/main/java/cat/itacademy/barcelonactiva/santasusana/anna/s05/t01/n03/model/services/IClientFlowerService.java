package cat.itacademy.barcelonactiva.santasusana.anna.s05.t01.n03.model.services;

import cat.itacademy.barcelonactiva.santasusana.anna.s05.t01.n03.model.dto.FlowerDTO;
import cat.itacademy.barcelonactiva.santasusana.anna.s05.t01.n03.model.dto.Message;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IClientFlowerService {

    Mono<Message> saveFlower(FlowerDTO flowerDTO);

    Mono<Message> updateFlower(int pk_FlowerID, FlowerDTO flowerDTO);

    Mono<FlowerDTO> getFlowerById(int pk_FlowerID);

    Mono<Message> deleteFlower(int pk_FlowerID);

    Flux<FlowerDTO> listFlowers();


}
