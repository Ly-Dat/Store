
import java.util.Arrays;
import java.util.Scanner;

public class EIULOGFILE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] arr = new double[n];
        for(int i=0; i<n; i++){
            arr[i]=sc.nextLong();
        }
        Arrays.sort(arr);
        long count=0;
        for(int i=0; i<n; i++){
            int a = Arrays.binarySearch(arr, arr[i]+600000+0.00001);
            if(a<0){
                a=~a-1;
            }
            count+=a-i;
        }
        System.out.println(count);
    }
}
