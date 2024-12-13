/*
1.  Написать метод, возвращающий количество чётных элементов массива.
        countEvens([2, 1, 2, 3, 4]) → 3 countEvens([2, 2, 0]) → 3 countEvens([1, 3, 5]) → 0
2.  Написать функцию, возвращающую разницу между самым большим и самым маленьким элементами
        переданного не пустого массива.
3.  Написать функцию, возвращающую истину, если в переданном массиве есть два соседних элемента,
        с нулевым значением.

*/


import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.LongFunction;

public class Main {
    public static void main(String[] args) {

        int[] nums = {1, 2, 0, 61, 5, 0, 0, 8, 17};

        System.out.println(countEvens(nums, LambdaHelper::isEven));
        System.out.println(difBetweenMinMaxValues(nums, LambdaHelper::isBigger));
        System.out.println(zerosSideBySide(nums));

        // очень много встроенных функциональных интерфейсов в java.util.function.*
        BiFunction<Integer, Integer, Character> sumToChar = (c, d) -> (char) (c + d);
        char c = sumToChar.apply(nums[3], nums[8]);
        BinaryOperator<Integer> binaryOperator = Integer::sum;
        System.out.println(binaryOperator.apply(nums[3], nums[1]));
        System.out.println(sumToChar.apply(nums[3], nums[1]));
    }

    private static int countEvens(int[] nums, MyExpression func) {
        int counter = 0;
        for (int i : nums) {
            if (func.isEqual(i)) counter++;
        }
        return counter;
    }

    private static int difBetweenMinMaxValues(int[] nums, MyExpression2 func) {
        if (nums.length == 0) {
            System.out.print("Количество элементов массива равно ");
            return 0;
        }
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        for (int i : nums) {
            if (func.isBigger(i, maxValue)) maxValue = i;
            if (!func.isBigger(i, minValue)) minValue = i;
        }
        return maxValue - minValue;
    }

    private static boolean zerosSideBySide(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == 0) {
                if (array[i + 1] == 0) return true;
            }
        }
        return false;
    }
}
