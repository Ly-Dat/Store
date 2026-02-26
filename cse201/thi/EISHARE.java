
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class EISHARE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int m = sc.nextInt();
        HashMap<String, Market> map = new HashMap<>();
        for(int i=0; i<n; i++){
            String status = sc.next();
            String name = sc.next();
            if(!map.containsKey(name)){
                map.put(name, new Market(name));
            }
            map.get(name).addData(status, sc.nextInt(), sc.nextLong());
        }
        ArrayList<Market> list = new ArrayList<>(map.values());
        list.sort((p1,p2)->{
            int a = Double.compare(p2.money, p1.money);
            if(a!=0){
                return a;
            }
            return p1.name.compareTo(p2.name);
        });
        if(list.size()<=m){
            list.forEach(p->sb.append(p).append("\n"));
        }
        else{
            double end = list.get(m).money;
            for(int i=0; i<list.size(); i++){
                if(Double.compare(list.get(i).money, end)==0){
                    break;
                }
                sb.append(list.get(i)).append("\n");
            }
        }
        System.out.println(sb);
    }
    static class Market{
        String name;
        double money=0;

        public Market(String name) {
            this.name = name;
        }
        public void addData(String status, int quantity, long money){
            if(status.equals("B")){
                this.money-=quantity*money;
            }
            else{
                this.money = this.money*(1.001) + (quantity*money);
            }
        }

        @Override
        public String toString() {
            return name +" "+(long)money;
        }
        
    }
}
