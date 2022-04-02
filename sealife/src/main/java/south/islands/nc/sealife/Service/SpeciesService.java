package south.islands.nc.sealife.Service;

import org.springframework.stereotype.Service;
import south.islands.nc.sealife.model.Specie;
import south.islands.nc.sealife.model.SpecieRepository;

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
