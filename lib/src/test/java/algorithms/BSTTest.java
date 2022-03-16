package algorithms;

import org.junit.Test;

import algorithms.tree.BST;

import org.junit.Assert;

public class BSTTest {

    @Test
    public void treeInitiallyEmpty() {
        var tree = new BST<Integer, Character>();
        Assert.assertTrue(tree.isEmpty());
    }

    @Test
    public void canAddRoot() {
        var tree = new BST<Integer, Character>();
        tree.put(3, 'A');
        Assert.assertFalse(tree.isEmpty());
    }
    
}
