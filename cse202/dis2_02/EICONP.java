import java.util.ArrayList;
import java.util.Scanner;

public class EICONP {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Vertex[] vertexs = new Vertex[n];
        for(int i=0; i<n; i++){
            vertexs[i] = new Vertex(i);
        }
        for(int j=0; j<m; j++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            vertexs[u].addLink(vertexs[v]);
            vertexs[v].addLink(vertexs[u]);
        }
        int count = 0;
        for(int k=0 ; k<n; k++){
            if(!vertexs[k].check){
                dfs(vertexs[k]);
                count++;
            }
        }
        System.out.println(count);
    }
    static void dfs(Vertex v){
        v.check = true;
        for(Vertex ver : v.list){
            if(!ver.check){
                dfs(ver);
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
