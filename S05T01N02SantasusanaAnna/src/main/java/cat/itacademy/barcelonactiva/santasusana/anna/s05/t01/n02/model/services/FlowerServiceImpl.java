package cat.itacademy.barcelonactiva.santasusana.anna.s05.t01.n02.model.services;

import cat.itacademy.barcelonactiva.santasusana.anna.s05.t01.n02.model.domain.FlowerEntity;
import cat.itacademy.barcelonactiva.santasusana.anna.s05.t01.n02.model.dto.FlowerDTO;
import cat.itacademy.barcelonactiva.santasusana.anna.s05.t01.n02.model.exceptions.FlowerNotFoundException;
import cat.itacademy.barcelonactiva.santasusana.anna.s05.t01.n02.model.repository.IFlowerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FlowerServiceImpl implements IFlowerService {

    @Autowired
    private IFlowerRepo flowerRepo;

    @Override
    public void saveFlower(FlowerDTO flowerDTO) {
        FlowerEntity flower = FlowerModelMapper.singleInstance().toFlower(flowerDTO);
        flowerRepo.save(flower);
    }

    @Override
    public void updateFlower(int flowerID, FlowerDTO flowerDTO) {
        FlowerDTO flower = getFlowerDTOById(flowerID);
        flower.setNameFlower(flowerDTO.getNameFlower());
        flower.setCountryFlower(flowerDTO.getCountryFlower());
        flowerRepo.save(FlowerModelMapper.singleInstance().toFlower(flower));
    }

    @Override
    public FlowerDTO getFlowerDTOById(int flowerID) {
        Optional<FlowerEntity> optionalFlower = flowerRepo.findById(flowerID);
        FlowerEntity flower;
        if(optionalFlower.isPresent()) {
            flower = optionalFlower.get();
        } else {
            throw new FlowerNotFoundException("Flower not found by id: " + flowerID);
        }
        return FlowerModelMapper.singleInstance().toFlowerDTO(flower);
    }

    @Override
    public void deleteFlower(int flowerID) {
        FlowerDTO flower = getFlowerDTOById(flowerID);
        flowerRepo.delete(FlowerModelMapper.singleInstance().toFlower(flower));
    }

    @Override
    public List<FlowerDTO> listFlowers() {
        List<FlowerEntity> flowers = flowerRepo.findAll();
        if(!flowers.isEmpty()) {
            return FlowerModelMapper.singleInstance().toFlowerDTOList(flowerRepo.findAll());
        } else {
            throw new FlowerNotFoundException("The database is empty");
        }
    }

}
