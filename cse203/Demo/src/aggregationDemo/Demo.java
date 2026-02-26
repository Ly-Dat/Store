package aggregationDemo;

public class Demo {
    public static void main(String[] args) {
        Course c = 
            new Course(null, null, "CSE 203 - OOP");
        Instructor instructor = new Instructor("a", "Nguyen", "414.B11", "Wednesday 13:30 - 15:30");
        TextBook textBook = new TextBook("10001", "Java programming", "Nguyen Van B");
        c.setInstructor(instructor);
        c.setTextBook(textBook);
        c.price = 10; // should not
        
        System.out.println(c);
        
    }
}
