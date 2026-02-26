
public class ClearDigits {
    public static void main(String[] args) {
        String s = "cb34";
        StringBuilder stack = new StringBuilder();
        for(char c: s.toCharArray()){
            if(Character.isLetter(c)){
                stack.append(c);
            }
            else{
                if(stack.length()>0){
                    stack.deleteCharAt(stack.length()-1);
                }
            }
        }
        System.out.println(stack.toString());
        
    }
}
