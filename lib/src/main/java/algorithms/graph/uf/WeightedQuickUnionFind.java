package algorithms.graph.uf;

public class WeightedQuickUnionFind extends QuickUnionFind {

    private final int[] treeSize;

    public WeightedQuickUnionFind(int nrComponents) {
        super(nrComponents);
        treeSize = new int[count];
        for (int i = 0; i < count; i++) {
            treeSize[i] = 1;
        }
    }

    @Override
    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) return;
        int smaller = treeSize[i] <= treeSize[j] ? i : j;
        int larger = (i - smaller) + j; // parenthesize to decrease probability of overflow
        id[smaller] = larger;
        treeSize[larger] += treeSize[smaller];
        count--;
    }
}
