
import java.util.Arrays;
import java.util.Scanner;

public class a3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }
        Arrays.sort(arr);
        int count=1;
        sb.append(arr[0]);
        for(int i=1; i<n; i++){
            if(arr[i]-arr[i-1]==1){
                count++;
                if(i==n-1){
                    if(count>=3){
                        sb.append("-"+arr[i]);
                    }
                    else if(count==2){
                        sb.append(" "+arr[i]);
                    }
                }
            }
            else{
                if(count>=3){
                    sb.append("-"+arr[i-1]);
                    count=1;
                }
                else if(count==2){
                    sb.append(" "+arr[i-1]);
                    count=1;
                }
                sb.append(" "+arr[i]);
            }
        }
        System.out.println(sb);
    }
}
