package exceptions;

import run.Product;

public class ProductException extends Exception {
    public ProductException(Product p){
        super("Несуществующий товар: " + p + "! Заказ не оформлен.");
    }
}
