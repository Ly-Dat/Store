
import java.util.*;

public class EIMINSPAN {

    static class Edge implements Comparable<Edge> {

        int u, v, weight;

        Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }

        public int compareTo(Edge other) {
            return this.weight - other.weight;
        }

        static class DSU {

            int[] parent, rank;

            DSU(int n) {
                parent = new int[n];
                rank = new int[n];
                for (int i = 0; i < n; i++) {
                    parent[i] = i;
                }
            }

            int find(int x) {
                if (parent[x] != x) {
                    parent[x] = find(parent[x]);
                }
                return parent[x];
            }

            boolean union(int x, int y) {
                int rootX = find(x), rootY = find(y);
                if (rootX == rootY) {
                    return false;
                }
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX; 
                }else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY; 
                }else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
                return true;
            }
        }

        static int kruskalMST(int n, List<Edge> edges) {
            Collections.sort(edges);
            DSU dsu = new DSU(n);
            int mstWeight = 0, edgesUsed = 0;

            for (Edge edge : edges) {
                if (dsu.union(edge.u, edge.v)) {
                    mstWeight += edge.weight;
                    edgesUsed++;
                    if (edgesUsed == n - 1) {
                        return mstWeight;
                    }
                }
            }
            return -1;
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt(), m = scanner.nextInt();
            List<Edge> edges = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt(), v = scanner.nextInt(), w = scanner.nextInt();
                edges.add(new Edge(u, v, w));
            }
            scanner.close();

            System.out.println(kruskalMST(n, edges));
        }
    }
}
