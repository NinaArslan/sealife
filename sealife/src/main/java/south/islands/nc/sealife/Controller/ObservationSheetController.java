package south.islands.nc.sealife.Controller;

import feign.FeignException;
import models.IlotDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import south.islands.nc.sealife.Services.AnimalService;
import south.islands.nc.sealife.Services.ObservationSheetService;
import south.islands.nc.sealife.ilotsNC.IlotsNCClient;
import south.islands.nc.sealife.models.Animal;
import south.islands.nc.sealife.rest.api.ObservationSheetApi;
import south.islands.nc.sealife.rest.model.ObservationSheetDto;

import java.util.List;


@CrossOrigin
@RestController
public class ObservationSheetController implements ObservationSheetApi {

    private final ObservationSheetService observationSheetService;
    private final AnimalService animalService;
    private final IlotsNCClient ilotsNCClient;

    public ObservationSheetController(ObservationSheetService observationSheetService, AnimalService animalService, IlotsNCClient ilotsNCClient) {
        this.observationSheetService = observationSheetService;
        this.animalService = animalService;
        this.ilotsNCClient = ilotsNCClient;
    }


    @Override
    public ResponseEntity<ObservationSheetDto> newObservationSheet(ObservationSheetDto observationSheetDto) {
        Animal animal = animalService.findByName(observationSheetDto.getAnimalName())
                .orElseThrow(() -> new AnimalNotFoundException(observationSheetDto.getAnimalName()));
        IlotDto ilotDto = ilotsNCClient.findIslandById(observationSheetDto.getIslandId());
        if(ilotDto == null){
            throw new IlotNotFoundException(observationSheetDto.getIslandId());
        }
        return ResponseEntity.ok(observationSheetService.createObservationSheet(observationSheetDto, animal));
    }

    /**
     * GET /observation-sheet/searchCriteria : Find Observations by criteria
     *
     * @param animalName (optional)
     * @return OK (status code 200)
     * or BAD REQUEST (status code 400)
     * or NOT FOUND (status code 404)
     */
    @Override
    public ResponseEntity<List<ObservationSheetDto>> searchByCriteria(String animalName) {
            Animal animal = animalService.findByName(animalName)
                    .orElse(null);
        return ResponseEntity.ok(observationSheetService.findByCriteria(animal));
    }
}
