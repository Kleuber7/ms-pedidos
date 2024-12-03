package MS_ORDER.MS_ORDER.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
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
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        List<OrderItemDto> orderItems
) { }
