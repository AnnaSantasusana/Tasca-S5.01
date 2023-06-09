package cat.itacademy.barcelonactiva.santasusana.anna.s05.t01.n02.model.services;

import cat.itacademy.barcelonactiva.santasusana.anna.s05.t01.n02.model.dto.FlowerDTO;

import java.util.List;

public interface IFlowerService {

    void saveFlower(FlowerDTO flowerDTO);

    void updateFlower(int flowerID, FlowerDTO flowerDTO);

    FlowerDTO getFlowerDTOById(int flowerID);

    void deleteFlower(int flowerID);

    List<FlowerDTO> listFlowers();
}
