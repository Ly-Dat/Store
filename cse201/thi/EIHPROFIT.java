
import java.util.ArrayList;
import java.util.Scanner;

public class EIHPROFIT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int k = sc.nextInt();
        ArrayList<Item> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            Item item = new Item(sc.nextInt(), sc.next());
            item.addData(sc.nextLong(), sc.nextLong(), sc.nextInt());
            list.add(item);
        }
        list.sort((p1,p2)->{
            int a = Long.compare(p2.profit, p1.profit);
            if(a!=0){
              return a;  
            }
            return Integer.compare(p1.id, p2.id);
        });
        if(list.size()<k){
            list.forEach(p->sb.append(p).append("\n"));
        }
        else{
            long end = list.get(k-1).profit;
            for(int i=0; i<list.size(); i++){
                if(list.get(i).profit<end){
                    break;
                }
                sb.append(list.get(i)).append("\n");
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
        public void addData(long price, long cost,int quantity){
            profit = (price-cost)*quantity;
        }
        @Override
        public String toString() {
            return  id + " " + name + " " + profit;
        }
        
    }
}
