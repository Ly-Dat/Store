
import java.util.HashMap;

public class WordFrequencyCount {
    private String file;
    private HashMap<String, Integer> map;
    public WordFrequencyCount(String file) {
        this.map = new HashMap<>();
        this.file = file.replace(" ", "");
        String[] arr = this.file.split("");
        for(var t:arr){
            map.put(t, map.getOrDefault(t, 0)+1);
        }
    }
    public String getNewFile() {
        StringBuilder sb = new StringBuilder();
        map.forEach((key,val)->sb.append(key+" "+val+"\n"));
        return sb.toString();
    }

    
}
