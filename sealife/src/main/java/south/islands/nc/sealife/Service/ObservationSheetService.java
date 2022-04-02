package south.islands.nc.sealife.Service;


import org.springframework.stereotype.Service;
import south.islands.nc.sealife.model.ObservationSheet;
import south.islands.nc.sealife.model.ObservationSheetRespository;

@Service
public class ObservationSheetService {

    private final ObservationSheetRespository sheetRespository;

    public ObservationSheetService(ObservationSheetRespository sheetRespository) {
        this.sheetRespository = sheetRespository;
    }

    public ObservationSheet createObservationSheet(ObservationSheet observationSheet) {
        return sheetRespository.save(observationSheet);


    }
}
