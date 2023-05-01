package cat.itacademy.barcelonactiva.santasusana.anna.s05.t01.n02.model.services;

import cat.itacademy.barcelonactiva.santasusana.anna.s05.t01.n02.model.domain.FlowerEntity;
import cat.itacademy.barcelonactiva.santasusana.anna.s05.t01.n02.model.dto.FlowerDTO;
import org.modelmapper.ModelMapper;
import java.util.List;
import java.util.stream.Collectors;

public class FlowerModelMapper {

    private final ModelMapper mapper = new ModelMapper();

    private static FlowerModelMapper instance;

    private FlowerModelMapper() {}

    public static FlowerModelMapper singleInstance() {
        if (instance == null) {
            instance = new FlowerModelMapper();
        }
        return instance;
    }

    public FlowerDTO toFlowerDTO(FlowerEntity flower) {
        return mapper.map(flower, FlowerDTO.class);
    }

    public FlowerEntity toFlower(FlowerDTO flowerDTO) {
        return mapper.map(flowerDTO, FlowerEntity.class);
    }

    public List<FlowerDTO> toFlowerDTOList(List<FlowerEntity> flowerList) {
        return flowerList.stream().map(this::toFlowerDTO).collect(Collectors.toList());
    }
}
