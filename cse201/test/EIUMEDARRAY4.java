import java.util.Arrays;
import java.util.Scanner;

public class EIUMEDARRAY4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int testcase = sc.nextInt();
        for (int t = 0; t < testcase; t++) {
            int lenght = sc.nextInt();
            long A = sc.nextLong();
            long P = sc.nextLong();
            int vt = sc.nextInt();
            long[] arr = new long[lenght];
            arr[0] = A * A % P;
            int count = 0;
            for (int i = 1; i < lenght; i++) {
                arr[i] = arr[i - 1] * A % P;
            }
            Arrays.sort(arr);
            for (int i = 1; i < lenght - 1; i++) {
                if(count==vt-1){
                    sb.append(arr[i-1]+"\n");
                }
                if(arr[i]!=arr[i-1]){
                    count++;
                }
            }
        }
        System.out.println(sb);
    }
}
