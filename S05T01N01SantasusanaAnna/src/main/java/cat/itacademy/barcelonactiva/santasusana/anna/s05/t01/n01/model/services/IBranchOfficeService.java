package cat.itacademy.barcelonactiva.santasusana.anna.s05.t01.n01.model.services;

import cat.itacademy.barcelonactiva.santasusana.anna.s05.t01.n01.model.dto.BranchOfficeDTO;
import java.util.List;

public interface IBranchOfficeService {

    void saveBranchOffice(BranchOfficeDTO branchOfficeDTO);

    boolean existsBranchOfficeById(int branchID);

    BranchOfficeDTO getBranchOfficeDTOById(int branchID);

    void deleteBranchOffice(int branchID);

    List<BranchOfficeDTO> listBranchOffices();
}
