public class Pet {
    int breek;
    int age;
    double weight;
    public int getBreek() {
        return breek;
    }
    public void setBreek(int breek) {
        this.breek = breek;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    @Override
    public String toString() {
        return "breek: " + breek + ", age: " + age + ", weight: " + weight;
    }
    
    
}
