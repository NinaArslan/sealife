package south.islands.nc.sealife.Service;


import org.springframework.stereotype.Service;
import south.islands.nc.sealife.mapper.ObservationAnimalMapper;
import south.islands.nc.sealife.mapper.ObservationSheetMapper;
import south.islands.nc.sealife.model.Animal;
import south.islands.nc.sealife.model.ObservationAnimal;
import south.islands.nc.sealife.model.ObservationSheet;
import south.islands.nc.sealife.model.ObservationSheetRespository;
import south.islands.nc.sealife.rest.model.ObservationSheetDto;

@Service
public class ObservationSheetService {

    private final ObservationSheetRespository sheetRespository;

    private final ObservationAnimalService observationAnimalService;

    private final ObservationSheetMapper observationSheetMapper;
    private final ObservationAnimalMapper observationAnimalMapper;


    public ObservationSheetService(ObservationSheetRespository sheetRespository, ObservationAnimalService observationAnimalService, ObservationSheetMapper observationSheetMapper, ObservationAnimalMapper observationAnimalMapper) {
        this.sheetRespository = sheetRespository;
        this.observationAnimalService = observationAnimalService;
        this.observationSheetMapper = observationSheetMapper;
        this.observationAnimalMapper = observationAnimalMapper;
    }


    public ObservationSheetDto createObservationSheet(ObservationSheetDto observationSheetDto, Animal animal) {
        ObservationSheet observationSheet = sheetRespository.save(
                observationSheetMapper.toObservationSheet(observationSheetDto));
        ObservationAnimal observationAnimal = observationAnimalService.createObservationAnimal(
                observationAnimalMapper.toObservationAnimal(animal, observationSheet, observationSheetDto.getApneaTime(), observationSheetDto.getIsBank(),observationSheetDto.getSize()));
        observationSheetDto.setId(observationSheet.getId());
        return observationSheetDto;

    }
}
