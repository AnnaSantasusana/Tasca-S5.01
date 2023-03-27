package cat.itacademy.barcelonactiva.santasusana.anna.s05.t01.n01.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import java.util.Arrays;
import java.util.List;

@NoArgsConstructor
@Data
public class BranchOfficeDTO {

    private int pk_BranchID;
    @NotBlank(message = "Name cannot be empty")
    private String nameBranch;
    @NotBlank(message = "Country cannot be empty")
    private String countryBranch;
    private String typeBranch;
    private final List<String> COUNTRIES_UE = Arrays.asList("Austria", "Belgium", "Bulgaria", "Croatia", "Republic of Cyprus",
            "Czech Republic", "Denmark", "Estonia", "Finland", "France", "Germany", "Greece", "Hungary", "Ireland",
            "Italy", "Latvia", "Lithuania", "Luxembourg", "Malta", "Netherlands", "Poland", "Portugal", "Romania",
            "Slovakia", "Slovenia", "Spain", "Sweden");

    public BranchOfficeDTO(String nameBranch, String countryBranch) {
        this.nameBranch = nameBranch;
        this.countryBranch = countryBranch;
    }

    public void setCountryBranch(String countryBranch) {
        this.countryBranch = countryBranch;

        this.typeBranch = COUNTRIES_UE.contains(countryBranch) ? "UE" : "NOT UE";
    }

}

