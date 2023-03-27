package cat.itacademy.barcelonactiva.santasusana.anna.s05.t01.n01.model.repository;

import cat.itacademy.barcelonactiva.santasusana.anna.s05.t01.n01.model.domain.BranchOffice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBranchOfficeRepo extends JpaRepository<BranchOffice, Integer> {
}
