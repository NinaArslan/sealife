package south.islands.nc.sealife.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import south.islands.nc.sealife.models.Animal;

import java.util.Optional;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {


    Optional<Animal> findByName(@Param("name") String animalName);
}
