import java.util.*;

public class EIUGIFT1 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
    
        int[] gifts = new int[n];
        for (int i = 0; i < n; i++) {
            gifts[i] = scanner.nextInt();
        }
        
        int[] papers = new int[m];
        for (int j = 0; j < m; j++) {
            papers[j] = scanner.nextInt();
        }
        
        Arrays.sort(gifts);
        Arrays.sort(papers);
        
        int maxWrappable = maximumWrappableGifts(n, m, gifts, papers);
        
        System.out.println(maxWrappable);
        
        scanner.close();
    }
    
    public static int maximumWrappableGifts(int n, int m, int[] gifts, int[] papers) {
        int giftIndex = 0;
        int paperIndex = 0;
        int wrappedCount = 0;
        
        while (giftIndex < n && paperIndex < m) {
            if (papers[paperIndex] >= 2 * gifts[giftIndex] && papers[paperIndex] <= 3 * gifts[giftIndex]) {
                wrappedCount++;
                giftIndex++;
                paperIndex++;
            } else if (papers[paperIndex] < 2 * gifts[giftIndex]) {
                paperIndex++;
            } else {
                giftIndex++;
            }
        }
        
        return wrappedCount;
    }
}
