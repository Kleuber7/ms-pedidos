package MS_ORDER.MS_ORDER.service;

import MS_ORDER.MS_ORDER.dto.OrderItemDto;
import MS_ORDER.MS_ORDER.entity.OrderItemEntity;

import java.util.List;

public interface OrderItemService {

    OrderItemDto createOrderItem(OrderItemDto orderItemDto);

    OrderItemDto getById(Long id);

    List<OrderItemDto> getAllOrderItems();

    OrderItemDto updateOrderItem(Long id, OrderItemDto orderItemDto);

    void deleteOrderItem(Long id);

    List<OrderItemEntity> findAllOrderItemById(Long orderItemId);
}
