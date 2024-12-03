package MS_ORDER.MS_ORDER.http;

import MS_ORDER.MS_ORDER.http.dto.ClientEntity;
import MS_ORDER.MS_ORDER.http.dto.ProductDetailDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("product")
public interface ProductOrder {

    @RequestMapping(method = RequestMethod.GET, value = "/product/{id}")
    ProductDetailDto customerSearch (@PathVariable("id")  Long id);


}
