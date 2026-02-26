import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class EIHPROFIT {

    static InputReader sc = new InputReader(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        var nProducts = sc.nextInt();
        var k = sc.nextInt();

        var listProducts = new ArrayList<Product>(nProducts);
        for (int i = 0; i < nProducts; i++) {
            listProducts.add(new Product(sc.nextInt(), sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }

        listProducts.sort((a, b) -> {
            var compare = Long.compare(b.profit, a.profit);
            return compare == 0 ? a.id - b.id : compare;
        });

        var temp = listProducts.get(k - 1).profit;
        for (Product e : listProducts) {
            if (e.profit >= temp)
                sb.append(e).append("\n");
        }
        System.out.println(sb);
    }

    static class Product {

        int id;
        String name;
        int price;
        int cost;
        int soldQuantity;
        long profit;

        public Product(int id, String name, int price, int cost, int soldQuantity) {

            this.id = id;
            this.name = name;
            this.price = price;
            this.cost = cost;
            this.soldQuantity = soldQuantity;
            calProfit();
        }

        private void calProfit() {
            this.profit = (this.price - this.cost) * (long) this.soldQuantity;
        }

        @Override
        public String toString() {

            StringBuilder sb = new StringBuilder();
            return sb.append(this.id).append(" ").append(this.name).append(" ").append(this.profit).toString();
        }
    }
    static class InputReader {
		StringTokenizer tokenizer;
		BufferedReader reader;
		String token;
		String temp;

		public InputReader(InputStream stream) {
			tokenizer = null;
			reader = new BufferedReader(new InputStreamReader(stream));
		}

		public InputReader(FileInputStream stream) {
			tokenizer = null;
			reader = new BufferedReader(new InputStreamReader(stream));
		}

		public String nextLine() throws IOException {
			return reader.readLine();
		}

		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					if (temp != null) {
						tokenizer = new StringTokenizer(temp);
						temp = null;
					} else {
						tokenizer = new StringTokenizer(reader.readLine());
					}
				} catch (IOException e) {
				}
			}
			return tokenizer.nextToken();
		}

		public double nextDouble() {
			return Double.parseDouble(next());
		}

		public int nextInt() {
			return Integer.parseInt(next());
		}

		public long nextLong() {
			return Long.parseLong(next());
		}
	}
}
