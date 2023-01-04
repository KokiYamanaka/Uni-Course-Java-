//*********************************************************************************************************************************************************************************************************************
// Driver.java 
//
// Koki Yamanaka (T00681865)
// COMP 2231 Assignment 4 - Question 2 LinkedBinarySearchTree
// Driver.java - This program test the functionality of the LinkedBinarySearchTree.java . 
////*****************************************************************************************************************************************************************************************

public class Driver {
    public static void main(String[] args) {
        // create three trees to test
        LinkedBinarySearchTree<Integer> tree1 = new LinkedBinarySearchTree<Integer>();
      
        // create array of values to fill trees with
        int[] tree1nodes = { 4, 10, 11, 12, 13, 1 };

        // fill tree 1 with values
        for (int i = 0; i < tree1nodes.length; i++){
            tree1.addElement(tree1nodes[i]);
        }
        
        // TEST FOR BALANCING DEGENERATED TREE 
        // 
        // create degenerate tree 
        // print the current height of tree
        System.out.println("height?" + tree1.getHeight());
        // do a balancing on tree 
        tree1.balanceTree();
        // print the current height of tree
        System.out.println("height?" + tree1.getHeight());

        // add some elements to balanced tree 1 to create degeneracy 
        tree1.addElement(45);
        tree1.addElement(46);
        tree1.addElement(47);
        tree1.addElement(49);

        // print the current height of tree
        System.out.println("height?" + tree1.getHeight());
        // do a balancing on tree 
        tree1.balanceTree();
        // print the current height of tree
        System.out.println("height?" + tree1.getHeight());
    }
}
