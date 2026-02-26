import java.util.Arrays;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        for (int i = 0; i < testcase; i++) {
            int m = sc.nextInt();
            int[] arr_num = new int[m];
            int n = sc.nextInt();
            for (int j = 0; j < m; j++)
                arr_num[j] = sc.nextInt();
            Arrays.sort(arr_num);
            boolean flag = true;
            boolean checkN = false;
            if (arr_num[0] > 1 || m<n) {
                System.out.println("No");
                continue;
            }
            int VT_number1=0;
            if(arr_num[0]==0){
                for(int k = 0; k<arr_num.length;k++){
                    if(arr_num[k]==1){
                        VT_number1=k;
                        break;
                    }
                        
                }
            }
            if (arr_num[VT_number1] == 1) {
                for (int k = 0; k < arr_num.length; k++) {
                    if (k>0 && arr_num[k] > arr_num[k - 1] + 1) {
                        flag = false;
                        break;
                    }
                    if (arr_num[k] == n){
                        checkN=true;
                        break;
                    }
                        
                }
            }
            if(m<n)
                flag=false;
            if(flag && checkN)
                System.out.println("Yes");
            else
                System.out.println("No");

        }
    }
}
