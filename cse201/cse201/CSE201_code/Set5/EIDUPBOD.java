import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

 class EIDUPBOD {

    public static void main(String[] args) throws IOException {
        // Đọc dữ liệu từ đầu vào
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim()); // Đọc số lượng học sinh
        
        // Sử dụng TreeMap để lưu số lượng học sinh cho mỗi ngày sinh
        Map<LocalDate, Integer> birthdayMap = new TreeMap<>();
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d M yyyy");
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine().trim());
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());
            
            // Tạo đối tượng LocalDate
            LocalDate date = LocalDate.of(year, month, day);
            
            // Cập nhật số lượng học sinh cho ngày sinh này
            birthdayMap.put(date, birthdayMap.getOrDefault(date, 0) + 1);
        }
        
        // Xuất kết quả
        StringBuilder sb = new StringBuilder();
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        for (Map.Entry<LocalDate, Integer> entry : birthdayMap.entrySet()) {
            sb.append(entry.getKey().format(outputFormatter)).append(' ').append(entry.getValue()).append('\n');
        }
        
        // In kết quả ra màn hình
        System.out.print(sb.toString());
    }
}
