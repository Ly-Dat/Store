

public class TestScores {
    private int[] arr;

    public TestScores(int[] arr) {
        this.arr = arr;
    }
    public double getAvg() throws InvalidTestScore{
        double sum=0;
        for(int t: arr){
            if(t>100 || t<0){
                // throw new IllegalArgumentException(t+" is error");
                throw new InvalidTestScore(t+" is error");
            }
            else{
                sum+=t;
            }   
        } 
        return sum/arr.length;
    }
}
