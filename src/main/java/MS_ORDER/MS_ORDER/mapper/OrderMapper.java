package MS_ORDER.MS_ORDER.mapper;

import MS_ORDER.MS_ORDER.dto.OrderDto;
import MS_ORDER.MS_ORDER.entity.OrderEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {OrderItemMapper.class})
public interface OrderMapper {

    OrderDto toDto(OrderEntity entity);

    OrderEntity toEntity(OrderDto dto);
}

