import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class path {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int q = scanner.nextInt();

        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            graph[v].add(u);
        }

        StringBuilder results = new StringBuilder();

        for (int i = 0; i < q; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            if (graph[a].contains(b)) {
                results.append("Y\n");
                continue;
            }

            boolean found = false;
            for (int k : graph[a]) {
                if (graph[k].contains(b)) {
                    found = true;
                    break;
                }
            }
            results.append(found ? "Y\n" : "N\n");
        }

        System.out.print(results);
    }
}