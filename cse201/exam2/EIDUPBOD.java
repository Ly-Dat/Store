
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class EIDUPBOD {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        HashMap<LocalDate, Integer> map = new HashMap<>();
        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            int day=sc.nextInt();
            int month = sc.nextInt();
            int year = sc.nextInt();
            LocalDate date = LocalDate.of(year, month, day);
            map.put(date, map.getOrDefault(date, 0)+1);
        }
        ArrayList<LocalDate> list = new ArrayList<>(map.keySet());
        list.sort(null);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        list.forEach(p->sb.append(p.format(formatter)+" "+map.get(p)+"\n"));
        System.out.println(sb);
    }
}