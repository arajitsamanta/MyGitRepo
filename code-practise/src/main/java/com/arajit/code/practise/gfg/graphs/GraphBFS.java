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
public class GraphBFS {

  private int vertices; // No. of vertices
  private LinkedList<Integer> adj[]; // Adjacency Lists

  // Constructor
  GraphBFS(int v) {
    this.vertices = v;
    adj = new LinkedList[v];
    for (int i = 0; i < v; ++i)
      adj[i] = new LinkedList<Integer>();
  }

  // Function to add an edge into the graph
  void addEdge(int v, int w) {
    adj[v].add(w);
  }

  // prints BFS traversal from a given source s
  void BFS(int s) {
    // Mark all the vertices as not visited(By default
    // set as false)
    boolean visited[] = new boolean[vertices];

    // Create a queue for BFS
    LinkedList<Integer> queue = new LinkedList<Integer>();

    // Mark the current node as visited and enqueue it
    visited[s] = true;
    queue.add(s);

    while (queue.size() != 0) {
      // Dequeue a vertex from queue and print it
      s = queue.poll();
      System.out.print(s + " ");

      // Get all adjacent vertices of the dequeued vertex s
      // If a adjacent has not been visited, then mark it
      // visited and enqueue it
      Iterator<Integer> i = adj[s].listIterator();
      while (i.hasNext()) {
        int n = i.next();
        if (!visited[n]) {
          visited[n] = true;
          queue.add(n);
        }
      }
    }
  }
  
//Driver method to
  public static void main(String args[])
  {
      GraphBFS g = new GraphBFS(4);

      g.addEdge(0, 1);
      g.addEdge(0, 2);
      g.addEdge(1, 2);
      g.addEdge(2, 0);
      g.addEdge(2, 3);
      g.addEdge(3, 3);

      System.out.println("Following is Breadth First Traversal "+
                         "(starting from vertex 2)");

      g.BFS(2);
  }

}
