package MS_ORDER.MS_ORDER.service.impl;

import MS_ORDER.MS_ORDER.domain.OrderDto;
import MS_ORDER.MS_ORDER.entity.OrderEntity;
import MS_ORDER.MS_ORDER.exception.OrderNotFoundException;
import MS_ORDER.MS_ORDER.mapper.OrderMapper;
import MS_ORDER.MS_ORDER.repository.OrderRepository;
import MS_ORDER.MS_ORDER.service.OrderService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public OrderServiceImpl(OrderRepository orderRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        OrderEntity newOrder = orderMapper.toEntity(orderDto);

        newOrder.setCreatedAt(orderDto.createdAt() == null ? LocalDateTime.now() : orderDto.createdAt());

        OrderEntity savedOrder = orderRepository.save(newOrder);
        return orderMapper.toDto(savedOrder);
    }

    @Override
    public Optional<OrderDto> getById(Long id) {
        OrderEntity order = orderRepository.findById(id)
                .orElseThrow(OrderNotFoundException::new);

        return Optional.of(orderMapper.toDto(order));
    }

    @Override
    public List<OrderDto> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(orderMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public OrderDto updateOrder(Long id, OrderDto orderDto) {
        OrderEntity existingOrder = orderRepository.findById(id)
                .orElseThrow(OrderNotFoundException::new);

        if (orderDto.userCode() != null) {
            existingOrder.setUserCode(orderDto.userCode());
        }
        if (orderDto.totalPrice() != null) {
            existingOrder.setTotalPrice(orderDto.totalPrice());
        }
        if (orderDto.orderStatus() != null) {
            existingOrder.setOrderStatus(orderDto.orderStatus());
        }
        existingOrder.setUpdatedAt(orderDto.updatedAt() != null ? orderDto.updatedAt() : LocalDateTime.now());

        OrderEntity updatedOrder = orderRepository.save(existingOrder);
        return orderMapper.toDto(updatedOrder);
    }

    @Override
    public void deleteOrder(Long id) {
        OrderEntity order = orderRepository.findById(id)
                .orElseThrow(OrderNotFoundException::new);
        orderRepository.delete(order);
    }
}
