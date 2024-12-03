package MS_ORDER.MS_ORDER.dto;

import java.math.BigDecimal;

public record OrderItemDto(
        Long order,
        Long orderItemCode,
        Long productCode,
        BigDecimal price,
        Integer quantity
) {}

