
import java.util.Scanner;

public class test12 {

    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        int nNode = sc.nextInt();
        Node[] nodes = readTree(nNode);
        PrintPost(nodes[0]);
        System.out.println(sb);
    }

    static void PrintPost(Node node) {
        if (node.left != null) {
            PrintPost(node.left);
        }
        if (node.right != null) {
            PrintPost(node.right);
        }
        sb.append(node.id).append(" ");
    }

    static Node[] readTree(int nNode) {
        Node[] nodes = new Node[nNode];
        for (int i = 0; i < nNode; i++) {
            nodes[i] = new Node(i + 1);
        }
        for (int i = 0; i < nNode; i++) {
            int nodeLeft = sc.nextInt();
            nodes[i].left = nodeLeft > 0 ? nodes[nodeLeft - 1] : null;
            int nodeRight = sc.nextInt();
            nodes[i].right = nodeRight > 0 ? nodes[nodeRight - 1] : null;
        }
        return nodes;
    }

    static class Node {

        int id;
        Node left;
        Node right;

        public Node(int id) {
            this.id = id;
        }
    }
}
