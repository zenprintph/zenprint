package ph.com.zenprint.exception;

import lombok.Getter;
import ph.com.zenprint.constant.ExceptionMessage;
import ph.com.zenprint.constant.ResponseCode;

/**
 * @author Choy
 * @date 11/3/2020.
 */

@Getter
public class NotFoundException extends RuntimeException {

    private final transient ResponseCode responseCode;

    public NotFoundException(String exceptionMessage,
                             ResponseCode responseCode) {
        super(exceptionMessage);
        this.responseCode = responseCode;
    }

    public enum Error {
        PRODUCT_NOT_FOUND(ResponseCode.GEN404, ExceptionMessage.PRODUCT_NOT_FOUND),
        SALES_NOT_FOUND(ResponseCode.GEN404, ExceptionMessage.SALES_NOT_FOUND);

        private final ResponseCode code;
        private final String message;

        Error(ResponseCode code, String message) {
            this.code = code;
            this.message = message;
        }

        public NotFoundException create() {
            return new NotFoundException(message, code);
        }
    }
}