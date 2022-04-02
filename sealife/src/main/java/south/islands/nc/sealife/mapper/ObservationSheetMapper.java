package south.islands.nc.sealife.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import south.islands.nc.sealife.models.Animal;
import south.islands.nc.sealife.models.ObservationAnimal;
import south.islands.nc.sealife.models.ObservationSheet;
import south.islands.nc.sealife.models.QualityObservation;
import south.islands.nc.sealife.rest.model.ObservationSheetDto;


import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;

@Mapper(uses = {Animal.class, ObservationAnimal.class, QualityObservation.class})
public abstract class ObservationSheetMapper {

    @Mapping(target = "observationDate", source = "observationDate", qualifiedByName = "offsetDateTimeToLocalDateTime")
    @Mapping(target = "qualityObservation", source = "observationQuality", qualifiedByName = "map")
    public abstract ObservationSheet toObservationSheet(ObservationSheetDto dto);

    @Mapping(target = "animalName", source = "animal.name")
    @Mapping(target = "specie", source = "animal.specie.specieName")
    @Mapping(target = "islandId", source = "observationSheet.islandId")

    @Mapping(target = "distanceFromIsland", source = "observationSheet.distanceFromIsland")
    @Mapping(target = "observationDate", source = "observationSheet.observationDate", qualifiedByName = "localDateTimeToOffsetDateTime")
    @Mapping(target = "observationQuality", source = "observationSheet.qualityObservation", qualifiedByName = "mapEnumDto")
    public abstract ObservationSheetDto toObservationSheetAndAnimalDto(ObservationAnimal observationAnimal);


    @Mapping(target = "observationDate", source = "observationDate", qualifiedByName = "localDateTimeToOffsetDateTime")
    @Mapping(target = "observationQuality", source = "qualityObservation", qualifiedByName = "mapEnumDto")
    public abstract ObservationSheetDto toObservationSheetDto(ObservationSheet observationSheet);

    @Named("offsetDateTimeToLocalDateTime")
    public LocalDateTime offsetDateTimeToLocalDateTime(OffsetDateTime date) {
        if ( date == null ) {
            return null;
        }
        return date.toLocalDateTime();
    }

    @Named("localDateTimeToOffsetDateTime")
    public OffsetDateTime localDateTimeToOffsetDateTime(LocalDateTime date){
        if( date == null ) {
            return null;
        }
        ZoneId zoneId = ZoneId.systemDefault();
        return date.atZone(zoneId).toOffsetDateTime();
    }

    @Named("map")
    public QualityObservation map(ObservationSheetDto.ObservationQualityEnum value){
        return QualityObservation.valueOf(String.valueOf(value));
    }


    @Named("mapEnumDto")
    public ObservationSheetDto.ObservationQualityEnum mapEnumDto(QualityObservation value){
        return ObservationSheetDto.ObservationQualityEnum.valueOf(String.valueOf(value));
    }




}
