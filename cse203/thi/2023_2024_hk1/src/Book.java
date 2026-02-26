public class Book {
    private String name;
    private int quantity;
    private String decription;
    public Book(String name, int quantity, String decription) {
        this.name = name;
        this.quantity = quantity;
        this.decription = decription;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDecription() {
        return decription;
    }

    @Override
    public String toString() {
        return name + " " + quantity + " " + decription;
    }
    
}
