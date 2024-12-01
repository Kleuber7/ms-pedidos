package MS_ORDER.MS_ORDER.mapper;

import MS_ORDER.MS_ORDER.domain.OrderDto;
import MS_ORDER.MS_ORDER.domain.OrderItemDto;
import MS_ORDER.MS_ORDER.entity.OrderEntity;
import MS_ORDER.MS_ORDER.entity.OrderItemEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {
    OrderItemEntity toEntity(OrderItemDto orderItemDto);

    OrderItemDto toDto(OrderItemEntity orderItemEntity);
}
