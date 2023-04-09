package org.example.exception;

import org.example.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.common.exceptions.UnauthorizedUserException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


    @RestControllerAdvice
    public class GlobalExceptionHandler {


        @ExceptionHandler(UsernameNotFoundException.class)
        public ResponseEntity<String> handleUserNotFoundException(UsernameNotFoundException ex) {
            return new ResponseEntity<>("Username already in use", HttpStatus.BAD_REQUEST);
        }

        @ExceptionHandler(IllegalArgumentException.class)
        public ResponseEntity<String> handleUserAlreadyExistException() {
            return new ResponseEntity<>("Username already in use", HttpStatus.BAD_REQUEST);
        }

        
        @ExceptionHandler(UnauthorizedUserException.class)
        public ResponseEntity<ResponseDTO> handleUnauthorizedException(UnauthorizedUserException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

