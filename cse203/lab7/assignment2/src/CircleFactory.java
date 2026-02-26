
public class CircleFactory extends ShapeFactory {

    @Override
    Shape getShape() {
        return new Circle();
    }
}
