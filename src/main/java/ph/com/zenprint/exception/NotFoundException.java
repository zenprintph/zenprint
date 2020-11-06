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
        PRODUCT_NOT_FOUND(ResponseCode.GEN404);

        private final ResponseCode code;
        private final String message;

        Error(ResponseCode code) {
            this.code = code;
            this.message = ExceptionMessage.PRODUCT_NOT_FOUND;
        }

        public NotFoundException create() {
            return new NotFoundException(message, code);
        }
    }
}