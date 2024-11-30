package co.edu.uptc.models;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class ErrorResponsive {
    @Getter
    @Setter
    private int status;
    private String message;
    //private LocalDateTime timestamp;
    private List<String> errorCodes;

    public ErrorResponsive(int status, String message, List<String> errorCodes) {
        this.status = status;
        this.message = message;
        this.errorCodes = errorCodes;
    }

    public String getMessage(){
        return message;
    }
}
