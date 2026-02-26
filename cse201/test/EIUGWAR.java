import java.util.*;
import java.util.LinkedList;

public class EIUGWAR {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int numShip = sc.nextInt();
        int numRegion = sc.nextInt();
        HashMap<Integer, Ship> map = new HashMap<>();
        ArrayList<Store> list = new ArrayList<>();
        for(int i=0; i<numShip; i++){
            int id = sc.nextInt();
            long dame = sc.nextLong();
            if(map.containsKey(id)){
                dame=Math.max(dame, map.get(id).dame);
            }
            Ship ship = new Ship(id, dame);
            map.put(id, ship);
        }
        for(int i=0; i<numRegion; i++){
            int region = sc.nextInt();
            int num = sc.nextInt();
            Queue<Ship> team1 = new LinkedList<>();
            Queue<Ship> team2 = new LinkedList<>();
            for(int j=0; j<num; j++){
                int id = sc.nextInt();
                if(map.containsKey(id)){
                    if(id<0){
                        team2.add(map.get(id));
                    }
                    else{
                        team1.add(map.get(id));
                    }
                }
            }
            int result = war(team1, team2);
            Store st = new Store(region, result);
            list.add(st);
        }
        list.sort((p1,p2)->{
            return Integer.compare(p1.region, p2.region);
        });
        list.forEach(p->sb.append(p).append("\n"));
        System.out.println(sb);
    }
    static int war( Queue<Ship> team1,  Queue<Ship> team2){
        while(!team1.isEmpty() && !team2.isEmpty()){
            if (team1.peek().dame > team2.peek().dame) {
                team2.poll();
            } else if (team1.peek().dame < team2.peek().dame) {
                team1.poll(); 
            } else {
                team1.poll(); 
                team2.poll();
            }
        }
        if(!team1.isEmpty()){
            return 1;
        }
        if(!team2.isEmpty()){
            return 2;
        }
        return 0;
    }
    static class Ship{
        int id;
        long dame;
        public Ship(int id, long dame) {
            this.id = id;
            this.dame = dame;
        }
    }
    static class Store{
        int region;
        int result;
        public Store(int region, int result) {
            this.region = region;
            this.result = result;
        }
        @Override
        public String toString() {
            return region + " " + result;
        }
    }
}
