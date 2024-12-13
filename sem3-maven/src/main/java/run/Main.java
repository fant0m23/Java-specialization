package run;

/*
 1. Написать прототип компаратора - метод внутри класса сотрудника, сравнивающий две даты, представленные
    в виде трёх чисел гггг-мм-дд, без использования условного оператора.
 2. Опишите класс руководителя, наследник от сотрудника. Перенесите статический метод повышения зарплаты
    в класс руководителя, модифицируйте метод таким образом, чтобы он мог поднять заработную плату всем,
    кроме руководителей. В основной программе создайте руководителя и поместите его в общий массив
    сотрудников. Повысьте зарплату всем сотрудникам и проследите, чтобы зарплата руководителя не повысилась.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Worker e1 = new Employee("Sergey", 12, 4, 1987, 98000);
        Worker e2 = new Employee("Vlad", 26, 11, 1985, 122000);
        Worker e3 = new Employee("Elena", 5, 3, 1996, 107000);
        Worker m1 = new Manager("Daria", 10, 9, 1991, 157000);
        Worker m2 = new Manager("Kirill", 14, 10, 1978, 165000);
        Worker e4 = new Employee();
        e4.setName("Roman");
        e4.setBDay(17);
        e4.setBMonth(7);
        e4.setBYear(1979);
        e4.setSalary(130000);

        System.out.println(m2.compareTo(e1));
        System.out.println(m2.compare(e1.bYear, e1.getBMonth(), e1.getBDay()));

        List<Worker> workers = new ArrayList<>(Arrays.asList(e1, e2, e3, e4, m1, m2));
        System.out.println("\n--------------------- Перед сортировкой ----------------------");
        for (Worker w : workers) {
            System.out.println(w);
        }
        Collections.sort(workers);
        System.out.println("\n----------- Отсортирован методом compareTo (Comparable) -----------");
        for (Worker w : workers) {
            System.out.println(w);
        }
        Collections.shuffle(workers);
        System.out.println("\n------------------------- Перемешан --------------------------");
        for (Worker w : workers) {
            System.out.println(w);
        }
        workers.sort(new WorkerComparator());
        System.out.println("\n----------- Отсортирован снова WorkerComparator'ом ------------");
        for (Worker w : workers) {
            System.out.println(w);
        }
        System.out.println("\n----------- Повышение зарплаты работникам на 8% ------------");
        for (Worker w : workers) {
            if (w instanceof Manager) System.out.println(w + " " + w.getClass());
            else {
                w.salaryIncrease();
                System.out.println(w + " " + w.getClass());
            }
        }
    }
}