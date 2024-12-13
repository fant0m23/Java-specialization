package gb.javacore.addons;

/**
 * Интерфейс с методом calculate
 * @version 1.1
 */
public interface Calculable<T> {
    T calculate(T a, T b);
}
