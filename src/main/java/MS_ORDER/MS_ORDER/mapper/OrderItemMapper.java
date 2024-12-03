package MS_ORDER.MS_ORDER.mapper;

import MS_ORDER.MS_ORDER.dto.OrderItemDto;
import MS_ORDER.MS_ORDER.entity.OrderEntity;
import MS_ORDER.MS_ORDER.entity.OrderItemEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {

    OrderItemDto toDto(OrderItemEntity orderItemEntity);

    OrderItemEntity toEntity(OrderItemDto orderItemDto);


    default Long mapOrderToOrderCode(OrderEntity order) {
        return order != null ? order.getOrderCode() : null;
    }

    default OrderEntity mapOrderCodeToOrder(Long orderCode) {
        if (orderCode == null) {
            return null;
        }
        OrderEntity order = new OrderEntity();
        order.setOrderCode(orderCode);
        return order;
    }
}

