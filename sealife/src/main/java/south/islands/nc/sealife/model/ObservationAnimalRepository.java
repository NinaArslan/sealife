package south.islands.nc.sealife.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObservationAnimalRepository extends JpaRepository<ObservationAnimal, Long> {

}
