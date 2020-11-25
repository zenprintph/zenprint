package ph.com.zenprint.exception;

import ph.com.zenprint.constant.ExceptionMessage;
import ph.com.zenprint.constant.ResponseCode;

/**
 * @author Choy
 * @date 11/25/2020.
 */
public class DataAlreadyExistException extends RuntimeException {

    private final transient ResponseCode responseCode;

    public DataAlreadyExistException(String exceptionMessage,
                             ResponseCode responseCode) {
        super(exceptionMessage);
        this.responseCode = responseCode;
    }

    public enum Error {
        PRODUCT_CODE_EXIST(ResponseCode.GEN409, ExceptionMessage.PRODUCT_CODE_EXIST);

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