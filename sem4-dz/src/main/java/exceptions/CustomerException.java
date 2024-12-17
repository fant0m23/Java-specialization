package exceptions;

import run.Customer;

public class CustomerException extends Exception {

    public CustomerException(Customer c){
        super("Несуществующий покупатель: " + c);
    }
}