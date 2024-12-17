package exceptions;

public class AmountException extends Exception {

    public AmountException(){
        super("Неверное количество товаров! В заказ добавлен 1 товар.");
    }
}
