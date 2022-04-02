package south.islands.nc.sealife.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import south.islands.nc.sealife.Service.AnimalService;
import south.islands.nc.sealife.Service.ObservationSheetService;
import south.islands.nc.sealife.model.Animal;
import south.islands.nc.sealife.rest.api.ObservationSheetApi;
import south.islands.nc.sealife.rest.model.ObservationSheetDto;


@CrossOrigin
@RestController
public class ObservationSheetController implements ObservationSheetApi {

    private final ObservationSheetService observationSheetService;
    private final AnimalService animalService;

    public ObservationSheetController(ObservationSheetService observationSheetService, AnimalService animalService) {
        this.observationSheetService = observationSheetService;
        this.animalService = animalService;
    }


    @Override
    public ResponseEntity<ObservationSheetDto> newObservationSheet(ObservationSheetDto observationSheetDto) {
        Animal animal = animalService.findByName(observationSheetDto.getAnimalName())
                .orElseThrow(() -> new AnimalNotFoundException(observationSheetDto.getAnimalName()));

        return ResponseEntity.ok(observationSheetService.createObservationSheet(observationSheetDto, animal));
    }
}
