package MS_ORDER.MS_ORDER.domain;
import java.time.LocalDateTime;

public record PaymentDto(
        Long paymentCode,
        Long orderCode,
        PaymentMethod paymentMethod,
        PaymentStatus paymentStatus,
        LocalDateTime paymentDate
) {
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long paymentCode;
        private Long orderCode;
        private PaymentMethod paymentMethod;
        private PaymentStatus paymentStatus;
        private LocalDateTime paymentDate;

        public Builder paymentCode(Long paymentCode) {
            this.paymentCode = paymentCode;
            return this;
        }

        public Builder orderCode(Long orderCode) {
            this.orderCode = orderCode;
            return this;
        }

        public Builder paymentMethod(PaymentMethod paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }

        public Builder paymentStatus(PaymentStatus paymentStatus) {
            this.paymentStatus = paymentStatus;
            return this;
        }

        public Builder paymentDate(LocalDateTime paymentDate) {
            this.paymentDate = paymentDate;
            return this;
        }

        public PaymentDto build() {
            return new PaymentDto(paymentCode, orderCode, paymentMethod, paymentStatus, paymentDate);
        }
    }
}

