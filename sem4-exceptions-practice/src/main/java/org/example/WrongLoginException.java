package org.example;

public class WrongLoginException extends Exception {
    WrongLoginException() {
        super();
    }

    WrongLoginException(int b){
        super("Длина login должна быть меньше 20 символов! Ожидалось не более 20 символов / Фактически введено " +
                b + " символов");
    }
}
