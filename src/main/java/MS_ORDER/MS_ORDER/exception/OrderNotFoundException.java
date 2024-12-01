package MS_ORDER.MS_ORDER.exception;


import MS_ORDER.MS_ORDER.config.i18n.i18NConstants;

import java.util.ResourceBundle;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException() {
        super(ResourceBundle.getBundle("i18n/message").getString(i18NConstants.ORDER_NOT_FOUND));
    }
}
