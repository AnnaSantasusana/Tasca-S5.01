package cat.itacademy.barcelonactiva.santasusana.anna.s05.t01.n03.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Arrays;
import java.util.List;

@NoArgsConstructor
@Data
public class FlowerDTO {

    private int pk_FlowerID;
    @NotBlank(message = "Name cannot be empty")
    private String nameFlower;
    @NotBlank(message = "Country cannot be empty")
    private String countryFlower;
    private String typeFlower;
    private List<String> countriesUE = Arrays.asList("Austria", "Belgium", "Bulgaria", "Croatia", "Republic of Cyprus",
            "Czech Republic", "Denmark", "Estonia", "Finland", "France", "Germany", "Greece", "Hungary", "Ireland",
            "Italy", "Latvia", "Lithuania", "Luxembourg", "Malta", "Netherlands", "Poland", "Portugal", "Romania",
            "Slovakia", "Slovenia", "Spain", "Sweden");

    public FlowerDTO (String nameFlower, String countryFlower) {
        this.nameFlower = nameFlower;
        this.countryFlower = countryFlower;
    }
    public void setCountryFlower(String countryFlower) {
        this.countryFlower = countryFlower;

        this.typeFlower = countriesUE.contains(countryFlower) ? "UE" : "NOT UE";
    }
}
