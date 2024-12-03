package MS_ORDER.MS_ORDER.http;

import MS_ORDER.MS_ORDER.http.dto.ClientEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("ms-cliente")
public interface ClientOrder {

    @RequestMapping(method = RequestMethod.GET, value = "/clients/{id}")
    ClientEntity customerSearch (@PathVariable("id")  Long id);
}
