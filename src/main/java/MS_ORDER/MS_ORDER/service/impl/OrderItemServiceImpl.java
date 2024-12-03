package MS_ORDER.MS_ORDER.service.impl;

import MS_ORDER.MS_ORDER.dto.OrderItemDto;
import MS_ORDER.MS_ORDER.entity.OrderEntity;
import MS_ORDER.MS_ORDER.entity.OrderItemEntity;
import MS_ORDER.MS_ORDER.exception.OrderItemNotFoundException;
import MS_ORDER.MS_ORDER.http.ProductOrder;
import MS_ORDER.MS_ORDER.mapper.OrderItemMapper;
import MS_ORDER.MS_ORDER.repository.OrderItemRepository;
import MS_ORDER.MS_ORDER.repository.OrderRepository;
import MS_ORDER.MS_ORDER.service.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {

    private final OrderItemRepository orderItemRepository;
    private final OrderRepository orderRepository;
    private final OrderItemMapper orderItemMapper;
    private final ProductOrder productOrder;


    @Override
    public OrderItemDto createOrderItem(OrderItemDto orderItemDto) {

        if (orderItemDto.order() == null) {
            throw new IllegalArgumentException("Order code cannot be null");
        }

        OrderEntity order = orderRepository.findById(orderItemDto.order())
                .orElseThrow(OrderItemNotFoundException::new);

        var product = productOrder.customerSearch(orderItemDto.productCode());


        OrderItemEntity orderItemEntity = orderItemMapper.toEntity(orderItemDto);
        orderItemEntity.setOrder(order);
        orderItemEntity.setProductCode(product.productCode());
        orderItemEntity.setQuantity(orderItemDto.quantity());
        orderItemEntity.setPrice(BigDecimal.valueOf(product.price()));

        return orderItemMapper.toDto(orderItemRepository.save(orderItemEntity));
    }

    @Override
    public OrderItemDto getById(Long id) {
        OrderItemEntity orderItem = orderItemRepository.findById(id)
                .orElseThrow(OrderItemNotFoundException::new);
        return orderItemMapper.toDto(orderItem);
    }

    @Override
    public List<OrderItemDto> getAllOrderItems() {
        return orderItemRepository.findAll().stream()
                .map(orderItemMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public OrderItemDto updateOrderItem(Long id, OrderItemDto orderItemDto) {
        OrderItemEntity existingOrderItem = orderItemRepository.findById(id)
                .orElseThrow(OrderItemNotFoundException::new);

        if (orderItemDto.productCode() != null) {
            existingOrderItem.setProductCode(orderItemDto.productCode());
        }
        if (orderItemDto.price() != null) {
            existingOrderItem.setPrice(orderItemDto.price());
        }
        if (orderItemDto.quantity() != null) {
            existingOrderItem.setQuantity(orderItemDto.quantity());
        }

        if (orderItemDto.order() != null) {
            OrderEntity order = orderRepository.findById(orderItemDto.order())
                    .orElseThrow(OrderItemNotFoundException::new);
            existingOrderItem.setOrder(order);
        }

        return orderItemMapper.toDto(orderItemRepository.save(existingOrderItem));
    }

    @Override
    public void deleteOrderItem(Long id) {
        OrderItemEntity orderItem = orderItemRepository.findById(id)
                .orElseThrow(OrderItemNotFoundException::new);
        orderItemRepository.delete(orderItem);
    }

    @Override
    public List<OrderItemEntity> findAllOrderItemById(Long orderItemId) {
        var orderItemList = orderItemRepository.findAllByOrderItemCode(orderItemId);

        return orderItemList;
    }
}
