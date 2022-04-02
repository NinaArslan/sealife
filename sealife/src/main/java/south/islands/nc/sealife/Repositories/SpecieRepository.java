package south.islands.nc.sealife.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import south.islands.nc.sealife.models.Specie;

public interface SpecieRepository extends JpaRepository<Specie, Long> {
}
