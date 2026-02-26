import java.util.Random;
import java.util.Scanner;

public class bt1 {
    static Scanner sc = new Scanner(System.in);
    static Random rd = new Random();
    public static int[] input(int n){
        int[] a= new int[n];
        for(int i=0; i<n; i++) 
            a[i]=sc.nextInt();
        return a;
    }
    public static int find_nx(int[] a,int x){
        int count=0;
        for(int i:a){
            if(x==i)
                count++;
        }
        return count;
    }
    public static void common_number(int[] a){
        // int max=find_nx(a, a[0]);
        int max=0;
        int num=a[0];
        int min=a[0];
        for(int i=0;i<a.length;i++){
            int k= find_nx(a,a[i]);
            if(max<=k){
                if(max==k){
                    if(min>a[i]) min=a[i];
                }
                max=k;
                if(max>num) min=a[i];
                num=max;
            }
        }
        System.out.println(min+" "+max+" ");
        
    }
    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] arr = input(n);
        common_number(arr);
    }
}
