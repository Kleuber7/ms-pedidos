package MS_ORDER.MS_ORDER.mapper;

import MS_ORDER.MS_ORDER.domain.OrderItemDto;
import MS_ORDER.MS_ORDER.entity.OrderItemEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {

    @Mapping(source = "order.orderCode", target = "orderCode")
    OrderItemDto toDto(OrderItemEntity orderItemEntity);

    @Mapping(source = "orderCode", target = "order.orderCode")
    OrderItemEntity toEntity(OrderItemDto orderItemDto);
}

