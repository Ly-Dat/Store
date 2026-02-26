package abstract_demo;

public class SuperRichStudent extends Student{
    private double property;

    public SuperRichStudent(String name, double score, double property) {
        super(name, score);
        this.property = property;
    }

    @Override
    public void diHoc() {
        System.out.println("Di hoc bang tau ngam");
    }
    
}
