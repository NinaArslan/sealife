package south.islands.nc.sealife.Services;

import org.springframework.stereotype.Service;
import south.islands.nc.sealife.Repositories.AnimalRepository;
import south.islands.nc.sealife.models.Animal;

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
