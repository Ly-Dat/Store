public class CartItem {
    RetailItem item;
    int quantity;
    
    public CartItem(RetailItem item, int quantity) {
        this.item = item;
        this.quantity=item.purchase(quantity);

    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public RetailItem getObject() {
        return item;
    }
    public int getQuantity() {
        return quantity;
    }
    public boolean equals(CartItem anotherCartItem){
        if(item.equals(anotherCartItem.getObject())){
            return true;
        }
        return false;
    }
    public double getTotalPrice(){
        if(quantity!=-1){
            return quantity*item.getPrice();
        }
        return-1;
    }
    public String getInfo(){
        String a ="";
        if(quantity!=-1){
            a+=", quantity: "+quantity+", total price: "+this.getTotalPrice();
        }
        else{
            a+=" not enough quatity";
        }
        return item.getInfo()+a;
    }
    
}
