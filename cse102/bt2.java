import java.util.Random;
import java.util.Scanner;

public class bt2 {
    static Scanner sc = new Scanner(System.in);
    static Random rd = new Random();
    public static int[] input(int n){
        int[] a= new int[n];
        for(int i=0; i<n; i++) 
            a[i]=sc.nextInt();
        return a;
    }
    public static int max_even(int[] a){
        boolean flag=true;
        int max=-1;
        for(int i:a){
            if(i%2==0){
                if(flag){
                    max=i;
                    flag=false;
                }
                if(max<i) max=i;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] arr = input(n);
        System.out.println(max_even(arr));
 
    }
}
