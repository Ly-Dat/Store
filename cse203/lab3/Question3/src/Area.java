public class Area {
    String nameArea;
    double area;
    public Area(double radius) {
        this.nameArea = "circle";
        this.area = 3.14 * radius * 2;
    }
    public Area(int width, int length) { 
        this.nameArea = "rectangle";
        this.area = width*length;
    }
    public Area(double radiusBase, double height) {
        this.nameArea="cylinder";
        this.area = 3.14 * radiusBase * 2 * height;
    }
    @Override
    public String toString() {
        return "area of " + nameArea + ": " + area;
    } 
    
    
    
}
