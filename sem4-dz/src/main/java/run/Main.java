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

    public static void main(String[] args) throws CustomerException, InterruptedException {
        // тестовый массив покупателей, содержащий 4 существующих и 1 некорректного
        Customer[] testArrCustomers = {customers[0], customers[1], customers[0], customers[1],
                new Customer("Bob Dylan", 83, 89150682268L)};
        // тестовый массив товаров, содержащий 5 существующих и 1 некорректный
        Product[] testArrProducts = {products[0], products[1], products[2], products[3], products[4],
                new Product("Fender Stratocaster", 1200)};

        Random rndIndex = new Random();
        int rndIndexCustomers = 0;
        int rndIndexProducts = 0;
        int rndAmount = 1;
        do {
            try {
                rndIndexCustomers = rndIndex.nextInt(0, 5);
                rndIndexProducts = rndIndex.nextInt(0, 6);
                rndAmount = rndIndex.nextInt(-2, 23);
                orders[counterOrders()] = makePurchase(
                        testArrCustomers[rndIndexCustomers], testArrProducts[rndIndexProducts], rndAmount);
            } catch (ProductException e) {
                e.printStackTrace();
            } catch (AmountException e) {
                try {
                    orders[counterOrders()] = makePurchase(testArrCustomers[rndIndexCustomers],
                            testArrProducts[rndIndexProducts], 1);
                } catch (ProductException | AmountException | CustomerException ex) {
                    ex.getMessage();
                }
                e.printStackTrace();
            } catch (CustomerException e) {
                throw new CustomerException(testArrCustomers[rndIndexCustomers]);
            } finally {
            }
            Thread.sleep(200); // для более корректного вывода на консоль StackTrace'ов и количества оформленных заказов
            System.out.println("Всего было оформлено " + counterOrders() + " заказов.");
        } while (counterOrders() != 5);
    }

    public static Order makePurchase(Customer customer, Product product, int amount) throws
            AmountException, CustomerException, ProductException {
        if (!buyerExist(customer)) throw new CustomerException(customer);
        if (!isProductInStock(product)) throw new ProductException(product);
        if (amount <= 0 || amount > 20) throw new AmountException(amount);
        Order order = new Order(customer, product, amount);
        System.out.println("\nОформлен новый заказ: " + order);
        return order;
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