public class Triangle implements Shape{
    private double baseEdge;
    private double height;
    
    public Triangle(double baseEdge, double height) {
        this.baseEdge = baseEdge;
        this.height = height;
    }
    public void draw(){
        System.out.println("draw rectangle");
    }
    public double calculateArea(){
        return 0.5*baseEdge*height;
    }
}
