public class Rectangle implements Shape{
    private double width;
    private double length;

    @Override
    public void draw() {
        System.out.println("Drawing a rectangle");
    }
}
