package Bai8.SrpingDataREST.handle;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> checkAll(Exception ex) {
        ErrorResponse err = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        return ResponseEntity.badRequest().body(err);
    }
}
