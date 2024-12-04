package MS_ORDER.MS_ORDER.service.impl;

import MS_ORDER.MS_ORDER.dto.OrderDetailDto;
import MS_ORDER.MS_ORDER.dto.OrderDto;
import MS_ORDER.MS_ORDER.dto.OrderInfoDto;
import MS_ORDER.MS_ORDER.dto.OrderItemDto;
import MS_ORDER.MS_ORDER.entity.OrderEntity;
import MS_ORDER.MS_ORDER.entity.OrderItemEntity;
import MS_ORDER.MS_ORDER.exception.OrderNotFoundException;
import MS_ORDER.MS_ORDER.http.ClientOrder;
import MS_ORDER.MS_ORDER.mapper.OrderDetailMapper;
import MS_ORDER.MS_ORDER.mapper.OrderMapper;
import MS_ORDER.MS_ORDER.repository.OrderRepository;
import MS_ORDER.MS_ORDER.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final ClientOrder clientOrder;
    private final OrderDetailMapper orderDetailMapper;
    private final OrderItemServiceImpl orderItemServiceImpl;



    @Override
    public OrderDetailDto createOrder(OrderInfoDto orderDto) {
        OrderEntity newOrder = new OrderEntity();

        List<OrderItemEntity> listItem = orderItemServiceImpl.findAllOrderItemById(orderDto.orderCode());


        var cliente =  clientOrder.customerSearch(orderDto.userCode());

        newOrder.setUserCode(cliente.getId());
        newOrder.setTotalPrice(calculateTotalPrice(listItem));
        newOrder.setCreatedAt(LocalDateTime.now());

        listItem.forEach(item -> item.setOrder(newOrder));
        newOrder.setOrderItems(listItem);



        OrderEntity savedOrder = orderRepository.save(newOrder);
        return orderDetailMapper.toDto(savedOrder);
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

    private BigDecimal calculateTotalPrice(List<OrderItemEntity> orderItems) {
        return orderItems.stream()
                .map(OrderItemEntity::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }


}
