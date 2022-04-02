package south.islands.nc.sealife.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import south.islands.nc.sealife.Service.SpeciesService;
import south.islands.nc.sealife.mapper.SpecieMapper;
import south.islands.nc.sealife.rest.api.SpeciesApi;
import south.islands.nc.sealife.rest.model.SpecieDto;

import java.util.List;
import java.util.stream.Collectors;


@CrossOrigin
@RestController
public class SpeciesController implements SpeciesApi {

    private final SpeciesService speciesService;
    private final SpecieMapper specieMapper;

    public SpeciesController(SpeciesService speciesService, SpecieMapper specieMapper) {
        this.speciesService = speciesService;
        this.specieMapper = specieMapper;
    }

    /**
     * GET /species
     *
     * @return OK (status code 200)
     */
    @Override
    public ResponseEntity<List<SpecieDto>> findSpecies() {
        return ResponseEntity.ok(speciesService.findAllSpecies().stream().map(specieMapper::toSpecieDto).collect(Collectors.toList()));
    }


}
