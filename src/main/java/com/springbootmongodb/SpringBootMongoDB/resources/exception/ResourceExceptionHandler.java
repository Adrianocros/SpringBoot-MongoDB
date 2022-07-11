package com.springbootmongodb.SpringBootMongoDB.resources.exception;

import com.springbootmongodb.SpringBootMongoDB.services.exception.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

@ControllerAdvice //Essa classe é respo. por tratar erros nas requisições
public class ResourceExceptionHandler implements Serializable {
    private static final long serialVersionUID = 1L;

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objNotFound(ObjectNotFoundException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(System.currentTimeMillis(),status.value(),"Não encontrado",e.getMessage(),request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
