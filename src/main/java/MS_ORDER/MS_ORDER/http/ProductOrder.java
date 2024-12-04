package MS_ORDER.MS_ORDER.http;

import MS_ORDER.MS_ORDER.http.dto.ProductDetailDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("ms-product")
public interface ProductOrder {

    @RequestMapping(method = RequestMethod.GET, value = "/products/{id}")
    ProductDetailDto productSearch (@PathVariable("id")  Long id);


}
