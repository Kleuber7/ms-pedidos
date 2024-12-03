package MS_ORDER.MS_ORDER.entity;

import MS_ORDER.MS_ORDER.domain.OrderItemDto;
import MS_ORDER.MS_ORDER.domain.OrderStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderCode;

    private Long userCode;
    private BigDecimal totalPrice;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public OrderEntity() {}

    public OrderEntity(Long orderCode, Long userCode, BigDecimal totalPrice) {
        this.orderCode = orderCode;
        this.userCode = userCode;
        this.totalPrice = totalPrice;
    }




}
