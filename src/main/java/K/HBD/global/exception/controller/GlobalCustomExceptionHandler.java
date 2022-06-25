package K.HBD.global.exception.controller;

import K.HBD.global.exception.CustomException;
import K.HBD.global.exception.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalCustomExceptionHandler {

    @ExceptionHandler(value = {CustomException.class})
    public ResponseEntity<ErrorResponse> CustomExceptionHandler(CustomException e) {
        log.warn("CustomException Message : {} ", e.getMessage(), e);

        return ErrorResponse.toResponseEntity(e.getErrorCode());
    }
}
