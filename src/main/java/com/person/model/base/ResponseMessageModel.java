package com.person.model.base;

public class ResponseMessageModel {

    private String status;
    private String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ResponseMessageModel{" +
                "status:'" + status + '\'' +
                ", message:'" + message + '\'' +
                '}';
    }
}
