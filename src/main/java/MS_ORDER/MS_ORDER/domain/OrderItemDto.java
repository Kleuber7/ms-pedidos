package MS_ORDER.MS_ORDER.domain;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;

import java.math.BigDecimal;

public record OrderItemDto(
        Long orderItemCode,
        Long orderCode,
        Long productCode,
        BigDecimal price,
        Integer quantity
) {}

