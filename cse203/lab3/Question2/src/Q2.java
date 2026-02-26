import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RetailItem2 retailItem1 = new RetailItem2("Item #1: Jacket", 12 , 59.95);
        RetailItem2 retailItem2 = new RetailItem2("Item #2: Designer Jeans", 40 , 34.95);
        RetailItem2 retailItem3 = new RetailItem2("Item #3: Shirt", 20 , 24.95);
        
        RetailItem2 retailItem = retailItem1;

        System.out.print("enter quanlity of item: ");
        int quantity = sc.nextInt();
        if(quantity<=retailItem.unitsOnHand){
            CashRegister cashRegister = new CashRegister(retailItem1, quantity);
            retailItem.setUnitsOnHand(retailItem.unitsOnHand-quantity);
            System.out.println(cashRegister);
        }
        else{
            System.out.println("no enough quantity");
        }
        

        
    }
}
