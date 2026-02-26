import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

import java.io.IOException;

public class New {
    public static void main(String[] args) {

        int n = sc.nextInt();
        int k = sc.nextInt();
        ArrayList<Item> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String id = sc.next();
            String name = sc.next();
            long price = sc.nextLong();
            Long cost = sc.nextLong();// 10 8 3
            Long quantity = sc.nextLong();
            long profit = (price - cost) * quantity;
            list.add(new Item(id, name, profit));
        }
        Collections.sort(list, new Comparator<Item>() {

            @Override
            public int compare(New.Item o1, New.Item o2) {
               if (o1.getProfit() != o2.getProfit()) {
                    return Long.compare(o2.getProfit(), o1.getProfit());
               }
               return o1.getId().compareTo(o2.getId());
            }
            
        });
        long val = list.get(k - 1).getProfit();
        for (int i = 0; i < n; i++) {
          if (list.get(i).getProfit() >= val) {
            sb.append(list.get(i).toString()).append("\n");
            
          } else{
            break;
          }
        }
       
        
       
        System.out.println(sb);

    }

    static class Item {
        String id;
        String name;
        long profit;

        public Item(String id, String name, long profit) {
            this.id = id;
            this.name = name;
            this.profit = profit;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public long getProfit() {
            return profit;
        }

        @Override
        public String toString() {
            return id + " " + name + " " + profit;
        }

    }

    static StringBuilder sb = new StringBuilder();
    static InputReader sc = new InputReader(System.in);

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
