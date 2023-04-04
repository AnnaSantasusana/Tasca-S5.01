package cat.itacademy.barcelonactiva.santasusana.anna.s05.t01.n03.model.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class FlowerEntity {

    private int pk_FlowerID;
    private String nameFlower;
    private String countryFlower;

    public FlowerEntity(String nameFlower, String countryFlower) {
        this.nameFlower = nameFlower;
        this.countryFlower = countryFlower;
    }
}
