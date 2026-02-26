
import java.util.Scanner;

public class Problem9 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // user ok
        String user = new User("1234", "a", "a@gmail.com").getValue();

        // wrong user
        // String user = new User("1234", "b", "a@gmail.com").getValue();

        // user with overdue book
        // String user = new User("1236", "c", "c@gmail.com").getValue();

        System.out.println("Enter ISBN: ");
        String isbn = sc.nextLine();
        System.out.println("Entere Title: ");
        String title = sc.nextLine();
        System.out.println("Entere number of days they want to borrow: ");
        int numDay = sc.nextInt();

        Book book = new Book(isbn, title);
        Can_Borrow canBorrow = new Can_Borrow();

        if(canBorrow.Check(book, user)){
            System.out.println("you can borrow it for " + numDay + " days");
        }
        else{
            System.out.println("you can not borrow it");
        }
    }
}
