import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

class EIDUPBOD {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        HashMap<LocalDate, Integer> map = new HashMap<>();

        int num = sc.nextInt();
        for (int i = 0; i < num; i++) {
            int day = sc.nextInt();
            int month = sc.nextInt();
            int year = sc.nextInt();
            LocalDate date = LocalDate.of(year, month, day);
            map.put(date, map.getOrDefault(date, 0)+1);
        }
        List<LocalDate> listDate = new ArrayList<>(map.keySet());
        listDate.sort(null);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        for(var key : listDate){
            sb.append(key.format(formatter)+" "+map.get(key)+"\n");
        }
        System.out.println(sb);
        
    }
}
