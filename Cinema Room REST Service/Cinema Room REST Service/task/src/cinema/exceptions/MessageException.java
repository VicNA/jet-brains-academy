package cinema.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class MessageException {
    private String error;

    public MessageException(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
