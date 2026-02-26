
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class EIDUPBOD2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        LinkedHashMap<String, Date> map = new LinkedHashMap<>();
        
        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            Date date = new Date(sc.nextInt(), sc.nextInt(), sc.nextInt());
            if(map.get(date.toString())==null){
                map.put(date.toString(), date);
            }
            map.get(date.toString()).count();
        }
        ArrayList<Date> list = new ArrayList<>(map.values());
        list.sort((p1, p2)->{
            int year = Integer.compare(p1.year, p2.year);
            int month = Integer.compare(p1.month, p2.month);
            if(year!=0){
                return year;
            }
            if(month!=0){
                return month;
            }
            return Integer.compare(p1.day, p2.day);
        });
        list.forEach((p)->sb.append(p.toString()+" "+p.count+"\n"));
        System.out.println(sb);
    }
    static class Date{
        int day;
        int month;
        int year;
        int count=0;

        public Date(int day, int month, int year) {
            this.day = day;
            this.month = month;
            this.year = year;
        }
        public void count(){
            this.count++;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            if(day<10){
                sb.append("0");
            }
            sb.append(day+"/");
            if(month<10){
                sb.append("0");
            }
            sb.append(month+"/"+year);
            return sb.toString();
        }

    }
}
