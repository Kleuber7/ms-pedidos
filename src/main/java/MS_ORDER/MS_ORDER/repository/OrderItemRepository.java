package MS_ORDER.MS_ORDER.repository;

import MS_ORDER.MS_ORDER.entity.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItemEntity, Long> {

    @Query("SELECT o FROM OrderItemEntity o where o.orderItemCode = :orderItemId")
    List<OrderItemEntity> findAllByOrderItemCode(@Param("orderItemId") Long orderItemId);
}
