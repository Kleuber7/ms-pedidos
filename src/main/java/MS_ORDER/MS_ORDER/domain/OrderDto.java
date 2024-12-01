package MS_ORDER.MS_ORDER.domain;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Builder
public record OrderDto(
        Long orderCode,
        Long userCode,
        BigDecimal totalPrice,
        OrderStatus orderStatus,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        List<OrderItemDto> orderItems
) { }
