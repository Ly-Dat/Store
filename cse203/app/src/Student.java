public class Student {
    static String name;
    static int score;
    public Student (String name, int score) {
        this.name=name;
        this.score=score;
    }
    public int getScore(){
        return score;
    }
    public String getName(){
        return name;
    }
    @Override
    public String toString() {
        return "name: "+name+", score: "+score;
    }
    
    
}
