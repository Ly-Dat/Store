import java.util.*;

public class EIUBUSOR {

    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        int N = sc.nextInt();
        String dataType = sc.next();
       
        if (dataType.equals("int")) {
            Integer[] numbers = new Integer[N];
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = sc.nextInt();
            }
            bubbleSort(numbers);
            printResult(numbers);
        } else if (dataType.equals("long")) {
            Long[] numbers = new Long[N];
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = sc.nextLong();
            }
            bubbleSort(numbers);
            printResult(numbers);
        } else if (dataType.equals("double")) {
            Double[] numbers = new Double[N];
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = sc.nextDouble();
            }
            bubbleSort(numbers);
            printResult(numbers);
        } else {
            Float[] numbers = new Float[N];
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = sc.nextFloat();
            }
            bubbleSort(numbers);
            printResult(numbers);
        }

    }

    public static <T extends Number> void printResult(T[] numbers) {

        StringBuilder sb = new StringBuilder();
        for (T t : numbers) {
            sb.append(t).append(" ");
        }
        System.out.println(sb);
    }

    static <T extends Number & Comparable<T>> void bubbleSort(T[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j].compareTo(array[j + 1]) > 0)
                    swap(array, j, j  + 1);
            }
        }
    }

    public static <T extends Number & Comparable<T>> void swap(T[] array, int i, int j) {
        T temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }
}
