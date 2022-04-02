package south.islands.nc.sealife.Service;

import org.springframework.stereotype.Service;
import south.islands.nc.sealife.model.Animal;
import south.islands.nc.sealife.model.AnimalRepository;

import java.util.Optional;

@Service
public class AnimalService {

    private final AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }


    public Optional<Animal> findByName(String animalName) {
        return animalRepository.findByName(animalName);

    }
}
