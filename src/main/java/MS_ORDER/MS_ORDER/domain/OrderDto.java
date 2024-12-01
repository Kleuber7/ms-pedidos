package MS_ORDER.MS_ORDER.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record OrderDto(
        Long orderCode,
        Long userCode,
        BigDecimal totalPrice,
        OrderStatus orderStatus,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        List<OrderItemDto> orderItems
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long orderCode;
        private Long userCode;
        private BigDecimal totalPrice;
        private OrderStatus orderStatus;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
        private List<OrderItemDto> orderItems;

        public Builder orderCode(Long orderCode) {
            this.orderCode = orderCode;
            return this;
        }

        public Builder userCode(Long userCode) {
            this.userCode = userCode;
            return this;
        }

        public Builder totalPrice(BigDecimal totalPrice) {
            this.totalPrice = totalPrice;
            return this;
        }

        public Builder orderStatus(OrderStatus orderStatus) {
            this.orderStatus = orderStatus;
            return this;
        }

        public Builder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder updatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public Builder orderItems(List<OrderItemDto> orderItems) {
            this.orderItems = orderItems;
            return this;
        }

        public OrderDto build() {
            return new OrderDto(orderCode, userCode, totalPrice, orderStatus, createdAt, updatedAt, orderItems);
        }
    }
}
