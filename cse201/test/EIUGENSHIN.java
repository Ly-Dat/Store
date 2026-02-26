import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class EIUGENSHIN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        int M = sc.nextInt();
        HashMap<String, character> map = new HashMap<>();
        for(int i=0; i<M; i++){
            String name = sc.next();
            character ch = new character(name);
            ch.setDame(sc.nextInt(), sc.nextInt());
            map.put(name, ch);
        }
        for(int i=0; i<N; i++){
            String name = sc.next();
            int hit = sc.nextInt();
            if(map.containsKey(name)){
                map.get(name).attack(hit);
            }
        }
        ArrayList<character> list = new ArrayList<>(map.values());
        list.sort((p1,p2)->{
            int a = Double.compare(p2.avr, p1.avr);
            if(a!=0){
                return a;
            }
            return p1.name.compareTo(p2.name);
        });
        list.forEach(p->sb.append(p).append("\n"));
        System.out.println(sb);
    }
    static class character{
        String name;
        int[] dame = new int[2];
        int count =0;
        double sum = 0;
        double avr = 0;
        public character(String name) {
            this.name = name;
        }
        public void setDame(int normal, int critical){
            dame[0]=normal;
            dame[1]=critical;
        }
        public void attack(int n){
            sum+=dame[n];
            count++;
            avr = sum/count;
        }
        @Override
        public String toString() {
            return name + " " + Math.round(avr);
        }
        
    }
}