import java.util.TreeSet;

public class WordSet {
    private String line;
    private TreeSet<String> sort;

    public WordSet(String line) {
        this.line = line.replace(" ", "");
        String[] arr = this.line.split("");
        this.sort= new TreeSet<>();
        for(var t:arr){
            sort.add(t);
        }
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line.replace(" ", "");
        String[] arr = this.line.split("");
        this.sort= new TreeSet<>();
        for(var t:arr){
            sort.add(t);
        }
    }

    public TreeSet<String> getSort() {
        return sort;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sort.forEach(p->sb.append(p).append("\n"));
        return sb.toString();
    }

}