package run;

import exceptions.AmountException;
import exceptions.CustomerException;
import exceptions.ProductException;
import lombok.Getter;


import java.time.LocalDate;
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
        // тестовый массив покупателей, содержащий 11 существующих и 1 некорректного
        Customer[] testArrCustomers = {customers[0], customers[1], customers[0], customers[1], customers[0],
                customers[1], customers[0], customers[1], customers[0], customers[0], customers[0], customers[0],
                new Customer("Jimi Hendrix", 83, 89150682268L)};
        // тестовый массив товаров, содержащий 5 существующих и 1 некорректный
        Product[] testArrProducts = {products[0], products[1], products[2], products[3], products[4],
                new Product("Fender Stratocaster", 1200)};

        Random rndIndex = new Random();
        int rndIndexCustomers = 0;
        int rndIndexProducts = 0;
        int rndAmount = 1;
        do {
            try {
                rndIndexCustomers = rndIndex.nextInt(0, 13);
                rndIndexProducts = rndIndex.nextInt(0, 6);
                rndAmount = rndIndex.nextInt(-4, 13);
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
            }
            Thread.sleep(200); // для более корректного вывода на консоль StackTrace'ов и количества оформленных заказов
            System.out.println("Всего было оформлено " + counterOrders() + " заказов.");
        } while (counterOrders() != 5);

        LocalDate testToday = LocalDate.of(2024, 1, 2);
        LocalDate testToday2 = LocalDate.now();
        Employee[] employees = {
                new Employee("Кирилл", 28, 89265262136L, Customer.Gender.MALE),
                new Employee("Мария", 26, 89268939673L, Customer.Gender.FEMALE),
                new Employee("Николай", 46, 89208342164L, Customer.Gender.MALE),
                new Employee("Дарья", 29, 89259079068L, Customer.Gender.FEMALE),
                new Employee("Алексей", 23, 89203484533L, Customer.Gender.MALE)
        };

        congratulation(employees, testToday);

    }


    public static Order makePurchase(Customer customer, Product product, int amount) throws
            AmountException, CustomerException, ProductException {
        if (!buyerExist(customer)) throw new CustomerException(customer);
        if (!isProductInStock(product)) throw new ProductException(product);
        if (amount <= 0 || amount > 10) throw new AmountException(amount);
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

    private static void congratulation(Employee[] employees, LocalDate today) {
        String subDate = today.toString().substring(5);
        Holidays x = Holidays.NONE;
        for (Holidays h : Holidays.values()) {
            if (h.getMonthAndDay().equals(subDate)) x = h;
        }
        for (Employee e : employees) {
            if (x == Holidays.NONE) {
                System.out.println("Уважаемый(ая) " + e.getName() + "! Поздравляем Вас, сегодня обычный рабочий день!");
            } else if (x == Holidays.NEW_YEAR) {
                System.out.println("Уважаемая " + e.getName() + "! Поздравляем Вас с Новым Годом");
            } else if (x == Holidays.MARCH_8 && e.getGender() == Customer.Gender.FEMALE) {
                System.out.println("Уважаемая " + e.getName() + "! Поздравляем Вас с Международным женским днем!");
            } else if (x == Holidays.FEBRUARY_23 && e.getGender() == Customer.Gender.MALE) {
                System.out.println("Уважаемый " + e.getName() + "! Поздравляем Вас с Днем защитника отечества!");
            }
        }
    }

    @Getter
    private enum Holidays {
        NONE("??"),
        MARCH_8("03-08"),
        FEBRUARY_23("02-23"),
        NEW_YEAR("01-01");

        private String monthAndDay;

        Holidays(String data) {
            this.monthAndDay = data;
        }
    }
}