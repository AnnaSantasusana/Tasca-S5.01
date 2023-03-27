package cat.itacademy.barcelonactiva.santasusana.anna.s05.t01.n02.model.exceptions;

import cat.itacademy.barcelonactiva.santasusana.anna.s05.t01.n02.model.dto.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Message> handleInternalServerError(Exception ex, WebRequest request) {
        Message errorMessage = new Message(HttpStatus.INTERNAL_SERVER_ERROR.value(), new Date(), "Internal server error: " + ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(FlowerNotFoundException.class)
    public ResponseEntity<Message> handleFlowerNotFound(FlowerNotFoundException ex, WebRequest request) {
        Message errorMessage = new Message(HttpStatus.NOT_FOUND.value(), new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<Message>> handleValidationExceptions(MethodArgumentNotValidException ex) {

        List<Message> fieldErrorMessages = new ArrayList<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String message = error.getDefaultMessage();
            String fieldName = ((FieldError) error).getField();
            fieldErrorMessages.add(new Message(HttpStatus.BAD_REQUEST.value(), new Date(),
                    message, "The validation error is in the field: " + fieldName));

        });
        return new ResponseEntity<>(fieldErrorMessages, HttpStatus.BAD_REQUEST);
    }

}



