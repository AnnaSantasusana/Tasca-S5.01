package cat.itacademy.barcelonactiva.santasusana.anna.s05.t01.n02.model.repository;

import cat.itacademy.barcelonactiva.santasusana.anna.s05.t01.n02.model.domain.FlowerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFlowerRepo extends JpaRepository<FlowerEntity, Integer> {
}
