package algorithms.graph.path;

import algorithms.graph.Graph;

public class DepthFirstPaths extends Paths {

    public DepthFirstPaths(Graph G, int source) { super(G, source); }

    @Override
    protected void constructPaths(Graph G, int v) {
        mark(v);
        for (int w : G.adj(v)) {
            if (!isMarked(w)) {
                setEdgeTo(w, v);
                constructPaths(G, w);
            }
        }
    }
}
