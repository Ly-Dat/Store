
import java.util.Scanner;

public class Every_Number {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        for (int i = 0; i < testcase; i++) {
            int m = sc.nextInt();
            int[] arr_num = new int[m];
            int n = sc.nextInt();

            boolean[] found = new boolean[n + 1];
            //vd n = 5:  0     1     2     3     4     5
            //         false false false false false false 

            boolean flag = true;
            for (int j = 0; j < m; j++) {
                arr_num[j] = sc.nextInt();
                if (arr_num[j] <= n) {

                    found[arr_num[j]] = true;
                    //vd arrNum=3:  0     1     2     3     4     5
                    //             false false false true false false
                    
                }
            }
            for (int j = 1; j <= n; j++) {
                if (!found[j]) {
                    
                    //chạy từ 1 -> 5:
                    //vd found:  0     1      2     3     4     5
                    //          false true  false  true  true  true 
                    //vd found[2]: ra false -> "no" break
                    flag = false;
                    break;
                }
            }

            if (flag) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }
}
