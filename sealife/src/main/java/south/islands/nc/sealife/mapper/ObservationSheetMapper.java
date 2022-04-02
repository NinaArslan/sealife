package south.islands.nc.sealife.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import south.islands.nc.sealife.model.Animal;
import south.islands.nc.sealife.model.ObservationAnimal;
import south.islands.nc.sealife.model.ObservationSheet;
import south.islands.nc.sealife.rest.model.ObservationSheetDto;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@Mapper(uses = {Animal.class, ObservationAnimal.class})
public abstract class ObservationSheetMapper {

    @Mapping(target = "observationDate", source = "observationDate", qualifiedByName = "offsetDateTimeToLocalDateTime")
    public abstract ObservationSheet toObservationSheet(ObservationSheetDto dto);


    @Named("offsetDateTimeToLocalDateTime")
    public LocalDateTime offsetDateTimeToLocalDateTime(OffsetDateTime date) {
        if ( date == null ) {
            return null;
        }
        return date.toLocalDateTime();
    }

}
