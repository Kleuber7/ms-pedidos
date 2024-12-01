package MS_ORDER.MS_ORDER.repository;

import MS_ORDER.MS_ORDER.entity.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItemEntity, Long> {


}
