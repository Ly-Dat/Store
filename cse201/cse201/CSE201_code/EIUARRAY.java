import java.util.Arrays;
import java.util.Scanner;

class ArrayAlgorithms {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] numbers = new int[n];
        for (int j = 0; j < n; j++) {
            numbers[j] = sc.nextInt();
        }
        Arrays.sort(numbers);
        for (int i = 0; i < m; i++) {
            String command = sc.next();

            long result = 0;
            switch (command) {
                case "findMax":
                    result = findMax(numbers, n);
                    ;
                    break;
                case "findMin":
                    result = findMin(numbers, n);
                    break;
                case "average":
                    System.out.println(average(numbers));
                case "sum":
                    result = sum(numbers);
                case "countMax":
                    result = countMax(numbers, n);
                case "sumOddNumber":
                    result = sumOddNumber(numbers);
            }
            System.out.println(result);

            // Add your code here

        }
    }

    static int findMax(int[] numbers, int n) {
        return numbers[n - 1];

    }

    static int findMin(int[] numbers, int n) {
        return numbers[0];

    }

    static double average(int[] numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        double average = sum / numbers.length;
        return average;
    }

    static int sum(int[] numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        return sum;
    }

    /**
     * @Desciption:
     * @Hint: find maximum number in the array, then check which number is
     */
    static int countMax(int[] numbers, int n) {
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == findMax(numbers, n)) {
                count++;
            }
        }
        return count;
    }

    /**
     * @Desciption: sum all odd numbers in array
     * @Hint: what is odd number, how to check?
     */
    static int sumOddNumber(int[] numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 != 0) {
                sum+=numbers[i];
            }
        }
        return sum;
    }

    static int countEvenNumber(int[] numbers) {
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    static int indexOf(int[] numbers, int value) {
        for(int i =0; i<numbers.length;i++){
            if(numbers[i]==value){
                return i;
            }
        }
        return -1;
    }

    static int lastIndexOf(int[] numbers, int value) {
        // Add your code here
        return -1;
    }

    /**
     * @Desciption: find minimum difference between two consecutive numbers in an
     *              array
     * @Hint: minimum of Math.absolute(array[i+1] - array[i])
     */
    static int findMinDistance(int[] numbers) {
        // Add your code here
        return 0;
    }

    /**
     * @Desciption: Check if first number equal last number, second number equal
     *              second to last number, and so on...
     * @Hint: i-th number equal (length-1-i)-th number
     */
    static boolean isPalindrome(int[] numbers) {
        // Add your code here
        return false;
    }

    /**
     * @Desciption: Check if number is in array
     */
    static boolean contains(int[] numbers, int number) {
        // Add your code here
        return false;
    }

    /**
     * @Desciption: Check if array has duplicated numbers
     * @Hint: Should check every pair of number, array[i] vs. array[j], i != j
     */
    static boolean hasDuplicated(int[] numbers) {
        // Add your code here
        return false;
    }

    /**
     * @Desciption: Check if array has two numbers A and B where A % B = 0
     * @Hint: Should check every pair of number, array[i] vs. array[j], i != j *
     */
    static boolean hasDivisor(int[] numbers) {
        // Add your code here
        return false;
    }
}