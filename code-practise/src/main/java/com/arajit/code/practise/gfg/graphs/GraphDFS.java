/*
 * FOR INTERNAL USE ONLY. NOT A CONTRIBUTION.
 *
 * This software source code contains valuable, confidential, trade secret information owned by
 * Enterprise Rent-A-Car Company and is protected by copyright laws and international copyright
 * treaties, as well as other intellectual property laws and treaties.
 *
 * ACCESS TO AND USE OF THIS SOURCE CODE IS RESTRICTED TO AUTHORIZED PERSONS WHO HAVE ENTERED INTO
 * CONFIDENTIALITY AGREEMENTS WITH ENTERPRISE RENT-A-CAR COMPANY.
 *
 * This source code may not be licensed, disclosed or used except as authorized in writing by a duly
 * authorized officer of Enterprise Rent-A-Car Company.
 *
 */
package com.arajit.code.practise.gfg.graphs;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * This class represents a directed graph using adjacency list representation.
 */
public class GraphDFS {

  private int vertices; // No. of vertices
  private LinkedList<Integer> adj[]; // Adjacency Lists

  // Constructor
  GraphDFS(int v) {
    this.vertices = v;
    adj = new LinkedList[v];
    for (int i = 0; i < v; ++i)
      adj[i] = new LinkedList<Integer>();
  }

  // Function to add an edge into the graph
  void addEdge(int v, int w) {
    adj[v].add(w);
  }

  // A function used by DFS
  void DFSUtil(int v, boolean visited[]) {
    // Mark the current node as visited and print it
    visited[v] = true;
    System.out.print(v + " ");

    // Recur for all the vertices adjacent to this vertex
    Iterator<Integer> i = adj[v].listIterator();
    while (i.hasNext()) {
      int n = i.next();
      if (!visited[n])
        DFSUtil(n, visited);
    }
  }

  // The function to do DFS traversal. It uses recursive DFSUtil()
  void DFS(int v) {
    // Mark all the vertices as not visited(set as
    // false by default in java)
    boolean visited[] = new boolean[vertices];

    // Call the recursive helper function to print DFS traversal
    DFSUtil(v, visited);
  }


  // Driver method to
  public static void main(String args[]) {
    GraphDFS g = new GraphDFS(4);

    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 2);
    g.addEdge(2, 0);
    g.addEdge(2, 3);
    g.addEdge(3, 3);

    System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");

    g.DFS(2);
  }

}
