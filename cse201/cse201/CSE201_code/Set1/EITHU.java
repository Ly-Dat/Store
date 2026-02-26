import java.util.*;
//import java.io.*;

 class EIUTHU {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        String firstPart = sc.nextLine();
        
        String secondPart = sc.nextLine();
        char[] b = secondPart.toCharArray();
        int count = firstPart.length() + secondPart.length();
        int i;
        boolean flag = false;
        for (i = b.length - 1; i >=0; i--) {
            if (firstPart.endsWith(secondPart.substring(0, i + 1)) ) {
                flag = true;
                break;
            }
        }
        if (flag)
            count -= i + 1;

        System.out.println(count);
        sc.close();
    }
}
