
public class PreferredCustomer {
    double amountPurchases;
    int[] moneyLevel={500, 1000, 1500, 2000};
    int[] discount = {5, 6, 7, 10};
    Customer customer;
    public PreferredCustomer(double amountPurchases, Customer customer) {
        this.amountPurchases = amountPurchases;
        this.customer = customer;
    }
    public double getDiscount(){
        double level =0;
        for(int i=0; i<discount.length; i++){
            if(amountPurchases>=moneyLevel[i]){
                level = discount[i];
            }
        }
        return level/100*amountPurchases;
    }
    @Override
    public String toString() {
        return customer + "amount purchases: "+amountPurchases+", discount: "+getDiscount();
    }
    
}
