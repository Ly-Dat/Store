
import java.util.Scanner;

public class Letter_grades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] score ={50,52,53,55,60,65,70,75,80,85,90,101};
        String[] grades={"F","D-","D","D+","C-","C","C+","B-","B","B+","A-","A"};
        int point = sc.nextInt();
        for(int i=0; i<score.length; i++){
            if(point<score[i]){
                System.out.println(grades[i]);
                break;
            }
        }
        
    }
}
