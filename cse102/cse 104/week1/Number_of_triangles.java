
import java.util.Arrays;
import java.util.Scanner;

public class Number_of_triangles {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr_edges = new int[N];
        for (int i = 0; i < N; i++) {
            arr_edges[i] = sc.nextInt();
        }
        Arrays.sort(arr_edges);
        int count_num_trian = 0;

        for (int i = N - 1; i >= 2; i--) {
            int edge_right = i - 1;
            int edge_left = 0;
            while (edge_left < edge_right) {
                if (arr_edges[edge_left] + arr_edges[edge_right] > arr_edges[i]) {
                    count_num_trian += edge_right - edge_left;
                    edge_right--;
                } else {
                    edge_left++;
                }
            }
        }
        System.out.println(count_num_trian);
    }
}
