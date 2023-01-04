 //*********************************************************************************************************************************************************************************************************************
// LinkedBinaryTree.java 
//
// Koki Yamanaka (T00681865)
// COMP 2231 Assignment 4 - Question 1 - Decision Tree 
// LinkedBinaryTree.java - This program construct a decision tree based on a text file consists of questions, answers, and trees structure(shape). 
// After user response, the program will iterate through the appropriate nodes from root to leaf. 
////**************************************************************************************************************************************************************************
import java.util.*;
/**
 * LinkedBinaryTree implements the BinaryTreeADT interface
 * 
 * @author Java Foundations
 * @version 4.0
 */

// class represents a binary tree class
public class LinkedBinaryTree<T> implements BinaryTreeADT<T>, Iterable<T>
{
    protected BinaryTreeNode<T> root; // represents the root's node (not its element)
    protected int modCount; // variable to count the number of changes made for inner data structure

    /**
     * Creates an empty binary tree.
     */
    public LinkedBinaryTree() 
    {
        root = null;
    }

    /**
     * Creates a binary tree with the specified element as its root.
     *
     * @param element the element that will become the root of the binary tree
     */
    public LinkedBinaryTree(T element) 
    {
        root = new BinaryTreeNode<T>(element);
    }

    /**
     * Creates a binary tree with the specified element as its root and the 
     * given trees as its left child and right child
     *
     * @param element the element that will become the root of the binary tree
     * @param left the left subtree of this tree
     * @param right the right subtree of this tree
     */
    public LinkedBinaryTree(T element, LinkedBinaryTree<T> left, 
            LinkedBinaryTree<T> right) 
    {
        root = new BinaryTreeNode<T>(element);
        root.setLeft(left.root);
        root.setRight(right.root);
    }

    /**
     * Returns a reference to the element at the root
     *
     * @return a reference to the specified target
     * @throws EmptyCollectionException if the tree is empty
     */
    public T getRootElement() throws EmptyCollectionException
    {
        // To be completed as a Programming Project
        
        // if root don't have element (if tree is empty), then throw an empty collection exception  
        if (root == null)
            throw new EmptyCollectionException("LinkedBinaryTree");
        // else return the element at root note 
        return root.getElement();
    }

    /**
     * Returns a reference to the node at the root
     *
     * @return a reference to the specified node
     * @throws EmptyCollectionException if the tree is empty
     */
    protected BinaryTreeNode<T> getRootNode() throws EmptyCollectionException
    {
        // To be completed as a Programming Project
        // if root don't have element (if tree is empty), then throw an empty collection exception  
        if (root == null)
            throw new EmptyCollectionException("LinkedBinaryTree");
        
        return root;  // temp
    }

    /**
     * Returns the left subtree of the root of this tree.
     *
     * @return a link to the left subtree fo the tree
     */
    public LinkedBinaryTree<T> getLeft()
    {
        // To be completed as a Programming Project
        
        // if root is empty, throw exception
        if (root == null)
        throw new EmptyCollectionException("Get left operation "+ "failed. The tree is empty.");

        // create new LinkedBinaryTree and get left subtree of root node. 
        // This is first done by getting left child of the root node
        LinkedBinaryTree<T> result = new LinkedBinaryTree<T>();
        result.root = root.getLeft();
        
        // return result 
        return result;
    }

    /**
     * Returns the right subtree of the root of this tree.
     *
     * @return a link to the right subtree of the tree
     */
    public LinkedBinaryTree<T> getRight()
    {
        // To be completed as a Programming Project
        
        // if root is empty, throw exception
        if (root == null)
        throw new EmptyCollectionException("Get left operation "+ "failed. The tree is empty.");

        // create new LinkedBinaryTree and get left subtree of root node. 
        // This is first done by getting left child of the root node
        LinkedBinaryTree<T> result = new LinkedBinaryTree<T>();
        result.root = root.getRight();
        
        // return result 
        return result;
    }

    /**
     * Returns true if this binary tree is empty and false otherwise.
     *
     * @return true if this binary tree is empty, false otherwise
     */
    public boolean isEmpty() 
    {
        return (root == null);
    }

    /**
     * Returns the integer size of this tree.
     *
     * @return the integer size of the tree
     */
    public int size() 
    {
        // To be completed as a Programming Project
        return (root.numChildren() + 1);  // temp
    }

    /**
     * Returns the height of this tree.
     *
     * @return the height of the tree
     */
    public int getHeight()
    {
        // To be completed as a Programming Project
        return height(root)-1; // temp
    }

    /**
     * Returns the height of the specified node.
     *
     * @param node the node from which to calculate the height
     * @return the height of the tree
     */
    private int height(BinaryTreeNode<T> node) 
    {
        // To be completed as a Programming Project
        
        // variable to store longest path on tree 
        int result = 0;
        
        // if the specified is not empty, then we find recursively iterate through node's left and right subtree 
        // and, determine whether left or right subtree will have the longest path 
        if (node != null)
            result = Math.max(height(node.getLeft()), height(node.getRight())) + 1;

        // return the longest path from specified node to leaf 
        return result;
    }

    /**
     * Returns true if this tree contains an element that matches the
     * specified target element and false otherwise.
     *
     * @param targetElement the element being sought in this tree
     * @return true if the element in is this tree, false otherwise
     */
    public boolean contains(T targetElement) 
    {
        // To be completed as a Programming Project
        
        // hold a temporary variable
        T temp;
        // indicator variable to store whether a target element is in/ or not in tree  
        boolean found = false;
        
        // if element is found, set the indicator variable to true
        try 
        {
            temp = find(targetElement);
            found = true;
        }
        // if not, set the indicator variable to false
        catch (Exception ElementNotFoundException) 
        {
            found = false;
        }
        
        return found;
    }

    /**
     * Returns a reference to the specified target element if it is
     * found in this binary tree.  Throws a ElementNotFoundException if
     * the specified target element is not found in the binary tree.
     *
     * @param targetElement the element being sought in this tree
     * @return a reference to the specified target
     * @throws ElementNotFoundException if the element is not in the tree
     */
    public T find(T targetElement) throws ElementNotFoundException
    {
        BinaryTreeNode<T> current = findNode(targetElement, root);

        if (current == null)
            throw new ElementNotFoundException("LinkedBinaryTree");

        return (current.getElement());
    }

    /**
     * Returns a reference to the specified target element if it is
     * found in this binary tree.
     *
     * @param targetElement the element being sought in this tree
     * @param next the element to begin searching from
     */
    private BinaryTreeNode<T> findNode(T targetElement, 
            BinaryTreeNode<T> next)
    {
        if (next == null)
            return null;

        if (next.getElement().equals(targetElement))
            return next;

        BinaryTreeNode<T> temp = findNode(targetElement, next.getLeft());

        if (temp == null)
            temp = findNode(targetElement, next.getRight());

        return temp;
    }

    /**
     * Returns a string representation of this binary tree showing
     * the nodes in an inorder fashion.
     *
     * @return a string representation of this binary tree
     */
    public String toString() 
    {
        // To be completed as a Programming Project
        
        // create an unordered list to store all node's element from tree 
        ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
        
        // Performs a recursive inorder traversal from root
        inOrder(root, tempList);
        
        // return string representation of each element
        return tempList.toString();
    }

    /**
     * Returns an iterator over the elements in this tree using the 
     * iteratorInOrder method
     *
     * @return an in order iterator over this binary tree
     */
    public Iterator<T> iterator()
    {
        return iteratorInOrder();
    }

    /**
     * Performs an inorder traversal on this binary tree by calling an
     * overloaded, recursive inorder method that starts with
     * the root.
     *
     * @return an in order iterator over this binary tree
     */
    public Iterator<T> iteratorInOrder()
    {
        ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
        inOrder(root, tempList);

        return new TreeIterator(tempList.iterator());
    }

    /**
     * Performs a recursive inorder traversal.
     *
     * @param node the node to be used as the root for this traversal
     * @param tempList the temporary list for use in this traversal
     */
    protected void inOrder(BinaryTreeNode<T> node, 
            ArrayUnorderedList<T> tempList) 
    {
        if (node != null)
        {
            inOrder(node.getLeft(), tempList);
            tempList.addToRear(node.getElement());
            inOrder(node.getRight(), tempList);
        }
    }

    /**
     * Performs an preorder traversal on this binary tree by calling 
     * an overloaded, recursive preorder method that starts with
     * the root.
     *
     * @return a pre order iterator over this tree
     */
    public Iterator<T> iteratorPreOrder() 
    {
        // To be completed as a Programming Project
        
        // create unordered list to store node from tree 
        ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
        // perform pre order traversal
        preOrder(root, tempList);
        // return tree irerator to iterate through each node
        return new TreeIterator(tempList.iterator());
    }

    /**
     * Performs a recursive preorder traversal.
     *
     * @param node the node to be used as the root for this traversal
     * @param tempList the temporary list for use in this traversal
     */
    protected void preOrder(BinaryTreeNode<T> node, ArrayUnorderedList<T> tempList) 
    {
        if (node != null)
        {
            tempList.addToRear(node.getElement());
            inOrder(node.getLeft(), tempList);
            inOrder(node.getRight(), tempList);
        }
    }

    /**
     * Performs an postorder traversal on this binary tree by calling
     * an overloaded, recursive postorder method that starts
     * with the root.
     *
     * @return a post order iterator over this tree
     */
    public Iterator<T> iteratorPostOrder() 
    {
        // To be completed as a Programming Project
        
        // create unordered list to store node from tree 
        ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
        // perform pre order traversal
        postOrder(root, tempList);
        // return tree irerator to iterate through each node
        return new TreeIterator(tempList.iterator());
    }

    /**
     * Performs a recursive postorder traversal.
     *
     * @param node the node to be used as the root for this traversal
     * @param tempList the temporary list for use in this traversal
     */
    protected void postOrder(BinaryTreeNode<T> node, 
            ArrayUnorderedList<T> tempList) 
    {
        // To be completed as a Programming Project
        
        if (node != null)
        {
            postOrder(node.getLeft(), tempList);
            postOrder(node.getRight(), tempList);
            tempList.addToRear(node.getElement());
        }
    }

    /**
     * Performs a levelorder traversal on this binary tree, using a
     * templist.
     *
     * @return a levelorder iterator over this binary tree
     */
    public Iterator<T> iteratorLevelOrder() 
    {
        ArrayUnorderedList<BinaryTreeNode<T>> nodes = 
                new ArrayUnorderedList<BinaryTreeNode<T>>();
        ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
        BinaryTreeNode<T> current;

        nodes.addToRear(root);

        while (!nodes.isEmpty()) 
        {
            current = nodes.removeFirst();

            if (current != null)
            {
                tempList.addToRear(current.getElement());
                if (current.getLeft() != null)
                    nodes.addToRear(current.getLeft());
                if (current.getRight() != null)
                    nodes.addToRear(current.getRight());
            }
            else
                tempList.addToRear(null);
        }

        return new TreeIterator(tempList.iterator());
    }

    /**
     * Inner class to represent an iterator over the elements of this tree
     */
    private class TreeIterator implements Iterator<T>
    {
        private int expectedModCount;
        private Iterator<T> iter;

        /**
         * Sets up this iterator using the specified iterator.
         *
         * @param iter the list iterator created by a tree traversal
         */
        public TreeIterator(Iterator<T> iter)
        {
            this.iter = iter;
            expectedModCount = modCount;
        }

        /**
         * Returns true if this iterator has at least one more element
         * to deliver in the iteration.
         *
         * @return  true if this iterator has at least one more element to deliver
         *          in the iteration
         * @throws  ConcurrentModificationException if the collection has changed
         *          while the iterator is in use
         */
        public boolean hasNext() throws ConcurrentModificationException
        {
            if (!(modCount == expectedModCount))
                throw new ConcurrentModificationException();

            return (iter.hasNext());
        }

        /**
         * Returns the next element in the iteration. If there are no
         * more elements in this iteration, a NoSuchElementException is
         * thrown.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iterator is empty
         */
        public T next() throws NoSuchElementException
        {
            if (hasNext())
                return (iter.next());
            else 
                throw new NoSuchElementException();
        }

        /**
         * The remove operation is not supported.
         * 
         * @throws UnsupportedOperationException if the remove operation is called
         */
        public void remove()
        {
            throw new UnsupportedOperationException();
        }
    }
}

