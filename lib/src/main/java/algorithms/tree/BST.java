package algorithms.tree;

import edu.princeton.cs.algs4.Queue;

public class BST<K extends Comparable<K>, V> {
    
    private class Node {
        private K key;
        private V val;
        private Node left, right;
        private int N;
        public Node(K key, V val, int N) {
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }

    private Node root;

    public int size() { return size(root); }

    public boolean isEmpty() { return size() == 0; }

    public V get(K key) {
        return get(root, key);
    }
    
    public void put(K key, V val) {
        root = put(root, key, val);
    }

    public K min() {
        if (isEmpty()) throw new IllegalStateException("Underflow");
        return min(root).key;
    }

    public K max() {
        if (isEmpty()) throw new IllegalStateException("Underflow");
        return max(root).key;
    }

    public K floor(K key) {
        Node floor = floor(root, key);
        return floor == null ? null : floor.key;
    }

    public K ceiling(K key) {
        Node ceiling = ceiling(root, key);
        return ceiling == null ? null : ceiling.key;
    }

    public K select(int k) {
        Node x = select(root, k);
        return x == null ? null : x.key;
    }

    public int rank(K key) {
        return rank(root, key);
    }

    public void deleteMin() {
        if (isEmpty()) return;
        root = deleteMin(root);
    }

    public void delete(K key) {
        root = delete(root, key);
    }

    public Iterable<K> keys(K min, K max) {
        if (min == null || max == null) throw new IllegalStateException("Underflow");
        var queue = new Queue<K>();
        keys(min, max, root, queue);
        return queue;
    }

    public Iterable<K> keys() {
        return keys(min(), max());
    }

    private int size(Node x) { return x == null ? 0 : x.N; }

    private V get(Node x, K key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return get(x.left, key);
        if (cmp > 0) return get(x, key);
        else return x.val;
    }

    private Node put(Node x, K key, V val) {
        if (x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else x.val = val;
        x.N = size(x.right) + size(x.left) + 1; // update sizes on the way up
        return x;
    }

    private Node min(Node x) {
        if (x.left == null) return null;
        return min(x.left);
    }

    private Node max(Node x) {
        if (x.right == null) return null;
        return max(x.right);
    }
    
    private Node floor(Node x, K key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return floor(x.left, key);
        if (cmp > 0) {
            Node right = floor(x.right, key);
            return right == null ? x : right;
        }
        return x;
    }

    private Node ceiling(Node x, K key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp > 0) return ceiling(x, key);
        if (cmp < 0) {
            Node left = ceiling(x.left, key);
            return left == null ? x : left;
        }
        return x;
    } 

    private Node select(Node x, int k) {
        if (x == null) return null;
        int t = size(x.left);
        if (k < t) return select(x.left, k);
        if (k > t) return select(x.right, k - t - 1);
        return x;
    }

    private int rank(Node x, K key) {
        if (x == null) return -1;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return rank(x.left, key);
        if (cmp > 0) return size(x.left) + 1 + rank(x.right, key);
        return size(x.left);
    }

    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        return x;        
    }

    private Node delete(Node x, K key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = delete(x.left, key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else {
            if (x.left == null) return x.right;
            if (x.right == null) return x.left;
            Node t = x;
            x = min(x.right);
            x.right = deleteMin(x.right);
            x.left = t.left;
        }
        x.N = size(x.right) + size(x.left) + 1;
        return x;
    } 
    
    private void keys(K min, K max, Node x, Queue<K> queue) {
        if (x == null) return;
        int minCmp = min.compareTo(x.key);
        int maxCmp = max.compareTo(x.key);
        if (minCmp < 0) keys(min, max, x.left, queue);
        if (minCmp <= 0 && maxCmp >= 0) queue.enqueue(x.key);
        if (maxCmp > 0) keys(min, max, x.right, queue);
    }
}