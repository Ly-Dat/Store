import java.util.*;

public class EIUPH009 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[a.length];
        for(int i =0;i<a.length;i++){
           a[i]= sc.nextInt();}
        for(int i =0;i<b.length;i++){
            b[i]=a[n-1];
            n-=1; } 
        if (Istrue(a, b)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
     sc.close();
    }
    public static boolean Istrue(int[] a, int[]b){
        for(int i =0;i<a.length;i++){
            if(a[i]!=b[i]){
                return false;
            }
        }
        return true;
    }
    public static void output(int n, int[] a, int[]b){
        for(int i =0;i<a.length;i++){
            System.out.print(a[i]+" "); 
            System.out.println(b[i]+" ");}
    }
    
}