package com.example.demo.error;

public class BusError {
    public BusError() {
    }
    private String ErrorMessage;
    public BusError(String ErrorMessage) {
        this.ErrorMessage = ErrorMessage;
    }

    public String getErrorMessage() {
        return ErrorMessage;
    }

    public void setErrorMessage(String ErrorMessage) {
        this.ErrorMessage = ErrorMessage;
    }
}
