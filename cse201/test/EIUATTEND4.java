
import java.util.ArrayList;
import java.util.Scanner;

public class EIUATTEND4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int numberAbsent = (int)Math.round((double)N*0.1);
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            list.add(sc.nextInt());
        }
        list.sort((p1,p2)->p2-p1);
        int k = (int)(M*0.2);
        while(k<=list.get(0)){
            int count=0;
            for(int t : list){
                if(t>=k){
                    count++;
                }
            }
            if(count<=numberAbsent){
                break;
            }
            k++;
        }
        System.out.println(k);
        
    }
    
}

