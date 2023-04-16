package org.example.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDTO {
    private Integer errorCode;
    private String errorMessage;
    private String successMessage;
    private Object obj;

    public ResponseDTO() {
    }

    public static ResponseDTO of(Object obj) {
        ResponseDTO resp = new ResponseDTO();
        resp.setObj(obj);
        return resp;
    }

    public static ResponseDTO of(Object obj, String successMessage) {
        ResponseDTO resp = new ResponseDTO();
        resp.setObj(obj);
        resp.setSuccessMessage(successMessage);
        return resp;
    }

    public static ResponseDTO of(Object obj, Integer errorCode, String errorMessage) {
        ResponseDTO resp = new ResponseDTO();
        resp.setObj(obj);
        resp.setErrorCode(errorCode);
        resp.setErrorMessage(errorMessage);
        return resp;
    }

    public ResponseDTO(Integer errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
