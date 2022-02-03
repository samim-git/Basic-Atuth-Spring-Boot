package com.hs.basicauth.response;

public class RestResponse {
    String message;
    int responseCode;
    Object data;
    String errorMessage;

    public void setMessage(String message) {
        this.message = message;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }
    public void setData(Object data) {
        this.data = data;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getMessage() {
        return message;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public Object getData() {
        return data;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
