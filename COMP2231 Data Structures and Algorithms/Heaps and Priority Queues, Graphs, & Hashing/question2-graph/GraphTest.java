//*********************************************************************************************************************************************************************************************************************
// GraphTest.java 
//
// Koki Yamanaka (T00681865)
// COMP 2231 Assignment 5 - Question 2 Graph 
// GraphTest.java - The program is the test case for Graph.java   
////*****************************************************************************************************************************************************************************************

import java.util.*;

public class GraphTest {
    public static void main(String[] args) {
        // create new graph
        Graph graph = new Graph();

        // create array of vertices
        String[] vertices = { "A", "B", "C", "D", "E"};

        // add vertices to graph
        for (String vertex : vertices)
            graph.addVertex(vertex);

        // print the graph and check its connectivity, isEmpty, and size methods
        System.out.print(graph); 
        System.out.println("connected ? " + graph.isConnected());
        System.out.println("empty? " + graph.isEmpty());
        System.out.println("size? " + graph.size());
        System.out.println();
        
        // add edges so graph is connected 
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("A", "D");
        graph.addEdge("B", "C");
        graph.addEdge("B", "D");
        graph.addEdge("C", "D");

        // print the graph and check its connectivity, isEmpty, and size methods
        System.out.print(graph); 
        System.out.println("connected ? " + graph.isConnected());
        System.out.println("empty? " + graph.isEmpty());
        System.out.println("size? " + graph.size());
        System.out.println();
        
        // remove 3 edges from graph
        graph.removeEdge("D", "A");
        graph.removeEdge("C", "D");
        graph.removeEdge("B", "D");
        
        // print the graph and check its connectivity, isEmpty, and size methods
        System.out.print(graph); 
        System.out.println("connected ? " + graph.isConnected());
        System.out.println("empty? " + graph.isEmpty());
        System.out.println("size? " + graph.size());
        System.out.println();

        // remove last vertex 
        graph.removeVertex("D");

        // print graph and test isConnected, isEmpty, and size methods
        System.out.print(graph); 
        System.out.println("connected ? " + graph.isConnected());
        System.out.println("empty? " + graph.isEmpty());
        System.out.println("size? " + graph.size());
        System.out.println();
        
        // remove first vertex
        graph.removeVertex("A");

        // print graph and test isConnected, isEmpty, and size methods
        System.out.print(graph); 
        System.out.println("connected ? " + graph.isConnected());
        System.out.println("empty? " + graph.isEmpty());
        System.out.println("size? " + graph.size());
        System.out.println();

        // create new nodes to graph
        String[] newVertices = { "E", "F", "G"};

        // add new nodes to graph
        for (String vertex : newVertices)
            graph.addVertex(vertex);

        // connect E to every other vertex
        graph.addEdge("E", "B");
        graph.addEdge("E", "C");
        graph.addEdge("E", "F");
        graph.addEdge("E", "G");

        // print graph and test isConnected, isEmpty, and size methods
        System.out.print(graph); 
        System.out.println("connected ? " + graph.isConnected());
        System.out.println("empty? " + graph.isEmpty());
        System.out.println("size? " + graph.size());
        System.out.println();

        // add blank vertex
        System.out.println(graph.size());
        graph.addVertex();
        System.out.println(graph.size());
        System.out.println();

        // check indexIsValid method
        System.out.println(graph.indexIsValid(-1));
        System.out.println(graph.indexIsValid(90));
        System.out.println(graph.indexIsValid(4));
        System.out.println();

        // check getVertices method
        System.out.print(Arrays.toString(graph.getVertices()));
    }
}
