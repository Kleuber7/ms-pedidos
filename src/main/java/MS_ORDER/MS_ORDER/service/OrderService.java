package MS_ORDER.MS_ORDER.service;

import MS_ORDER.MS_ORDER.dto.OrderDetailDto;
import MS_ORDER.MS_ORDER.dto.OrderDto;
import MS_ORDER.MS_ORDER.dto.OrderInfoDto;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    public OrderDetailDto createOrder(OrderInfoDto orderDto);

    public Optional<OrderDto> getById(Long id);

    public List<OrderDto> getAllOrders();

    public OrderDto  updateOrder(Long id, OrderDto orderDto);

    public void deleteOrder(Long id);

}
