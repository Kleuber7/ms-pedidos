package MS_ORDER.MS_ORDER.mapper;

import MS_ORDER.MS_ORDER.domain.OrderDto;
import MS_ORDER.MS_ORDER.domain.PaymentDto;
import MS_ORDER.MS_ORDER.entity.OrderEntity;
import MS_ORDER.MS_ORDER.entity.PaymentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

    @Mapping(source = "order.orderCode", target = "orderCode")
    PaymentDto toDto(PaymentEntity paymentEntity);

    @Mapping(source = "orderCode", target = "order.orderCode")
    PaymentEntity toEntity(PaymentDto paymentDto);
}
