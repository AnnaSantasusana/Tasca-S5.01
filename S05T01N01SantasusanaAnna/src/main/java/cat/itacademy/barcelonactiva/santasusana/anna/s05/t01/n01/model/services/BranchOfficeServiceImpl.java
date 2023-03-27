package cat.itacademy.barcelonactiva.santasusana.anna.s05.t01.n01.model.services;

import cat.itacademy.barcelonactiva.santasusana.anna.s05.t01.n01.model.domain.BranchOffice;
import cat.itacademy.barcelonactiva.santasusana.anna.s05.t01.n01.model.dto.BranchOfficeDTO;
import cat.itacademy.barcelonactiva.santasusana.anna.s05.t01.n01.model.repository.IBranchOfficeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BranchOfficeServiceImpl implements IBranchOfficeService{

    @Autowired
    private IBranchOfficeRepo branchRepo;

    @Override
    public void saveBranchOffice(BranchOfficeDTO branchOfficeDTO) {
        BranchOffice branch = BranchModelMapper.singleInstance().toBranch(branchOfficeDTO);
        branchRepo.save(branch);

    }
    @Override
    public boolean existsBranchOfficeById(int branchID) {
        return branchRepo.existsById(branchID);
    }

    @Override
    public BranchOfficeDTO getBranchOfficeDTOById(int branchID) {
        Optional<BranchOffice> optionalBranch = branchRepo.findById(branchID);
        BranchOffice branch;
        if(optionalBranch.isPresent()){
            branch = optionalBranch.get();
        }else {
            throw new RuntimeException("Branch office not found by id: " + branchID);
        }
        return BranchModelMapper.singleInstance().toBranchDTO(branch);
    }

    @Override
    public void deleteBranchOffice(int branchID) {

        BranchOfficeDTO branchDTO = getBranchOfficeDTOById(branchID);
        branchRepo.delete(BranchModelMapper.singleInstance().toBranch(branchDTO));
    }

    @Override
    public List<BranchOfficeDTO> listBranchOffices() {
        return BranchModelMapper.singleInstance().toBranchDTOList(branchRepo.findAll());
    }
}
