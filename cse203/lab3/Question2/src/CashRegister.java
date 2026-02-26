
public class CashRegister {

    RetailItem2 retailItem2;
    int quanlity;

    public CashRegister(RetailItem2 retailItem2, int quanlity) {
        this.retailItem2 = retailItem2;
        this.quanlity = quanlity;
    }

    public double getSubtotal() {
        return retailItem2.getPrice() * quanlity;
    }

    public double getTax() {
        double tax = getSubtotal() * 6 / 100;
        return tax;
    }

    public double getTotal() {
        return getSubtotal() + getTax();
    }

    @Override
    public String toString() {
        return "sale’s subtotal: " + getSubtotal() + ", amount of sales tax: " + getTax() + ", total: " + getTotal();
    }

}
