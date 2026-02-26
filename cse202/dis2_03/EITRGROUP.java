
import java.util.ArrayList;
import java.util.Scanner;

public class EITRGROUP {

    static int max;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Vertex[] vertexs = new Vertex[n];
        for (int i = 0; i < n; i++) {
            vertexs[i] = new Vertex(i);
        }
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            vertexs[u].addLink(vertexs[v]);
            vertexs[v].child = true;
        }
        int index = 0;
        for (Vertex ver : vertexs) {
            if (!ver.child) {
                index = ver.id;
                break;
            }
        }
        dfs(vertexs[index], 1);
        System.out.println(max);
    }

    static void dfs(Vertex v, int level) {
        v.check = true;
        max = Math.max(max, level);
        for (Vertex ve : v.list) {
            if (!ve.check) {
                dfs(ve, level + 1);
            }
        }
    }

    static class Vertex {

        int id;
        boolean check;
        boolean child;
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
