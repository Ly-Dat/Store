
import java.util.ArrayList;
import java.util.Scanner;

public class EIHPROFIT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        System.out.println(sb);
        int product = sc.nextInt();
        int unique = sc.nextInt();
        ArrayList<Items> arr = new ArrayList<>();
        for(int i=0; i<product; i++){
            Items item = new Items(sc.nextLong(), sc.next());
            item.addData(sc.nextLong(), sc.nextLong(), sc.nextLong());
            arr.add(item);
        }
        arr.sort((p1,p2)->{
            if (p2.totalProfit != p1.totalProfit) {
                return Long.compare(p2.totalProfit, p1.totalProfit);
            }
            return Long.compare(p1.id, p2.id);
        });
        int i=0;
        if(unique>arr.size()){
            arr.forEach(p->sb.append(p).append("\n"));
        }
        else{
            while(i<unique){
                sb.append(arr.get(i)).append("\n");
                i++;
            }
            while (i < arr.size() && arr.get(i).totalProfit == arr.get(i - 1).totalProfit) {
                sb.append(arr.get(i)).append("\n");
                i++;
            }
        }

        System.out.println(sb);

    }
    static class Items{
        long id;
        String name;
        long totalProfit;
        public Items(long id, String name) {
            this.id = id;
            this.name = name;
        }
        public void addData (long price, long cost, long quantity){
            this.totalProfit = (price-cost)*quantity;
        }
        @Override
        public String toString() {
            return id + " " + name + " " + totalProfit;
        }
        
    }
}
