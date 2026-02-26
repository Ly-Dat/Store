import java.util.Scanner;

public class test3 {
    public static boolean nt(int n){
        if(n<2) return false;
        for(int i = 2; i<Math.sqrt(n);i++){
            if(n%i==0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count =0;
        while(n!=0){
            if(nt(n%10)) count++;
            n/10;
        }
    }
}
