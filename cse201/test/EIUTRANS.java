import java.util.HashMap;
import java.util.Scanner;

class EIUTRANS {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int wordSend = sc.nextInt();
        int words = sc.nextInt();
        String noValue = sc.nextLine();
        HashMap<String, String> map = new HashMap<>();
        for(int i=0; i<words; i++){
            String[] part = sc.nextLine().split(" ");
            map.put(part[0], part[1]);
        }
        String[] Words = sc.nextLine().split(" ");
        for(String word : Words){
            String a = map.get(word);
            if(a.length() < word.length()){
                sb.append(a+" ");
            }
            else{
                sb.append(word+" ");
            }
        }
        System.out.println(sb);
    }
}
