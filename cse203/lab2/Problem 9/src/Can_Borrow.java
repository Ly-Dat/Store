
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Can_Borrow {

    static HashMap<String, Integer> arrUser = new HashMap();
    static List<String> arrBook = new ArrayList<>();

    static void listUser() {
        arrUser.put(new User("1234", "a", "a@gmail.com").getValue(), 0);
        arrUser.put(new User("1235", "b", "b@gmail.com").getValue(), 1);
        arrUser.put(new User("1236", "c", "c@gmail.com").getValue(), 2);
    }

    static void listBook() {
        arrBook.add(new Book("a12", "toan").getValue());
        arrBook.add(new Book("a13", "van").getValue());
        arrBook.add(new Book("a14", "anh").getValue());
    }

    public Can_Borrow() {
        listBook();
        listUser();
    }

    public boolean Check(Book book, String user) {
        if (!arrBook.contains(book.getValue())
            || !arrUser.containsKey(user)
            || arrUser.get(user) > 1) {
            return false;
        }
        return true;
    }

}
