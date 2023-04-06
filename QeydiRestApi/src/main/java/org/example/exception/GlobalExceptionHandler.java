//package org.example.exception;
//
//import org.example.dto.ResponseDTO;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.FieldError;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//import java.util.ArrayList;
//import java.util.List;
//
//    @RestControllerAdvice
//    public class GlobalExceptionHandler {
//
//        @ExceptionHandler(Exception.class)
//        public ResponseEntity<ResponseDTO> handleException(Exception ex) {
//            return ResponseEntity.badRequest().body(ResponseDTO.error(ex.getMessage()));
//        }
//
//        @ExceptionHandler(UserNotFoundException.class)
//        public ResponseEntity<ResponseDTO> handleUserNotFoundException(UserNotFoundException ex) {
//            return ResponseEntity.notFound().build();
//        }
//
//        @ExceptionHandler(UserAlreadyExistException.class)
//        public ResponseEntity<ResponseDTO> handleUserAlreadyExistException() {
//            return handleUserAlreadyExistException(null);
//        }
//
//        @ExceptionHandler(UserAlreadyExistException.class)
//        public ResponseEntity<ResponseDTO> handleUserAlreadyExistException(UserAlreadyExistException ex) {
//            return ResponseEntity.badRequest().body(ResponseDTO.error(ex.getMessage()));
//        }
//
//        @ExceptionHandler(MethodArgumentNotValidException.class)
//        public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
//            BindingResult result = ex.getBindingResult();
//            List<FieldError> fieldErrors = result.getFieldErrors();
//            List<String> errors = new ArrayList<>();
//
//            for (FieldError fieldError : fieldErrors) {
//                errors.add(fieldError.getField() + ": " + fieldError.getDefaultMessage());
//            }
//
//            return ResponseEntity.badRequest().body(ResponseDTO.error(errors));
//        }
//
//        @ExceptionHandler(UnauthorizedException.class)
//        public ResponseEntity<ResponseDTO> handleUnauthorizedException(UnauthorizedException ex) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//        }
//    }
//
