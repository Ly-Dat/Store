
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
            int day = sc.nextInt();
            int month = sc.nextInt();
            int year = sc.nextInt();
            LocalDate lc = LocalDate.of(year, month, day);
            map.put(lc,map.getOrDefault(lc, 0)+1);
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        ArrayList<LocalDate> list = new ArrayList<>(map.keySet());
        list.sort(null);
        list.forEach(p->sb.append(formatter.format(p)+" "+map.get(p)+"\n"));
        System.out.println(sb);
    }
}
