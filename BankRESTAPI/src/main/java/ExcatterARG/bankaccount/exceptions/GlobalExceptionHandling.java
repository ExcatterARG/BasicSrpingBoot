package ExcatterARG.bankaccount.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandling extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AccountNotFoundException.class)
    public final ResponseEntity<Object> handleNotFoundExceptions(AccountNotFoundException ex){
        String message = "The account with number " + ex.getAccountId() + " was not found";
        return new ResponseEntity(message, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ForbiddenOperationException.class)
    public final ResponseEntity<Object> handleForbiddenOperation(ForbiddenOperationException ex){
        String message = "account id: " + ex.getAccountId() + " with balance: " + ex.getBalance() + ": " + ex.getReason();
        return new ResponseEntity(message, HttpStatus.BAD_REQUEST);
    }
}
