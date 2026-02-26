import java.util.*;
import java.io.*;

public class EICARDSYS {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        var nTransaction = sc.nextInt();
        var mapCustomer = new HashMap<String, Customer>();
        long totalDiscount = 0;
        for (int i = 0; i < nTransaction; i++) {
            String id = sc.next();
            long price = sc.nextLong();
            Customer customer = mapCustomer.get(id);
            if (customer == null) {
                mapCustomer.put(id, new Customer(id, price));
            } else {
                if (customer.totalPurchase < 1_000_000){

                }
                else if (customer.totalPurchase < 20_000_000) {
                    totalDiscount += price << 1 ;
                } else if (customer.totalPurchase < 50_000_000) {
                    totalDiscount += (price  << 1) +  price;
                } else if (customer.totalPurchase < 200_000_000) {
                    totalDiscount += (price << 2) + price;
                } else if (customer.totalPurchase < Long.MAX_VALUE) {
                    totalDiscount += (price << 3) - price;
                }
                customer.totalPurchase += price;
            }
        }
        System.out.println(totalDiscount/ 100.0);
    }

    static class Customer {
        long totalPurchase;
        String id;

        public Customer(String id, long price) {
            this.id = id;
            this.totalPurchase = price;
        }
    }

    // static class InputReader {
    //     StringTokenizer tokenizer;
    //     BufferedReader reader;
    //     String token;
    //     String temp;

    //     public InputReader(InputStream stream) {
    //         tokenizer = null;
    //         reader = new BufferedReader(new InputStreamReader(stream));
    //     }

    //     public InputReader(FileInputStream stream) {
    //         tokenizer = null;
    //         reader = new BufferedReader(new InputStreamReader(stream));
    //     }

    //     public String nextLine() throws IOException {
    //         return reader.readLine();
    //     }

    //     public String next() {
    //         while (tokenizer == null || !tokenizer.hasMoreTokens()) {
    //             try {
    //                 if (temp != null) {
    //                     tokenizer = new StringTokenizer(temp);
    //                     temp = null;
    //                 } else {
    //                     tokenizer = new StringTokenizer(reader.readLine());
    //                 }
    //             } catch (IOException e) {
    //             }
    //         }
    //         return tokenizer.nextToken();
    //     }

    //     public double nextDouble() {
    //         return Double.parseDouble(next());
    //     }

    //     public int nextInt() {
    //         return Integer.parseInt(next());
    //     }

    //     public long nextLong() {
    //         return Long.parseLong(next());
    //     }
    // }
}
