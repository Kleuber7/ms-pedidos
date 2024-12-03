package MS_ORDER.MS_ORDER.exceptionhandler;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class ValidateError extends StandardError {

    private Map<String, String> fieldErrors;

}
