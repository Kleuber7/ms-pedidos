package MS_ORDER.MS_ORDER.service;

import MS_ORDER.MS_ORDER.dto.PaymentDto;

import java.util.List;

public interface PaymentService {

    PaymentDto createPayment(PaymentDto paymentDto);

    PaymentDto getById(Long id);

    List<PaymentDto> getAllPayments();

    PaymentDto updatePayment(Long id, PaymentDto paymentDto);

    void deletePayment(Long id);
}
