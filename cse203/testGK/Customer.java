import java.util.ArrayList;

public class Customer {
    String name;
    String email;
    ArrayList<CartItem> cart;
    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
        this.cart = new ArrayList<>();
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public ArrayList<CartItem> getCart() {
        return cart;
    }
    public void addToCart(CartItem cartItem){
        for(CartItem t:cart){
            if(t.equals(cartItem)){
                t.setQuantity(t.getQuantity()+Math.max(cartItem.getQuantity(),0));
                return;
            }
        }
        cart.add(cartItem);

        // for(CartItem t:cart){
        //     if(t.equals(cartItem)){
        //         if(t.getQuantity()==-1 || cartItem.getQuantity()==-1){
        //             t.setQuantity(-1);
        //             return;
        //         }
        //         else{
        //             t.getObject().restock(t.getQuantity());
        //             t.setQuantity(t.getObject().purchase(t.getQuantity()+cartItem.getQuantity()));
        //             return;
        //         }
        //     }
        // }
        // cart.add(cartItem);
    }
    public void removeFromCart(CartItem cartItem){
        cart.removeIf(p->p.equals(cartItem));
    }
    public void updateCart(CartItem cartItem, int newquantity){
        cart.forEach(p->{
            if(p.equals(cartItem)){
                if(p.getQuantity()!=-1){
                    p.getObject().restock(p.getQuantity());
                }
                p.setQuantity(p.getObject().purchase(newquantity));
            }
        });
    }
    public String viewCart(){
        StringBuilder sb = new StringBuilder();
        cart.forEach(p->{
            sb.append(p.getInfo()).append("\n");
        });
        return sb.toString();
    }
    
}
