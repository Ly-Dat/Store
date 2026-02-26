import java.util.*;

public class EIUSEARC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        // Map to store student names and their corresponding IDs
        Map<String, Integer> studentMap = new HashMap<>();

        // Read N student names and assign them IDs
        for (int i = 1; i <= N; i++) {
            String fullName = scanner.nextLine().trim();
            studentMap.put(fullName, i);
        }

        // Process M queries and output the result
        for (int i = 0; i < M; i++) {
            String queryName = scanner.nextLine().trim();
            Integer studentID = studentMap.get(queryName);
            if (studentID != null) {
                System.out.println(studentID);
            } else {
                System.out.println(-1);
            }
        }

        scanner.close();
    }
}
