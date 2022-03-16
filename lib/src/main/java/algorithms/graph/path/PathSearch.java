package algorithms.graph.path;

import algorithms.graph.search.Search;

public interface PathSearch extends Search {

    boolean hasPathTo(int v);

    Iterable<Integer> pathTo(int v);
    
}
