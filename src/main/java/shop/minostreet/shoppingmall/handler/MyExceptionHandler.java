package shop.minostreet.shoppingmall.handler;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;
import shop.minostreet.shoppingmall.dto.ResponseDto;
import shop.minostreet.shoppingmall.handler.annotation.MyErrorLogRecord;
import shop.minostreet.shoppingmall.handler.exception.MyApiException;
import shop.minostreet.shoppingmall.handler.exception.MyForbiddenException;
import shop.minostreet.shoppingmall.handler.exception.MyValidationException;

@RestControllerAdvice
public class MyExceptionHandler {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @MyErrorLogRecord
    @ExceptionHandler(MyApiException.class)
    public ResponseEntity<?> apiException(MyApiException e){

        log.error(e.getMessage());
        return new ResponseEntity<>(new ResponseDto<>(-1, e.getMessage(), null), HttpStatus.BAD_REQUEST);
    }

    @MyErrorLogRecord
    @ExceptionHandler(MyValidationException.class)
    public ResponseEntity<?> validationApiException(MyValidationException e){

        log.error(e.getMessage());
        return new ResponseEntity<>(new ResponseDto<>(-1, e.getMessage(), e.getErroMap()), HttpStatus.BAD_REQUEST);
    }

    @MyErrorLogRecord
    @ExceptionHandler(MyForbiddenException.class)
    public ResponseEntity<?> forbiddenException(MyForbiddenException e){

        log.error(e.getMessage());
        return new ResponseEntity<>(new ResponseDto<>(-1, e.getMessage(), null), HttpStatus.FORBIDDEN);
    }

    @MyErrorLogRecord
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<?> notFoundException(NoHandlerFoundException e){
        log.error(e.getMessage());
        return new ResponseEntity<>(new ResponseDto<>(-1, e.getMessage(), null), HttpStatus.NOT_FOUND);
    }

    @MyErrorLogRecord
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> serverErrorException(Exception e){

        log.error(e.getMessage());
        return new ResponseEntity<>(new ResponseDto<>(-1, e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
