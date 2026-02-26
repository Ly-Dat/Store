
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class BookDAO {

    private String fileName;
    private String fileOut;
    private ArrayList<Book> listBook;

    public BookDAO(String fileName, String fileOut) {
        this.fileName = fileName;
        this.fileOut = fileOut;
        this.listBook = new ArrayList<>();
    }

    public void importBook() throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = br.readLine()) != null) {
            line.trim();
            String[] arr = line.split("\\s");
            listBook.add(new Book(arr[0], Integer.parseInt(arr[1]), arr[2]));
        }
    }
    public void save(ArrayList<Book> list) throws IOException{
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileOut));
        for(var t : list){
            bw.write(t.toString()+"\n");
        }
        bw.close();
        this.listBook = list;
    }

    public ArrayList<Book> getListBook() {
        return listBook;
    }

}
