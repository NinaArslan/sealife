package south.islands.nc.sealife.Services;

import org.springframework.stereotype.Service;
import south.islands.nc.sealife.models.Specie;
import south.islands.nc.sealife.Repositories.SpecieRepository;

import java.util.List;


@Service
public class SpeciesService {

    private final SpecieRepository specieRepository;

    public SpeciesService(SpecieRepository specieRepository) {
        this.specieRepository = specieRepository;
    }

    public List<Specie> findAllSpecies() {
        return specieRepository.findAll();

    }
}
