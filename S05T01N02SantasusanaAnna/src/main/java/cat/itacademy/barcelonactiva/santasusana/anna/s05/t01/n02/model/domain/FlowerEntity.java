package cat.itacademy.barcelonactiva.santasusana.anna.s05.t01.n02.model.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Table(name = "flower")
@Entity
public class FlowerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int pk_FlowerID;
    @Column(name = "name")
    private String nameFlower;
    @Column(name = "country")
    private String countryFlower;

    public FlowerEntity(String nameFlower, String countryFlower) {
        this.nameFlower = nameFlower;
        this.countryFlower = countryFlower;
    }
}
