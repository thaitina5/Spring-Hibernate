package ControllerAdvice.Exception;

import ControllerAdvice.Entity.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> catchError(StudentException stex) {
        ErrorResponse er = new ErrorResponse(HttpStatus.NOT_FOUND.value(), stex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(er);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> catchAllError(Exception stex) {
        ErrorResponse er = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), stex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(er);
    }
}
