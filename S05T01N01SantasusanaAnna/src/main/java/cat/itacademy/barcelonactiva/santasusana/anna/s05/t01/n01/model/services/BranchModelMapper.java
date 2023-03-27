package cat.itacademy.barcelonactiva.santasusana.anna.s05.t01.n01.model.services;

import cat.itacademy.barcelonactiva.santasusana.anna.s05.t01.n01.model.domain.BranchOffice;
import cat.itacademy.barcelonactiva.santasusana.anna.s05.t01.n01.model.dto.BranchOfficeDTO;
import org.modelmapper.ModelMapper;
import java.util.List;
import java.util.stream.Collectors;

public class BranchModelMapper {

    private final ModelMapper mapper = new ModelMapper();

    private static BranchModelMapper instance;

    private BranchModelMapper() {}

    public static BranchModelMapper singleInstance() {
        if (instance == null) {
            instance = new BranchModelMapper();
        }
        return instance;
    }

    public BranchOfficeDTO toBranchDTO(BranchOffice branchOffice) {
        return mapper.map(branchOffice, BranchOfficeDTO.class);
    }

    public BranchOffice toBranch(BranchOfficeDTO branchOfficeDTO) {
        return mapper.map(branchOfficeDTO, BranchOffice.class);
    }

    public List<BranchOfficeDTO> toBranchDTOList(List<BranchOffice> branchList) {
        return branchList.stream().map(this::toBranchDTO).collect(Collectors.toList());
    }

}
