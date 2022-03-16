package algorithms.graph.component;

import algorithms.graph.Graph;
public class CC {
    
    private final boolean[] marked;
    private final int[] id;
    private int count;

    public CC(Graph G) {
        marked = new boolean[G.V()];
        id = new int[G.V()];
        for (int s = 0; s < G.V(); s++) {
            if (!marked[s]) {
                dfs(G, s);
                count++;
            }
        }
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        id[v] = count;
        for (int w : G.adj(v)) {
            if (!marked[w]) dfs(G, v);
        }
    }

    public int nrComponents() { return count + 1; }

    public int id(int v) { return id[v]; }

    public boolean connected(int v, int w) { return id(v) == id(w); }
}
