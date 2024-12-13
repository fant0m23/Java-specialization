package org.example;

public class WrongPasswordException extends Exception {
    WrongPasswordException() {
        super();
    }

    WrongPasswordException(String msg) {
        super(msg);
    }
}
