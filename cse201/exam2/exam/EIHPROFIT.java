
import java.util.ArrayList;
import java.util.Scanner;

public class EIHPROFIT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        ArrayList<Item> list = new ArrayList<>();
        int n = sc.nextInt();
        int k = sc.nextInt();
        for(int i=0; i<n; i++){
            Item item = new Item(sc.nextInt(), sc.next());
            item.addData(sc.nextLong(), sc.nextLong(), sc.nextLong());
            list.add(item);
        }
        list.sort((p1,p2)->{
            int a= Long.compare(p2.profit,p1.profit);
            if(a!=0){
                return a;
            }
            return Integer.compare(p1.id, p2.id);
        });
        if(k>=n){
            list.forEach(a->sb.append(a.toString()).append("\n"));
        }
        else{
            int i=0;
            while(i<k){
                sb.append(list.get(i).toString()).append("\n");
                i++;
            }
            while(i<n && Long.compare(list.get(i).profit, list.get(i-1).profit)==0){
                sb.append(list.get(i).toString()).append("\n");
                i++;
            }
        }
        System.out.println(sb);
    }
    static class Item{
        int id;
        String name;
        long profit;

        public Item(int id, String name) {
            this.id = id;
            this.name = name;
        }
        public void addData(long price, long cost, long quantity){
            profit =(price-cost)*quantity;
        }

        @Override
        public String toString() {
            return id+" "+name+" "+profit;
        }

    }
}
