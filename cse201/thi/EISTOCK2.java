import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class EISTOCK2 {
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
            map.get(id).addData(check, sc.nextInt(), sc.nextLong(), sc.nextInt());
        }
        ArrayList<Item> list = new ArrayList<>(map.values());
        list.sort((p1,p2)->p1.id-p2.id);
        list.forEach(p->{
            if(p.numI !=0){
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
        Queue<Data> queue = new LinkedList<>();
        public Item(int id) {
            this.id = id;
        }
        public void addData(String check, int quatity, long price, int time){
            if(check.equals("+")){
                queue.add(new Data(time, quatity, price));
                numI+= quatity;
            }
            else if(quatity<=numI){
                numI-=quatity;
                while(quatity>0 && !queue.isEmpty()){
                    if(quatity >= queue.peek().quantity){
                        quatity-= queue.poll().quantity;
                    }
                    else{
                        queue.peek().quantity -= quatity;
                        break;
                    }
                }
            }
        }
        public double getAvr(){
            double sum = 0;
            for(var t : queue){
                sum+=t.getTotal();
            }
            return sum/numI;
        }
        @Override
        public String toString() {
            return id + " " + numI + " " + (int)getAvr() +" "+ queue.peek().time;
        }
    }
    static class Data{
        int time;
        int quantity;
        long price;
        public Data(int time, int quantity, long price) {
            this.time = time;
            this.quantity = quantity;
            this.price = price;
        }
        public long getTotal(){
            return quantity*price;
        }
    }
}
