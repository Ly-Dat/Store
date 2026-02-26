public class Book {
    String ISBN;
    String title;

    public Book(String ISBN, String title) {
        this.ISBN = ISBN;
        this.title = title;
    }
    
    public String getValue(){
        return ISBN + " " + title;
    }
    
}
