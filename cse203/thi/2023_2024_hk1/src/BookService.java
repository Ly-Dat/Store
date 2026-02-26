import java.io.IOException;
import java.util.ArrayList;

public class BookService {
    private BookDAO bookDao;
    private ArrayList<Book> list;

    public BookService(BookDAO bookDao){
        this.bookDao = bookDao;
    }

    public void importData() throws IOException {
        bookDao.importBook();
        this.list = bookDao.getListBook();
    }
    public void saveData() throws IOException {
        bookDao.save(list);
    }
    public void addBook(Book book){
        list.add(book);
    }
    public void deleteBook(String name){
        for(var t : list){
            if(t.getName().equals(name)){
                list.remove(t);
                break;
            }
        }
    }
    public String showListBook(){
        StringBuilder sb = new StringBuilder();
        for(var t : list){
            sb.append(t).append("\n");
        }
        return sb.toString();
    }

}
