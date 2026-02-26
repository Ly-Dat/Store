
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B4_EIUEASPOST {
    public static void main(String[] args) {
        int nNode = sc.nextInt();
        var nodes = readTree(nNode);
        printPostOrder(nodes[0]);
        System.out.println(sb);
    }
    static StringBuilder sb = new StringBuilder();
    static void printPostOrder(Node node){
        if(node.left != null){
            printPostOrder(node.left);
        }
        if(node.right != null){
            printPostOrder(node.right);
        }
        sb.append(node.id).append(" ");
    }
    static Node[] readTree(int nNode){
        Node[] nodes = new Node[nNode+1];
        for(int i=0; i<nNode; i++){
            nodes[i] = new Node(i+1);
        }
        for(int i=0; i<nNode; i++){
            int leftIndex = sc.nextInt();
            nodes[i].left = leftIndex > 0 ? nodes[leftIndex-1] : null;
            int rightIndex = sc.nextInt();
            nodes[i].right = rightIndex > 0 ? nodes[rightIndex-1] : null;
        }
        return nodes;
    }
    static class Node{
        int id;
        Node left;
        Node right;
        public Node(int id){
            this.id = id;
        }
    }
static InputReader sc = new InputReader(System.in);

    static class InputReader {

        StringTokenizer tokenizer;
        BufferedReader reader;
        String token;
        String temp;

        public InputReader(InputStream stream) {
            tokenizer = null;
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public InputReader(FileInputStream stream) {
            tokenizer = null;
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public String nextLine() throws IOException {
            return reader.readLine();
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    if (temp != null) {
                        tokenizer = new StringTokenizer(temp);
                        temp = null;
                    } else {
                        tokenizer = new StringTokenizer(reader.readLine());
                    }
                } catch (IOException e) {
                }
            }
            return tokenizer.nextToken();
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
