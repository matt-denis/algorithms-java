package algorithms.graph.uf;

public class QuickUnionFind extends UnionFindBase {
    
    public QuickUnionFind(int nrComponents) { super(nrComponents); }

    @Override
    public int find(int p) {
        int i;
        for (i = p; id[i] != i; i = id[i]);
        return i;
    }

    @Override 
    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) return; // same component
        id[i] = j; // root of q becomes parent of root of p
        count--;
    }
}
