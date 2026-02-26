import java.util.*;

public class YogurtSale {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        var nTestcases = sc.nextInt();

        for (int i = 0; i < nTestcases; i++) {
            getResult(sc.nextInt(), sc.nextInt(), sc.nextInt());
        }
        System.out.println(sb);
    }

    private static void getResult(int nYogurts, int normalPrice, int proPrice) {
        if (normalPrice << 1 < proPrice){
            sb.append( normalPrice * nYogurts);
        }else {
            sb.append((nYogurts >> 1) * proPrice + (nYogurts %2) *normalPrice);
        }
        sb.append("\n");
    }

}
