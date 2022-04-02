package south.islands.nc.sealife.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import south.islands.nc.sealife.models.ObservationSheet;


@Repository
public interface ObservationSheetRespository  extends JpaRepository<ObservationSheet, Long>{

}
