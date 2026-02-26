

public class Q8_9 {
    public static void main(String[] args) {
        int[] scores = {90,80,100,102,90};
        TestScores testScores = new TestScores(scores);
        try {
            System.out.println(testScores.getAvg());
        } catch (InvalidTestScore e) {
            System.out.println(e.getMessage());
        }
        
    }
}
