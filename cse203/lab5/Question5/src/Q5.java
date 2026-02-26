import java.io.*;
public class Q5 {
    public static void main(String[] args) throws IOException{
        String filename = "newFile.txt";
        BufferedReader br = new BufferedReader(new FileReader(filename));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = br.readLine();
            if(line==null){
                break;
            }
            sb.append(line);
        }
        WordFrequencyCount wfc = new WordFrequencyCount(sb.toString());
        String a = wfc.getNewFile();
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(a);
        } catch(Exception e){
            System.out.println("can not find file");
        }
        System.out.println("done");
    }
}
