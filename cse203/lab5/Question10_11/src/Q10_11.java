import java.io.*;

public class Q10_11 {
    public static void main(String[] args) throws IOException{
        // 
        String filename = "input.txt";
        BufferedReader br = new BufferedReader(new FileReader(filename));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = br.readLine();
            if(line==null){
                break;
            }
            sb.append(line).append("\n");
        }
        FileEncryptionFilter fef = new FileEncryptionFilter(sb.toString());
        String a = fef.getNewFile();
        try (FileWriter writer = new FileWriter("output.txt")) {
            writer.write(a);
        } catch(Exception e){
            System.out.println("can not find file");
        }
        System.out.println("Encryption done");

        //
        BufferedReader br1 = new BufferedReader(new FileReader("output.txt"));
        StringBuilder sb1 = new StringBuilder();
        while (true) {
            String line = br1.readLine();
            if(line==null){
                break;
            }
            sb1.append(line).append("\n");
        }
        FileDecryptionFilter fdf = new FileDecryptionFilter(sb1.toString());
        a = fdf.getNewFile();
        try (FileWriter writer = new FileWriter("solve.txt")) {
            writer.write(a);
        } catch(Exception e){
            System.out.println("can not find file");
        }
        System.out.println("Decryption done");
    }
}
