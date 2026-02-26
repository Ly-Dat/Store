public class main3 {
    public static void main(String[] args) throws Exception {
        Coffee coffee = new SimpleCoffee(3);
        coffee = new MilkDecorator(coffee, 1);
        coffee = new SugarDecorator(coffee, 0.5);
        System.out.println( "Description: " + coffee.getDescription());
        System.out.println("Cost: "+coffee.getCost());
    }
}
