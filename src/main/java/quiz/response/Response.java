package quiz.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response <T>{
    private T data;
    private boolean success;

    private String errorMessage;
    private Integer errorCode;

    public Response(T data) {
        this.data = data;
        this.success = true;
    }

    public Response(String errorMessage, Integer errorCode) {
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
        this.success = false;
    }
}
