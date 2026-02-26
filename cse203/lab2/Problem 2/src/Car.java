public class Car {
    int yearModel;
    String make;
    int speed;
    public int getYearModel() {
        return yearModel;
    }
    public void setYearModel(int yearModel) {
        this.yearModel = yearModel;
    }
    public String getMake() {
        return make;
    }
    public void setMake(String make) {
        this.make = make;
    }
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public void accelerator(){
        this.speed+=5;
    }
    public void brake(){
        this.speed-=5;
    }

    
}
