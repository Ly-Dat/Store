
public class FileEncryptionFilter {
    private String file;
    public FileEncryptionFilter(String file) {
        this.file = file;
        
    }
    public String getNewFile() {
        StringBuilder sb = new StringBuilder();
        String[] arr = this.file.split("\n");
        for(var t:arr){
            for(var m : t.toCharArray()){
                if (m >= 32 && m <= 126) { 
                    sb.append((char) (((m - 32 + 10) % 95) + 32));
                } else {
                    sb.append(m); 
                }
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
