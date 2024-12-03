package MS_ORDER.MS_ORDER.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "order_item")
public class OrderItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderItemCode;
    private Long productCode;
    private BigDecimal price;
    private Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "order_code", nullable = false)
    private OrderEntity order;

    public OrderItemEntity() {}

    public OrderItemEntity(Long orderItemCode, OrderEntity order, Long productCode, BigDecimal price, Integer quantity) {
        this.orderItemCode = orderItemCode;
        this.order = order;
        this.productCode = productCode;
        this.price = price;
        this.quantity = quantity;
    }

    public Long getOrderItemCode() {
        return orderItemCode;
    }

    public void setOrderItemCode(Long orderItemCode) {
        this.orderItemCode = orderItemCode;
    }

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }

    public Long getProductCode() {
        return productCode;
    }

    public void setProductCode(Long productCode) {
        this.productCode = productCode;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
