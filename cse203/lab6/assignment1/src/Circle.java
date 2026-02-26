public class Circle implements Shape{
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public void draw(){
        System.out.println("draw circle");
    }
    public double calculateArea(){
        return 4*3.14*radius*radius;
    }
}
