package cat.itacademy.barcelonactiva.santasusana.anna.s05.t01.n01.model.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Table(name = "branch_office")
@Entity
public class BranchOffice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pk_BranchID;
    @Column(name = "name")
    private String nameBranch;
    @Column(name = "country")
    private String countryBranch;

    public BranchOffice(String nameBranch, String countryBranch) {
        this.nameBranch = nameBranch;
        this.countryBranch = countryBranch;
    }

}
