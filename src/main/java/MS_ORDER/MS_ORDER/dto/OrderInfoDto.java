package MS_ORDER.MS_ORDER.dto;

import java.util.List;

public record OrderInfoDto(

        Long userCode,

        List<OrderItemDto> orderItems
) {
}
