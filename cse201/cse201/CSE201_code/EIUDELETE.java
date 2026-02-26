import java.util.*;
//90
public class EIUDELETE {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            numbers.add(scanner.nextInt());
        }

        List<Integer> result = new ArrayList<>();
        for (int num : numbers) {
            if (!isPrime(num)) {
                result.add(num);
            }
        }

        for (int num : result) {
            System.out.print(num + " ");
        }

        scanner.close();
    }

    private static boolean isPrime(int num) {
        if (num < 2) return false;
        if (num == 2 || num == 3) return true;
        if (num % 2 == 0 || num % 3 == 0) return false;
        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) return false;
        }
        return true;
    }
}
