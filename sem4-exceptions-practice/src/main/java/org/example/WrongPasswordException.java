package org.example;

public class WrongPasswordException extends Exception {

    WrongPasswordException() {
        super();
    }

    WrongPasswordException(String password, String confirmPassword) {
        super("Password и confirmPassword должны быть равны!\nОжидалось: " +
                confirmPassword + " / Фактически: " + password);
    }

    WrongPasswordException(int b) {
        super("Длина login должна быть меньше 20 символов! Ожидалось: не более 20 символов" +
                " / Фактически введено: " + b + " символов");
    }
}
