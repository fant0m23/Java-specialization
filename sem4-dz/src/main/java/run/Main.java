package run;

import exceptions.AmountException;
import exceptions.CustomerException;
import exceptions.ProductException;

import java.util.Random;

public class Main {
    private static final Customer[] customers = {
            new Customer("John Rambo", 32, 89204353284L),
            new Customer("Casey F. Ryback", 37, 89108542114L)
    };
    private static final Product[] products = {
            new Product("Лук спортивный", 800),
            new Product("Стрелы (12 шт.)", 20),
            new Product("Нож охотничий", 250),
            new Product("Топорик кухонный", 90),
            new Product("Поварской колпак", 15)
    };
    private static Order[] orders = new Order[5];

    public static void main(String[] args) throws CustomerException {
        Customer unknownCustomer = new Customer("Bob Dylan", 83, 89150682268L);
        Product unknownProduct = new Product("Fender Stratocaster", 1200);

        try {
            orders[0] = makePurchase(customers[1], products[3], 2);
            orders[1] = makePurchase(customers[1], unknownProduct, 2);
            orders[2] = makePurchase(customers[0], products[2], 1);
            orders[3] = makePurchase(customers[0], products[0], 111);
            orders[4] = makePurchase(unknownCustomer, products[4], 1);

        } catch (ProductException | AmountException e) {
            e.printStackTrace();
        }

        System.out.println("\nВсего было оформлено " + counterOrders() + " заказов.");
    }

    public static Order makePurchase(Customer customer, Product product, int amount) throws
            AmountException, CustomerException, ProductException {
        int finalAmount = amount;
        if (!buyerExist(customer)) throw new CustomerException(customer);
        if (!isProductInStock(product)) throw new ProductException(product);
        if (amount < 0 || amount > 20){
            finalAmount = 1;
            throw new AmountException();
        }
        System.out.println("Заказ №" + counterOrders() + " оформлен.");
        return new Order(customer, product, finalAmount);
    }

    private static boolean buyerExist(Customer customer) {
        for (Customer c : customers) {
            if (c.equals(customer)) return true;
        }
        return false;
    }

    private static boolean isProductInStock(Product product) {
        for (Product p : products) {
            if (p.equals(product)) return true;
        }
        return false;
    }

    private static int counterOrders() {
        int count = 0;
        for (Order o : orders) {
            if (o != null) count++;
        }
        return count;
    }
}