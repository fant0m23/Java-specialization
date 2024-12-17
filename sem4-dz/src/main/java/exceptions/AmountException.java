package exceptions;

public class AmountException extends Exception {

    public AmountException(int amount) {
        super("Неверное количество товаров " + amount + "! В заказ добавлен 1 товар.");
    }
}
