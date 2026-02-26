public class main2 {
    public static void main(String[] args) throws Exception {
        BookDAO bd = new BookDAO("bookInput.txt", "bookOutput.txt");
        BookService bs = new BookService(bd);
        bs.importData();
        bs.addBook(new Book("vat li", 3 , "hooo"));
        bs.deleteBook("toan");
        bs.saveData();
        System.out.println(bs.showListBook());
    }
}
