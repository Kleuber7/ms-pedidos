package MS_ORDER.MS_ORDER.exception;

import MS_ORDER.MS_ORDER.config.i18n.i18NConstants;

import java.util.ResourceBundle;

public class PaymentNotFoundException extends RuntimeException {
    public PaymentNotFoundException() {
        super(ResourceBundle.getBundle("i18n/message").getString(i18NConstants.PAYMENT_NOT_FOUND));
    }
}
