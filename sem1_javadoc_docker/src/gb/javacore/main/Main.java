package gb.javacore.main;

import gb.javacore.addons.Calculable;
import gb.javacore.addons.Printer;

/**
 * Основной класс программы с точкой входа
 * @version 1.1
 */
public class Main {
    public static void main(String[] args) {
        // целые числа для проведения над ними арифметических операций
        int x = 16;
        int y = 2;
        /** Создаем лямбда-функции реализуя интерфейс Calculable */
        Calculable<Integer> sum = Integer::sum;
        Calculable<Integer> subt = (a,b) -> a - b;
        Calculable<Integer> mult = (a,b) -> a * b;
        Calculable<Integer> div = (a,b) -> a / b;
        /** Печатаем результат метода calculate */
        Printer<Integer> printer = new Printer<>();
        printer.print(sum.calculate(x, y));
        printer.print(subt.calculate(x, y));
        printer.print(mult.calculate(x, y));
        printer.print(div.calculate(x, y));
    }
}