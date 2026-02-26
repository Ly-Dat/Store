public class Problem2 {
    public static void main(String[] args) {
        Car car = new Car();
        car.setYearModel(2000);
        car.setMake("BMW");
        car.setSpeed(120);

        for(int i =0; i<5; i++){
            car.accelerator();
            System.out.print(car.getSpeed()+" ");
        }
        System.out.println("");

        for(int i =0; i<5; i++){
            car.brake();
            System.out.print(car.getSpeed()+" ");
        }

    }

}
