
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class EIPRF {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
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
            if(v == 0){
                vertexs[u].hasZero = true;
            }
        }
        bfs(vertexs[0]);
        int min = Integer.MAX_VALUE;
        int index = 0;
        for (Vertex vertex : vertexs) {
            if (vertex.path.size() > 2 && vertex.hasZero) {
                if (vertex.path.size() < min) {
                    min = vertex.path.size();
                    index = vertex.id;
                }
            }
        }
        for(int a : vertexs[index].path){
            sb.append(a).append(" ");
        }
        System.out.println(sb);
    }

    static void bfs(Vertex v) {
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(v);
        v.check = true;
        while (!queue.isEmpty()) {
            Vertex u = queue.poll();
            u.path.add(u.id);
            for (Vertex ver : u.list) {
                if (!ver.check) {
                    ver.check = true;
                    queue.add(ver);
                    ver.path.addAll(u.path);
                }
            }
        }
    }

    static class Vertex {
        int id;
        boolean check;
        boolean hasZero;
        int level;
        ArrayList<Vertex> list = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();

        public Vertex(int id) {
            this.id = id;
            this.check = false;
            this.level = 0;
        }

        public void addLink(Vertex v) {
            list.add(v);
        }

    }
}
