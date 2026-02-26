package aggregationDemo;
public class TextBook {
    private String isbn;
    private String title;
    private String fAuthor;
    public TextBook(String isbn, String title, String fAuthor) {
        this.isbn = isbn;
        this.title = title;
        this.fAuthor = fAuthor;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getfAuthor() {
        return fAuthor;
    }
    public void setfAuthor(String fAuthor) {
        this.fAuthor = fAuthor;
    }
    @Override
    public String toString() {
        return "TextBook [isbn=" + isbn + ", title=" + title + ", fAuthor=" + fAuthor + "]";
    }

    
    
}
