import java.io.*;
import java.util.*;

class Product {
    int id;
    String name;
    long price;
    long cost;
    int quantitySold;
    long profit;

    public Product(int id, String name, long price, long cost, int quantitySold) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.cost = cost;
        this.quantitySold = quantitySold;
        this.profit = (price - cost) * quantitySold;
    }
}

 class EEIHPROFIT {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int k = Integer.parseInt(firstLine[1]);
        
        List<Product> products = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] productData = br.readLine().split(" ");
            int id = Integer.parseInt(productData[0]);
            String name = productData[1];
            long price = Long.parseLong(productData[2]);
            long cost = Long.parseLong(productData[3]);
            int quantitySold = Integer.parseInt(productData[4]);
            products.add(new Product(id, name, price, cost, quantitySold));
        }

        products.sort((p1, p2) -> {
            if (p2.profit != p1.profit) {
                return Long.compare(p2.profit, p1.profit);
            } else {
                return Integer.compare(p1.id, p2.id);
            }
        });

        long thresholdProfit = products.get(k - 1).profit;

        StringBuilder sb = new StringBuilder();
       
        for (Product product : products) {
            if (product.profit >= thresholdProfit) {
                sb.append(product.id).append(" ").append(product.name).append(" ").append(product.profit).append("\n");
            }
        }
        
        System.out.print(sb.toString());
    }
}