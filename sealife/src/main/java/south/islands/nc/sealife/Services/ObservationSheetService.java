package south.islands.nc.sealife.Services;


import org.springframework.stereotype.Service;
import south.islands.nc.sealife.mapper.ObservationAnimalMapper;
import south.islands.nc.sealife.mapper.ObservationSheetMapper;
import south.islands.nc.sealife.models.Animal;

import south.islands.nc.sealife.models.ObservationAnimal;
import south.islands.nc.sealife.models.ObservationSheet;
import south.islands.nc.sealife.Repositories.ObservationSheetRespository;
import south.islands.nc.sealife.rest.model.ObservationSheetDto;

import java.util.List;
import java.util.stream.Collectors;

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
        observationAnimalService.createObservationAnimal(
                observationAnimalMapper.toObservationAnimal(animal, observationSheet, observationSheetDto.getApneaTime(), observationSheetDto.getIsBank(),observationSheetDto.getSize()));
        observationSheetDto.setId(observationSheet.getId());
        return observationSheetDto;

    }


    public List<ObservationSheetDto> findByCriteria(Animal animal) {
        List<ObservationAnimal> observationAnimals;
        if(animal != null){
            observationAnimals =  observationAnimalService.findAllByCriteria(animal.getId());
        }
        else{
            observationAnimals = observationAnimalService.findAll();
        }
        return observationAnimals.stream().map(observationSheetMapper::toObservationSheetAndAnimalDto).collect(Collectors.toList());
    }

}
