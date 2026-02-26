package aggregationDemo;

public class Course {
    private Instructor instructor;
    TextBook  textBook; // should not
    public double price;
    private String name;
    public Course(Instructor instructor, TextBook textBook, String name) {
        this.instructor = instructor;
        this.textBook = textBook;
        this.name = name;
    }
    public Instructor getInstructor() {
        return new Instructor(instructor);
    }
    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
    public TextBook getTextBook() {
        return textBook;
    }
    public void setTextBook(TextBook textBook) {
        this.textBook = textBook;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Course [instructor=" + instructor + ", textBook=" + textBook + ", name=" + name + "]";
    }
    
}
