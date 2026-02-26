
import java.util.Arrays;
import java.util.Scanner;

public class EIPAGES {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int[] book = new int[n];
        for(int i=0; i<n; i++){
            book[i]=sc.nextInt();
        }
        Arrays.sort(book);
        sb.append(book[0]);
        int count =1;
        for(int i=1; i<book.length; i++){
            if(book[i]-book[i-1]==1){
                count++;
                if(i==n-1){
                    if(count>=3){
                        sb.append("-"+book[i]);
                    }
                    else if(count==2){
                        sb.append(" "+book[i]);
                    }
                }
            }
            else{
                if(count>=3){
                    sb.append("-"+book[i-1]);
                    count=1;
                }
                else if(count==2){
                    sb.append(" "+book[i-1]);
                    count=1;
                }
                sb. append(" "+book[i]);
            }
        }
        System.out.println(sb);
    }
}
