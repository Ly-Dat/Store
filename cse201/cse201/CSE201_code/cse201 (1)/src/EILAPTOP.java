import java.util.*;
import java.io.*;

public class EILAPTOP {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        var length = sc.nextInt();
        boolean flag = false;

        var stackQuantity = new Stack<Long>();
        for (int i = 0; i < length; i++) {
            var price = sc.nextInt();
            var quantity = sc.nextInt();
            

        }

        System.out.println(flag ? "Happy Beo" : "Poor Beo");
    }

    static class Laptop {
        long price;
        long quantity;

        public Laptop(long price, long quantity) {
            this.price = price;
            this.quantity = quantity;
        }
    }
}
