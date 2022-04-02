package south.islands.nc.sealife.Controller;

import org.mapstruct.Mapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import south.islands.nc.sealife.Service.AnimalService;
import south.islands.nc.sealife.Service.ObservationSheetService;
import south.islands.nc.sealife.mapper.ObservationSheetMapper;
import south.islands.nc.sealife.rest.api.ObservationSheetApi;
import south.islands.nc.sealife.rest.model.ObservationSheetDto;


@CrossOrigin
@RestController
public class ObservationSheetController  implements ObservationSheetApi {

    private final ObservationSheetService observationSheetService;
    private final ObservationSheetMapper mapper;
    private final AnimalService animalService;

    public ObservationSheetController(ObservationSheetService observationSheetService, ObservationSheetMapper mapper, AnimalService animalService) {
        this.observationSheetService = observationSheetService;
        this.mapper = mapper;
        this.animalService = animalService;
    }


    @Override
    public ResponseEntity<ObservationSheetDto> newObservationSheet(ObservationSheetDto observationSheetDto) {

        observationSheetService.createObservationSheet(mapper.toObservationSheet(observationSheetDto));
        return ResponseEntity.ok(observationSheetDto);
    }
}
