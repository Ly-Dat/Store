public class SquareFactory extends ShapeFactory{

    @Override
    Shape getShape() {
       return new Square();
    }
    
}
