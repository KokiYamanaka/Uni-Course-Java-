//*********************************************************************************************************************************************************************************************************************
// DecisionTree.java 
//
// Koki Yamanaka (T00681865)
// COMP 2231 Assignment 4 - Question 1 - Decision Tree 
// DecisionTree.java - This program construct a decision tree based on a text file consists of questions, answers, and trees structure(shape). 
// After user response, the program will iterate through the appropriate nodes from root to leaf. 
////*****************************************************************************************************************************************************************************************
import java.util.*;
import java.io.*;

/**
 * The DecisionTree class uses the LinkedBinaryTree class to implement 
 * a binary decision tree. Tree elements are read from a given file and  
 * then the decision tree can be evaluated based on user input using the
 * evaluate method. 
 * 
 * @author Java Foundations
 * @version 4.0
 */
public class DecisionTree
{
    // initilize a tree by using LinkedBinaryTree class
    private LinkedBinaryTree<String> tree;

    /**
     * Builds the decision tree based on the contents of the given file
     *
     * @param filename the name of the input file
     * @throws FileNotFoundException if the input file is not found
     */
    public DecisionTree(String filename) throws FileNotFoundException
    {
        // input given questionaire file 
        File inputFile = new File(filename);
        Scanner scan = new Scanner(inputFile);
        
        // check the number of nodes to create
        int numberNodes = scan.nextInt();
        
        // scan through the questions
        scan.nextLine();
        
        // initiliaze the root node 
        int root = 0, left, right;

        // create linked 
        List<LinkedBinaryTree<String>> nodes = new java.util.ArrayList<LinkedBinaryTree<String>>();
        
        // assign the string questions for each node
        for (int i = 0; i < numberNodes; i++)
            nodes.add(i, new LinkedBinaryTree<String>(scan.nextLine()));

        // setting up the tree from the leaf
        // note that, small subtree are created with size of 3 nodes.
        // eventually, all subtree becomes the decision tree. 
        while (scan.hasNext())
        {
            // scan the node number in the order of root, left, and right.
            // each node number corresponds to each question in text file. 
            root = scan.nextInt();
            left = scan.nextInt();
            right = scan.nextInt();
            scan.nextLine();

            // set the nodes at their appopriate location.
            nodes.set(root, new LinkedBinaryTree<String>((nodes.get(root)).getRootElement(), nodes.get(left), nodes.get(right)));
        }
        
        // set the final structure of the tree by getting the root of tree
        tree = nodes.get(root);
    }

    /**
     *  Follows the decision tree based on user responses.
     */
    // take in user's response, whether yes or no
    public void evaluate()
    {
        LinkedBinaryTree<String> current = tree;
        Scanner scan = new Scanner(System.in);

        // iterate from root to the leaf while the size of the tree is greater than 1 
        // intially we are not in the leaf 
        while (current.size() > 1) 
        {
            // post question to the user 
            System.out.println(current.getRootElement());
            // if the answer is a no, then we go to the left 
            if (scan.nextLine().equalsIgnoreCase("N"))
                current = current.getLeft();
            else
                current = current.getRight();
        }

        // print the bottom answer
        System.out.println(current.getRootElement());
    }
}