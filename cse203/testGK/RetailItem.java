public class RetailItem {
    String name;
    double price;
    int quantityInStock;
    
    public RetailItem(String name, double price, int quantityInStock) {
        this.name = name;
        this.price = price;
        this.quantityInStock = quantityInStock;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public int getQuantityInStock() {
        return quantityInStock;
    }
    public int purchase(int quantity){
        if(quantity<=quantityInStock){
            quantityInStock-=quantity;
            return quantity;
        }
        return -1; 
    }
    public void restock(int quantity){
        quantityInStock+=quantity;
    }
    public String getInfo(){
        return "name: "+name+", price: "+price+", stock available: "+quantityInStock;
    }
    public boolean equals(RetailItem anotherItem){
        if(name.equals(anotherItem.getName())){
            return true;
        }
        return false;
    }
}