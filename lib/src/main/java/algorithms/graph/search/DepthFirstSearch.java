package algorithms.graph.search;

import algorithms.graph.Graph;

public class DepthFirstSearch implements Search {
    
    private final int source;
    private final boolean[] marked;
    private int count;

    public DepthFirstSearch(Graph G, int source) {
        this.source = source;
        marked = new boolean[G.V()];
        dfs(G, source);
    }

    protected void dfs(Graph G, int v) {
        marked[v] = true;
        count++;
        for (int w : G.adj(v)) {
            if (!marked[w]) dfs(G, w);
        }
    }

    public int getSource() { return source; }
    public int count() { return count; }
    @Override
    public boolean isMarked(int v) { return marked[v]; }
    
}
