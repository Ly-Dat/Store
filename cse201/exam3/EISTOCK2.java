import java.util.*;

public class EISTOCK2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        HashMap<Integer, product> map = new HashMap<>();
        
        for(int i=0; i<N; i++){
            String check = sc.next();
            int id = sc.nextInt();
            if(!map.containsKey(id)){
                product pr = new product(id);
                map.put(id, pr);
            }
            map.get(id).addData(check, sc.nextInt(), sc.nextLong(), sc.nextInt());
        }
        ArrayList<product> list = new ArrayList<>(map.values());
        list.sort((p1,p2)->p1.id - p2.id);
        list.forEach(p->{
            if(p.numI!=0){
                sb.append(p).append("\n");
            }
        });
        System.out.println(sb);
    }
    static class product{
        int id;
        String check;
        long numI=0;
        Queue<Data> data = new LinkedList<>();
        public product(int id) {                                                                                                    
            this.id = id;
        }
        public void addData(String check, int num, long price, int time){
            if(check.equals("+")){
                Data d = new Data(num, price, time);
                data.add(d);
                numI+=num;

            }
            else if(numI>=num){
                numI-=num;
                while (num > 0 && !data.isEmpty()) {
                    if (data.peek().num <= num) {
                        num -= data.poll().num;
                    } else {
                        data.peek().num -= num;
                        break;
                    }
                }
            }
        }
        public long getAvr(){
            if(numI==0){
                return 0;
            }
            long sum = 0;
            for(var t : data){
                sum+=t.getTotal();
            }
            return sum/numI;
        }

        @Override
        public String toString() {
            return id + " " + numI + " " + getAvr() + " " + data.peek().time;
        }
        

    }
    static class Data{
        int time;
        int num;
        long price;
        public Data(int num, long price, int time) {
            this.time = time;
            this.num = num;
            this.price = price;
        }
        public long getTotal(){
            return num*price;
        }
        
    }
}
