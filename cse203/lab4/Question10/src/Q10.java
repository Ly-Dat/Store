import java.util.ArrayList;

public class Q10 {
    public static void main(String[] args) {
        ArrayList<Ship> arr = new ArrayList<>();
        arr.add(new Ship("b", "1201"));
        arr.add(new CruiseShip("a", 10));
        arr.add(new CargoShip("c", 4));
        arr.forEach(P->System.out.println(P.toString()));
        
    }
}
