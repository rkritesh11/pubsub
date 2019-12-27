package com.app.model;

import java.io.Serializable;

public class Notification implements Serializable {
    private String message;


    public Notification() {
    }

    public Notification(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "message='" + message + '\'' +
                '}';
    }
}
