
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class EISTOCK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        HashMap<Integer, Item> map = new HashMap<>();
        for(int i=0; i<n; i++){
            String check = sc.next();
            int id = sc.nextInt();
            if(!map.containsKey(id)){
                map.put(id, new Item(id));
            }
            map.get(id).addData(check, sc.nextInt(), sc.nextLong());
        }
        ArrayList<Item> list = new ArrayList<>(map.values());
        list.sort((p1,p2)->p1.id-p2.id);
        list.forEach(p->{
            if(p.moneyO != 0 || p.moneyI!=0){
                sb.append(p).append("\n");
            }
        });
        System.out.println(sb);
    }
    static class Item{
        int id;
        long moneyI=0;
        int numI=0;
        long moneyO=0;
        public Item(int id) {
            this.id = id;
        }
        public void addData(String check, int quatity, long price){
            if(check.equals("+")){
                numI+=quatity;
                moneyI+=quatity*price;
            }
            else if(quatity<=numI){
                numI-=quatity;
                moneyO+=quatity*price;
            }
        }
        @Override
        public String toString() {
            return id + " " + moneyI + " " + moneyO;
        }
        
    }
}
