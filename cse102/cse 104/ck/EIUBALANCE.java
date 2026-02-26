import java.util.Scanner;

public class EIUBALANCE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int month = sc.nextInt();
        double sum = 0;
        long[] array_money= new long[month];

        for(int i =0; i<month; i++){
            array_money[i]=sc.nextLong();
        }
        double money_spend = sc.nextLong();
        double f = sc.nextDouble()/1200;
        double r= sc.nextDouble()/1200;

        for(int i =0; i<month; i++){
            sum+=array_money[i];
            sum-=money_spend;
            sum*=(1+f);
            money_spend*=(1+r);
        }
        for(int i =0; i<month; i++){
            sum-=money_spend;
            sum*=(1+f);
            money_spend*=(1+r);
        }

        if(sum<0){
            System.out.println(0);
        }
        else{
            System.out.println(Math.round(sum));
        } 
    }
}
