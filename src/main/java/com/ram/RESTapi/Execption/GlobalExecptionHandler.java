package com.ram.RESTapi.Execption;

import com.ram.RESTapi.Model.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice   //every execption request  this class will  response
public class GlobalExecptionHandler {
       @ExceptionHandler(Exception.class)
       public ResponseEntity<ErrorDetails> genericException(Exception e, WebRequest request){
           ErrorDetails details = new ErrorDetails();
           details.setDateTime(LocalDateTime.now());
           details.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
           details.setMsg("Something went wrong, please try again");
           details.setPath(request.getDescription(false));
           return  new ResponseEntity<>(details, HttpStatus.INTERNAL_SERVER_ERROR);
       }
    @ExceptionHandler(usernotFoundExecption.class)
    public ResponseEntity<ErrorDetails> userNotFound(
            usernotFoundExecption e,
            WebRequest request) {

        ErrorDetails details = new ErrorDetails();
        details.setDateTime(LocalDateTime.now());
        details.setStatus(HttpStatus.NOT_FOUND.value());
        details.setMsg(e.getMessage());
        details.setPath(request.getDescription(false));

        return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
    }


}
