package MS_ORDER.MS_ORDER.domain;

import java.math.BigDecimal;

public record OrderItemDto(
        Long orderItemCode,
        Long orderCode,
        Long productCode,
        BigDecimal price,
        Integer quantity
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long orderItemCode;
        private Long orderCode;
        private Long productCode;
        private BigDecimal price;
        private Integer quantity;

        public Builder orderItemCode(Long orderItemCode) {
            this.orderItemCode = orderItemCode;
            return this;
        }

        public Builder orderCode(Long orderCode) {
            this.orderCode = orderCode;
            return this;
        }

        public Builder productCode(Long productCode) {
            this.productCode = productCode;
            return this;
        }

        public Builder price(BigDecimal price) {
            this.price = price;
            return this;
        }

        public Builder quantity(Integer quantity) {
            this.quantity = quantity;
            return this;
        }

        public OrderItemDto build() {
            return new OrderItemDto(orderItemCode, orderCode, productCode, price, quantity);
        }
    }
}