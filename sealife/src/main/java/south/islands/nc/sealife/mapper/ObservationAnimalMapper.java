package south.islands.nc.sealife.mapper;

import org.mapstruct.Mapper;

import south.islands.nc.sealife.model.Animal;
import south.islands.nc.sealife.model.ObservationAnimal;
import south.islands.nc.sealife.model.ObservationSheet;

@Mapper(uses = {Animal.class, ObservationSheet.class})
public abstract class ObservationAnimalMapper {


    public ObservationAnimal toObservationAnimal(Animal animal, ObservationSheet observationSheet, Integer apneaTime, Boolean isBank, Integer size){
        return ObservationAnimal.builder()
                .animal(animal)
                .observationSheet(observationSheet)
                .apneaTime(apneaTime)
                .isBank(isBank)
                .size(size)
                .build();
    }
}
