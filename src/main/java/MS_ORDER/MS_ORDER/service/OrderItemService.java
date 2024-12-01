package MS_ORDER.MS_ORDER.service;

import MS_ORDER.MS_ORDER.domain.OrderItemDto;

import java.util.List;

public interface OrderItemService {

    OrderItemDto createOrderItem(OrderItemDto orderItemDto);

    OrderItemDto getById(Long id);

    List<OrderItemDto> getAllOrderItems();

    OrderItemDto updateOrderItem(Long id, OrderItemDto orderItemDto);

    void deleteOrderItem(Long id);
}
