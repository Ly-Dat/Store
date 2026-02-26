import java.util.*;
import java.io.*;

class EIUARRAY {
    public class ArrayAlgorithms {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            StringBuilder sb = new StringBuilder();

            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] numbers = new int[n];

            for (int j = 0; j < n; j++) {
                numbers[j] = sc.nextInt();
            }

            for (int i = 0; i < m; i++) {
                String command = sc.next();

                switch (command) {
                    case "findMax":
                        sb.append(findMax(numbers)).append("\n");
                        break;
                    case "findMin":
                        sb.append(findMin(numbers)).append("\n");
                        break;
                    case "average":
                        sb.append(average(numbers)).append("\n");
                        break;
                    case "sum":
                        sb.append(sum(numbers)).append("\n");
                        break;
                    case "countMax":
                        sb.append(countMax(numbers)).append("\n");
                        break;
                    case "sumOddNumber":
                        sb.append(sumOddNumber(numbers)).append("\n");
                        break;
                    case "countEvenNumber":
                        sb.append(countEvenNumber(numbers)).append("\n");
                        break;
                    case "indexOf":
                        sb.append(indexOf(numbers, sc.nextInt())).append("\n");
                        break;
                    case "lastIndexOf":
                        sb.append(lastIndexOf(numbers, sc.nextInt())).append("\n");
                        break;
                    case "findMinDistance":
                        sb.append(findMinDistance(numbers)).append("\n");
                        break;
                    case "isPalindrome":
                        sb.append(isPalindrome(numbers)).append("\n");
                        break;
                    case "contains":
                        sb.append(contains(numbers, sc.nextInt())).append("\n");
                        break;
                    case "hasDuplicated":
                        sb.append(hasDuplicated(numbers)).append("\n");
                        break;
                    default:
                        sb.append(hasDivisor(numbers)).append("\n");
                        break;
                }
            }
            System.out.println(sb);
        }

        static int findMax(int[] numbers) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] > max)
                    max = numbers[i];
            }
            return max;
        }

        static int findMin(int[] numbers) {
            // Add your code here
            return 0;
        }

        static double average(int[] numbers) {
            // Add your code here
            return 0;
        }

        static int sum(int[] numbers) {
            // Add your code here
            return 0;
        }

        /**
         * @Desciption:
         * @Hint: find maximum number in the array, then check which number is
         */
        static int countMax(int[] numbers) {
            // Add your code here
            return 0;
        }

        /**
         * @Desciption: sum all odd numbers in array
         * @Hint: what is odd number, how to check?
         */
        static int sumOddNumber(int[] numbers) {
            // Add your code here
            return 0;
        }

        static int countEvenNumber(int[] numbers) {
            // Add your code here
            return 0;
        }

        static int indexOf(int[] numbers, int value) {
            // Add your code here
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
}
