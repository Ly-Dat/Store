package abstract_demo;

public class RichStudent extends Student{
    private double property;

    public RichStudent(String name, double score, double property) {
        super(name, score);
        this.property = property;
    }

    @Override
    public void diHoc() {
        System.out.println("di hoc bang may bay truc thang");
    }
    

}
