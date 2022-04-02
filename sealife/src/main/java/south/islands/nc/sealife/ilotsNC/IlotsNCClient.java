package south.islands.nc.sealife.ilotsNC;

import models.IlotDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ilotsNC", url = "${client.ilotsNC.url}")
public interface IlotsNCClient {

    @GetMapping("/pandore/ilot/IlotDto/{id}")
    IlotDto findIslandById(@PathVariable("id") String id);

}
