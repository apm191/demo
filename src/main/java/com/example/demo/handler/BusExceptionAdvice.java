package com.example.demo.handler;

import com.example.demo.error.BusError;
import com.example.demo.models.Bus;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class BusExceptionAdvice
{
    @ExceptionHandler(value = BusServiceException.class)
    public ResponseEntity<BusError> mapException(BusServiceException ex)
    {
        BusError busError = new BusError(ex.getMessage());
        return new ResponseEntity<>(busError,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> handleInvalidArgument(MethodArgumentNotValidException ex)
    {
        Map<String,String> errorMap = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error->{
            errorMap.put(error.getCode(),error.getDefaultMessage());
        });
        return errorMap;
    }
}
