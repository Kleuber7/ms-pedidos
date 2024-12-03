package MS_ORDER.MS_ORDER.mapper;

import MS_ORDER.MS_ORDER.dto.OrderDetailDto;
import MS_ORDER.MS_ORDER.entity.OrderEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderDetailMapper {

    OrderDetailDto toDto(OrderEntity orderEntity);

    OrderEntity toEntity(OrderDetailDto orderDetailDto);
}
