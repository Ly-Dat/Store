import java.util.Random;
import java.util.Scanner;

public class test4 {
    static Scanner sc = new Scanner(System.in);
    static Random rd= new Random();
    public static int[] input(){
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0; i<n;i++) a[i]= rd.nextInt(100);
        return a;
    }
    public static void output(int[] a){
        for(int i=0; i<a.length; i++) System.out.print(a[i]+" ");
    }
    public static boolean findx(int[] a, int x, int k){
        boolean flag=false;
        for(int i=0; i<k; i++){
            if(a[i]==x) flag=true;
        }
        return flag;
    }
    public static int[] inputset(){
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i =0; i<n; i++){
            int t=rd.nextInt(20);
            while(findx(arr, t, i)){
                t=rd.nextInt(20);
            }
            arr[i]=t;
        }
        return arr;
    }
    public static boolean findx(int[] a, int x){
        boolean flag=false;
        for(int i=0; i<a.length; i++){
            if(a[i]==x) flag=true;
        }
        return flag;
    }
    public static void giao(int[] a, int[] b){
        for(int k:a) System.out.print(k+" ");
        for(int i:b){
            if(!findx(a,i)) System.out.print(i+" ");
        }
    }
    public static int[] inputrandom(){
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0; i<n;i++) a[i]= rd.nextInt(100)-40;
        return a;

    }
    public static void find_DNN(int[] a){
        int min=-1;
        boolean flag=true;
        for(int i:a){
            if(i>0){
                if(flag){
                    min=i;
                    flag=false;
                }
                if(min>i) min=i;
                
            }
        }
        System.out.println(min);
    }
    public static void main(String[] args) {
        int[] array=inputrandom();
        output(array);
        System.out.println();
        find_DNN(array);
    }
}
