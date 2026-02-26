public class Ship {
    String name;
    String yearBuilt;
    public Ship(String name, String yearBuilt) {
        this.name = name;
        this.yearBuilt = yearBuilt;
    }
    public Ship(String name) {
        this.name = name;
    }

    public String toString(){
        return "name: "+name+", the year that the ship was built: "+yearBuilt;
    }
}
