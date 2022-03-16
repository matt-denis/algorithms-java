package algorithms.graph.uf;

public class UnionFind extends UnionFindBase{

    public UnionFind(int nrComponents) { super(nrComponents); }

    public int count() { return count; }

    @Override
    public int find(int p) { return id[p];}
    
    @Override
    public void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);
        if (pId == qId) return;
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pId) id[i] = qId;
        }
        count--;
    }

}
