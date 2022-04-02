package south.islands.nc.sealife.Service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import south.islands.nc.sealife.model.ObservationAnimal;
import south.islands.nc.sealife.model.ObservationAnimalRepository;
import south.islands.nc.sealife.model.ObservationSheet;
import south.islands.nc.sealife.rest.model.ObservationSheetDto;

import java.util.List;

@Service
public class ObservationAnimalService {

    private final ObservationAnimalRepository animalRepository;

    public ObservationAnimalService(ObservationAnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public ObservationAnimal createObservationAnimal(ObservationAnimal observationAnimal) {
        return animalRepository.save(observationAnimal);
    }

    public List<ObservationAnimal> findAllByCriteria(Long animalId) {
        return animalRepository.findAllByCriteria(animalId);
    }

    public List<ObservationAnimal> findAll() {
        return animalRepository.findAll();
    }
}
