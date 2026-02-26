import java.util.Scanner;

public class Luong {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  

        for (int i = 0; i < n; i++) {
            double pay = sc.nextDouble();  
            double salary = pay/ 0.9;  
            double tax = salary - pay;  
            System.out.printf("%.2f\n", tax);  
        }
    }
}