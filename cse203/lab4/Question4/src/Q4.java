

public class Q4 {

    public static void main(String[] args) {
        double grammar=10;
        double spelling=20;
        double correctLength=20;
        double content=30;

        //nhập sai điểm
        // System.out.println("nhap diem: ");
        // while (true) {
        //     grammar = sc.nextDouble();
        //     spelling = sc.nextDouble();
        //     correctLength = sc.nextDouble();
        //     content = sc.nextDouble();
        //     if (grammar <= 30 && spelling <= 20 && correctLength <= 20 && content <= 30) {
        //         break;
        //     }
        //     System.out.println("nhap lai diem: ");
        // }
        if(checkGrade(grammar, spelling, correctLength, content)){
            Essay essay = new Essay(grammar, spelling, correctLength, content);
            System.out.println(essay);
        }
        else{
            System.out.println("error grade");
        }

    }
    static boolean checkGrade(double grammar,double spelling,double correctLength,double content) {
        if (grammar <= 30 && spelling <= 20 && correctLength <= 20 && content <= 30) {
            return true;
        }
        return false;
    }
}   
