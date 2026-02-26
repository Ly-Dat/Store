import java.util.Scanner;

/**
 * H
 */
public class H {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,m; n=sc.nextInt(); m=sc.nextInt();
        String[][] arr = new String[n][m];
        for(int i=1; i<=n; i++){
            String t = sc.nextLine();
            for(int j=1; j<=m; j++){
                arr[i][j]=t.substring(j);
            }
        }
        System.out.println(arr[2][1]);
    }
}