package south.islands.nc.sealife.mapper;

import org.mapstruct.Mapper;
import south.islands.nc.sealife.model.Specie;
import south.islands.nc.sealife.rest.model.SpecieDto;

@Mapper
public abstract class SpecieMapper {

    public abstract SpecieDto toSpecieDto(Specie specie);
}
