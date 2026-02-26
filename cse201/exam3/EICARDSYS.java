
import java.util.*;

public class EICARDSYS {
    static double sumDiscount =0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<String, ArrayList<Long>> map = new HashMap<>();
        for(int i=0; i<n; i++){
            String id = sc.next();
            if(!map.containsKey(id)){
                map.put(id, new ArrayList<>());
            }
            map.get(id).add(sc.nextLong());
        }
        map.forEach((key, val)->{
            sumDiscount+=memberCard(val);
        });
        System.out.println(sumDiscount);


    }
    static double memberCard(ArrayList<Long> arr){
        int mil = 1000000;
        long[] arr_money = {0, 1*mil, 20*mil, 50*mil, 200*mil, Long.MAX_VALUE};
        double[] rate = {0, 0.02, 0.03, 0.05, 0.07};
        long sum=0;
        int rank=0;
        double discount=0;
        for(int i=0; i<arr.size(); i++){
            long money = arr.get(i);
            sum+=money;
            discount+=money*rate[rank];
            while (true) { 
                if(sum>=arr_money[rank+1]){
                    rank++;
                }
                else{
                    break;
                }
            }
        }
        return discount;
    }
}
