package org.example;

public class WrongLoginException extends Exception {
    WrongLoginException() {
        super();
    }

    WrongLoginException(String msg) {
        super(msg);
    }
}
