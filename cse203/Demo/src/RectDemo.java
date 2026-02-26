public class RectDemo {
    public static void main(String[] args) {
        Rectangle a = createRectangle(50, 20);
        Rectangle b = new Rectangle(a); 
        a.setWidth(5);
        System.out.println(b.getWidth());
    }

    public static Rectangle createRectangle(double width, double length){
        return new Rectangle(width, length);
    }
}
