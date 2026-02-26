public class main2 {
    public static void main(String[] args) throws Exception {
        ShapeFactory sf1 = new CircleFactory();
        ShapeFactory sf2 = new RectangleFactory();
        sf1.getShape().draw();
        sf2.getShape().draw();
    }
}
