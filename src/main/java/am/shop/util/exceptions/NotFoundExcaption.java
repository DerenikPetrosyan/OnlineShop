package am.shop.util.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundExcaption extends Exception{
    public NotFoundExcaption() {

    }

    public NotFoundExcaption(String message) {
        super(message);
    }
}
