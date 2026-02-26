import java.util.Scanner;

class Tk_diem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();
        int num_subject = sc.nextInt();
        for (int i = 0; i < T; i++) {
            String name = sc.next();
            sb.append(name + " ");
            int avr = 0;
            for (int j = 0; j < num_subject; j++) {
                int diem = sc.nextInt();
                sb.append(diem + " ");
                avr += diem;
            }
            avr /= num_subject;
            sb.append(avr+" ");
            int[] table_of_point = {90, 85, 80, 75, 70, 65, 60, 55, 53, 52, 50};
            String[] grades = {"A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "D-"};
            if (avr < 50 && avr >= 0) {
                sb.append("F\n");
            }
            for (int k = 0; k < table_of_point.length; k++) {
                if (avr / table_of_point[k] > 0) {
                    sb.append(grades[k]+"\n");
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}
