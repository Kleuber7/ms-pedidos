package MS_ORDER.MS_ORDER.mapper;

import MS_ORDER.MS_ORDER.dto.PaymentDto;
import MS_ORDER.MS_ORDER.entity.PaymentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

    @Mapping(source = "paymentCode", target = "paymentCode")
    PaymentDto toDto(PaymentEntity paymentEntity);

    @Mapping(source = "paymentCode", target = "paymentCode")
    PaymentEntity toEntity(PaymentDto paymentDto);
}
