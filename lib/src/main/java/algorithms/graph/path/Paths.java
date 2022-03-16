package algorithms.graph.path;

import algorithms.graph.Graph;
import edu.princeton.cs.algs4.Stack;

public abstract class Paths implements PathSearch {
    
    private final int source;
    private final boolean[] marked;
    private final int[] edgeTo;

    protected Paths(Graph G, int source) {
        this.source = source;
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        constructPaths(G, source);
    }

    protected abstract void constructPaths(Graph G, int source);

    protected void mark(int v) { marked[v] = true; }

    protected void setEdgeTo(int to, int from) {
        edgeTo[to] = from;
    }

    public int getSource() { return source; }

    public boolean isMarked(int v) { return marked[v]; }

    public boolean hasPathTo(int v) { return isMarked(v); }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        var path = new Stack<Integer>();
        for (int x = v; x != source; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(source);
        return path;
    }
}
