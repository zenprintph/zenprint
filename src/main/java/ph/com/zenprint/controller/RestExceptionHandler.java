package ph.com.zenprint.controller;

import brave.Tracer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ph.com.zenprint.constant.ExceptionMessage;
import ph.com.zenprint.constant.ResponseCode;
import ph.com.zenprint.constant.Severity;
import ph.com.zenprint.dto.BaseResponse;
import ph.com.zenprint.dto.ErrorDto;
import ph.com.zenprint.exception.NotFoundException;

import java.time.LocalDateTime;
import java.util.Collections;

/**
 * @author Choy
 * @date 11/3/2020.
 */

@RequiredArgsConstructor
@Slf4j
@ControllerAdvice
public class RestExceptionHandler {

    private final Tracer tracer;

    @ExceptionHandler(Exception.class)
    public ResponseEntity<BaseResponse<Object>> handleGeneralException(Exception e) {
        log.error(e.getMessage(), e);

        String message = String.format(ExceptionMessage.GENERAL, ResponseCode.GEN500);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(buildBaseResponse(ResponseCode.GEN500, message));
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<BaseResponse<Object>> handleNotFoundException(NotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(buildBaseResponse(e.getResponseCode(), e.getMessage()));
    }

    private BaseResponse<Object> buildBaseResponse(ResponseCode code, String message) {
        return BaseResponse.builder()
                .errors(Collections.singletonList(ErrorDto.builder()
                        .responseCode(code)
                        .message(message)
                        .severity(Severity.ERROR)
                        .ticketId(tracer.currentSpan().context().traceIdString())
                        .timestamp(LocalDateTime.now())
                        .build()))
                .build();
    }
}