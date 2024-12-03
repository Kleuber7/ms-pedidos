package MS_ORDER.MS_ORDER.http.dto;

import java.time.LocalDateTime;

public record ProductDetailDto(
        Long productCode,

        String category,

        String name,

        String description,

        Double price,

        Integer stockQuantity,

        LocalDateTime createdAt,

        LocalDateTime updatedAt,

        Double discountAmount
) {
}
