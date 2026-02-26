import java.util.Scanner;

class EIUBALANCE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int month = sc.nextInt();

        double money_bank=0;
        long[] array_money= new long[month];

        for(int i =0; i<month; i++){
            array_money[i]=sc.nextLong();
        }
        double money_spend = sc.nextLong();
        double inflation_rate = sc.nextDouble()/1200;
        double interest_rate = sc.nextDouble()/1200;

        for(int i =0; i<month; i++){
            money_bank+=array_money[i];
            money_bank-=money_spend;
            money_bank*=(1+inflation_rate);
            money_spend*=(1+interest_rate);
        }
        for(int j =0; j<month; j++){
            money_bank-=money_spend;
            money_bank*=(1+inflation_rate);
            money_spend*=(1+interest_rate);
        }
        if(money_bank<0){
            System.out.println(0);
        }
        else{
            System.out.println(Math.round(money_bank));
        } 
    }
}
