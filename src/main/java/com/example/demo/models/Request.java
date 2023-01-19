package com.example.demo.models;

import jakarta.persistence.Entity;

public class Request
{
    public String Reason;
    public String Source;
    public String Destination;

    public Request(String reason, String source, String destination) {
        Reason = reason;
        Source = source;
        Destination = destination;
    }

    public Request() {
    }

    public String getReason() {
        return Reason;
    }

    public void setReason(String reason) {
        Reason = reason;
    }

    public String getSource() {
        return Source;
    }

    public void setSource(String source) {
        Source = source;
    }

    public String getDestination() {
        return Destination;
    }

    public void setDestination(String destination) {
        Destination = destination;
    }
}
