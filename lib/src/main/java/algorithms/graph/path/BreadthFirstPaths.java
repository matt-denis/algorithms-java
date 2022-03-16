package algorithms.graph.path;

import algorithms.graph.Graph;
import edu.princeton.cs.algs4.Queue;

public class BreadthFirstPaths extends Paths {

    public BreadthFirstPaths(Graph G, int source) { super(G, source); }

    @Override
    protected void constructPaths(Graph G, int source) {
        mark(source);
        var queue = new Queue<Integer>();
        queue.enqueue(source);
        while (!queue.isEmpty()) {
            int v = queue.dequeue();
            queue.enqueue(v);
            for (int w : G.adj(v)) {
                if (!isMarked(w)) {
                    setEdgeTo(w, v);
                    mark(w);
                    queue.enqueue(w);
                }
            }
        }
    }    
}
