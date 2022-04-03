package south.islands.nc.sealife.ilotsNC;

import feign.Headers;
import models.InlineResponse2003;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;


@FeignClient(name = "ilotsNC", url = "${client.ilotsNC.url}")
@Headers("Content-Type: multipart/form-data")
public interface IlotsNCClient {

    @GetMapping(value = "/pandore/ilot/IlotDto/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    Map<Object, Object> findIslandById(@PathVariable("id") String id);

    @GetMapping( value = "/pandore/ilot/IlotDto/", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    InlineResponse2003 findIslands();

}
