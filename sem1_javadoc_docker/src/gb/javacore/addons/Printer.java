package gb.javacore.addons;

/**
 * Доп. класс для печати на консоль
 * @version 1.1
 */
public class Printer<T> {
    /**
     * Процедура печати на консоль {@link Printer}
     * @param number - обобщенное значение результата (ожидаются: Integer/Double/Float)
     */
    public void print(T number){
        System.out.println("Результат вычисления равен " + number);
    }
}
