
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class test {

    public static void main(String[] args) {
        LocalDate lc = LocalDate.of(2025,12,1);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println(format.format(lc));

        //
        int k=5;
        int size = 10;
  
        int i=0;
        while(i<k){

                System.out.println("hi");
                i++;

        }
        while(i<size && i==k){
            System.out.println("alo");
            i++;
        }

        //
        int rank =1;
    }
}