package south.islands.nc.sealife.Services;

import org.springframework.stereotype.Service;
import south.islands.nc.sealife.models.ObservationAnimal;
import south.islands.nc.sealife.Repositories.ObservationAnimalRepository;

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
