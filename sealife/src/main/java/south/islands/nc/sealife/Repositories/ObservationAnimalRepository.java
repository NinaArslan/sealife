package south.islands.nc.sealife.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import south.islands.nc.sealife.models.ObservationAnimal;

import java.util.List;

@Repository
public interface ObservationAnimalRepository extends JpaRepository<ObservationAnimal, Long> {

    @Query("select oa, os from ObservationAnimal oa join ObservationSheet os on oa.observationSheet.id = os.id where oa.animal.id = :animalId")
    List<ObservationAnimal> findAllByCriteria(@Param("animalId") Long animalId);

}
