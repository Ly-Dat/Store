import java.util.Random;
import java.util.Scanner;

public class Problem4 {
    public static void main(String[] args) {
        Random rd = new Random();
        Scanner sc = new Scanner(System.in);

        //Scanner input

        // System.out.println("annual interest rate: ");
        // double annualInterest = sc.nextDouble();
        // System.out.println("starting balance: ");
        // double startBalance = sc.nextDouble();
        // System.out.println("number of months that have passed: ");
        // int numberMonths = sc.nextInt();
        // SavingsAccount savingsAccount = new SavingsAccount(annualInterest, startBalance);
        // for(int i=0; i<numberMonths; i++){
        //     System.out.println("amount deposited month "+ (i+1) +": ");
        //     savingsAccount.deposit(sc.nextDouble());
        //     System.out.println("amount withdrawn: ");
        //     savingsAccount.withdrawal(sc.nextDouble());
        //     savingsAccount.calculateInterest();
        // }



        // random input
        
        double annualInterest = rd.nextDouble(0,1);
        System.out.println("annual interest rate: "+annualInterest);
        double startBalance = rd.nextDouble(1000);
        System.out.println("starting balance: "+startBalance);
        int numberMonths = rd.nextInt(12);
        System.out.println("number of months that have passed: "+numberMonths);
        SavingsAccount savingsAccount = new SavingsAccount(annualInterest, startBalance);
        System.out.println();
        for(int i=0; i<numberMonths; i++){
            double deposit= rd.nextDouble(0,15);
            System.out.println("amount deposited month "+ (i+1) +": "+deposit);
            savingsAccount.deposit(deposit);
            double withdrawn = rd.nextDouble(0,15);
            System.out.println("amount withdrawn: "+withdrawn);
            savingsAccount.withdrawal(withdrawn);
            savingsAccount.calculateInterest();
        }
        System.out.println();
        System.out.println(savingsAccount.toString());
    }
}
