import java.util.*;

public class EIPAGES {

    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        int totalPages = sc.nextInt();
        int[] pages = getPages(totalPages);
        Arrays.sort(pages);
        getResult(pages);
        System.out.println(sb);
    }

    private static void getResult(int[] pages) {
        int start = pages[0];
        int end = pages[0];
       
       for (int i = 1; i < pages.length; i++) {
            if (pages[i] == end + 1) {
                end = pages[i];
            } else {
                if (start == end) {
                    sb.append(start).append(" ");
                } else if (end - start == 1) {
                   sb.append(start).append( " ").append(end).append(" ");
                } else {
                   sb.append(start).append("-").append(end).append(" ");
                }
                start = pages[i];
                end = pages[i];
            }
        }
        if (start == end) {
            sb.append(start);
        } else if (end - start == 1) {
             sb.append(start).append( " ").append(end);
        } else {
             sb.append(start).append("-").append(end);
        }
    }

    private static int[] getPages(int totalPages) {
        int[] pages = new int[totalPages];
        for (int i = 0; i < pages.length; i++) {
            pages[i] = sc.nextInt();
        }
        return pages;
    }
}