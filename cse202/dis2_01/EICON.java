
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EICON{

    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int q = sc.nextInt();
        Vertex[] vertexs = new Vertex[n+1];
		for(int i=1; i<=n; i++){
			vertexs[i] = new Vertex(i);
		}
		for(int i=0; i<m; i++){
			int u = sc.nextInt();
			int v = sc.nextInt();
			vertexs[v].addLink(vertexs[u]);
		}
		for(int j = 0; j<q; j++){
			if(vertexs[sc.nextInt()].list.contains(vertexs[sc.nextInt()])){
				sb.append("Y\n");
			}
			else{
				sb.append("N\n");
			}
		}
        
        System.out.println(sb);
    }
	static class Vertex{
		int id;
		List<Vertex> list = new ArrayList<>();
		public Vertex(int id) {
			this.id = id;
		}
		
		public void addLink(Vertex v){
			list.add(v);
		}
	}
}
