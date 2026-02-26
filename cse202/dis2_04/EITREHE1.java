
import java.util.ArrayList;
import java.util.Scanner;

public class EITREHE1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Vertex[] vertexs = new Vertex[n];
        for (int i = 0; i < n; i++) {
            vertexs[i] = new Vertex(i);
        }
        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            vertexs[u].addLink(vertexs[v]);
            vertexs[v].addLink(vertexs[u]);
        }
        dfs(vertexs[0], 0);
        System.out.println(max);

    }
    static int max = 0;

    static void dfs(Vertex v, int level) {
        v.check = true;
        max = Math.max(max, level);
        for (Vertex ver : v.list) {
            if (!ver.check) {
                dfs(ver, level + 1);
            }
        }
    }

    static class Vertex {

        int id;
        boolean check;
        ArrayList<Vertex> list = new ArrayList<>();

        public Vertex(int id) {
            this.id = id;
            this.check = false;
        }

        public void addLink(Vertex v) {
            list.add(v);
        }
    }
}
