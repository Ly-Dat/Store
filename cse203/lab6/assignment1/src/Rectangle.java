public class Rectangle implements Shape{
    private double width;
    private double length;

    public Rectangle(int length, int wigth) {
        this.length = length;
        this.width = width;
    }
    public void draw(){
        System.out.println("draw rectangle");
    }
    public double calculateArea(){
        return width*length;
    }

}
