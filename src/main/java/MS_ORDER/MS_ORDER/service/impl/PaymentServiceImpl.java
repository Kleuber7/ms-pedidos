package MS_ORDER.MS_ORDER.service.impl;

import MS_ORDER.MS_ORDER.domain.OrderStatus;
import MS_ORDER.MS_ORDER.domain.PaymentDto;
import MS_ORDER.MS_ORDER.domain.PaymentStatus;
import MS_ORDER.MS_ORDER.entity.OrderEntity;
import MS_ORDER.MS_ORDER.entity.PaymentEntity;
import MS_ORDER.MS_ORDER.exception.OrderNotFoundException;
import MS_ORDER.MS_ORDER.exception.PaymentNotFoundException;
import MS_ORDER.MS_ORDER.mapper.PaymentMapper;
import MS_ORDER.MS_ORDER.repository.OrderRepository;
import MS_ORDER.MS_ORDER.repository.PaymentRepository;
import MS_ORDER.MS_ORDER.service.PaymentService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;
    private final PaymentMapper paymentMapper;

    public PaymentServiceImpl(PaymentRepository paymentRepository, OrderRepository orderRepository, PaymentMapper paymentMapper) {
        this.paymentRepository = paymentRepository;
        this.orderRepository = orderRepository;
        this.paymentMapper = paymentMapper;
    }

    @Override
    public PaymentDto createPayment(PaymentDto paymentDto) {

        if (paymentDto.orderCode() == null) {
            throw new IllegalArgumentException("Order code cannot be null");
        }

        OrderEntity order = orderRepository.findById(paymentDto.orderCode())
                .orElseThrow(OrderNotFoundException::new);

        PaymentEntity paymentEntity = paymentMapper.toEntity(paymentDto);
        paymentEntity.setOrder(order);
        paymentEntity.setPaymentDate(LocalDateTime.now());

        PaymentEntity savedPayment = paymentRepository.save(paymentEntity);

        if (paymentDto.paymentStatus() != null && paymentDto.paymentStatus() == PaymentStatus.COMPLETED) {
            order.setOrderStatus(OrderStatus.COMPLETED);
            orderRepository.save(order);
        }

        return paymentMapper.toDto(savedPayment);
    }

    @Override
    public PaymentDto getById(Long id) {
        PaymentEntity paymentEntity = paymentRepository.findById(id)
                .orElseThrow(PaymentNotFoundException::new);

        return paymentMapper.toDto(paymentEntity);
    }

    @Override
    public List<PaymentDto> getAllPayments() {
        return paymentRepository.findAll()
                .stream()
                .map(paymentMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public PaymentDto updatePayment(Long id, PaymentDto paymentDto) {
        PaymentEntity existingPayment = paymentRepository.findById(id)
                .orElseThrow(PaymentNotFoundException::new);

        if (paymentDto.paymentMethod() != null) {
            existingPayment.setPaymentMethod(paymentDto.paymentMethod());
        }
        if (paymentDto.paymentStatus() != null) {
            existingPayment.setPaymentStatus(paymentDto.paymentStatus());
        }
        if (paymentDto.paymentDate() != null) {
            existingPayment.setPaymentDate(paymentDto.paymentDate());
        }

        PaymentEntity updatedPayment = paymentRepository.save(existingPayment);

        return paymentMapper.toDto(updatedPayment);
    }

    @Override
    public void deletePayment(Long id) {
        PaymentEntity paymentEntity = paymentRepository.findById(id)
                .orElseThrow(PaymentNotFoundException::new);

        paymentRepository.delete(paymentEntity);
    }
}
