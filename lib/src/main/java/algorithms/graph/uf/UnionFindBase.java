package algorithms.graph.uf;

public abstract class UnionFindBase {
    protected int count;
    protected final int[] id;

    public UnionFindBase(int nrComponents) {
        if (nrComponents < 1) 
            throw new IllegalArgumentException("Invalid initial number of components");
        count = nrComponents;
        id = new int[count];
        for(int i = 0; i < count; i++) {
            id[i] = i;
        }
    }

    public int count() { return count; }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public abstract int find(int p);

    public abstract void union(int p, int q);
}
