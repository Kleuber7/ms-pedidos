package MS_ORDER.MS_ORDER.service;

import MS_ORDER.MS_ORDER.domain.OrderDto;
import MS_ORDER.MS_ORDER.entity.OrderEntity;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    public OrderDto createOrder(OrderDto orderDto);

    public Optional<OrderDto> getById(Long id);

    public List<OrderDto> getAllOrders();

    public OrderDto  updateOrder(Long id, OrderDto orderDto);

    public void deleteOrder(Long id);

}
