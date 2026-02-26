public class ShapeDrawingApplication {
    public static void main(String[] args) {
        Shape shapeC = new Circle(10);
        Shape shapeR = new Rectangle(20, 30);
        Shape shapeT = new Triangle(10, 6);
        shapeC.draw();
        System.out.println("Area: "+shapeC.calculateArea());
        shapeR.draw();
        System.out.println("Area: "+shapeR.calculateArea());
        shapeT.draw();
        System.out.println("Area: "+shapeT.calculateArea());
    }
}
