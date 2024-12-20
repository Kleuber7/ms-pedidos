package MS_ORDER.MS_ORDER.dto;
import java.time.LocalDateTime;

public record PaymentDto(
        Long paymentCode,
        Long orderCode,
        PaymentMethod paymentMethod,
        PaymentStatus paymentStatus,
        LocalDateTime paymentDate
) {}
