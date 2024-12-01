package MS_ORDER.MS_ORDER.domain;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record OrderItemDto(
        @NotNull Long orderItemCode,
        @NotNull Long orderCode,
        @NotNull Long productCode,
        @Positive BigDecimal price,
        @Positive Integer quantity
) {}
