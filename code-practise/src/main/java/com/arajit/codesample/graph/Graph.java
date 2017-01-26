package com.arajit.codesample.graph;

import java.util.Scanner;

public class Graph {
	private static boolean[][] adjMatrix=null;
	
	private static Node[] adjList=null;
	
	static class Node{
		int V;
		Node next;
		Node(int V,Node t){
			this.V=V;
			this.next=t;
		}
	}
	
	public static void printAdjacencyList(){
		for(int i=0;i<adjList.length;i++){
			System.out.print(i+"-->");
			Node cur=adjList[i];
			while(null!=cur){
				System.out.print(cur.V+" ");
				cur=cur.next;
			}
			System.out.println();
		}
	}
	public static void adjacencyList(){
		int v=3,e=3;
		adjList=new Node[v];
		for(int i=0;i<v;i++)
			adjList[i]=null;
		Scanner scanner=new Scanner(System.in);
		while(scanner.hasNextInt()){			
			int i=scanner.nextInt();
			if(i==99)
				break;
			int j=0;
			if (scanner.hasNextInt()){
	            j=scanner.nextInt();	            
			}
			//System.out.println(i+":"+j);
			adjList[i]=new Node(j,adjList[i]);
			adjList[j]=new Node(i,adjList[j]);
			
			
					
		}
		scanner.close();
		printAdjacencyList();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//adjacencyMatrix();
		adjacencyList();
	}
	
	public static void adjacencyMatrix(){
		
		int v=3,e=3;
		adjMatrix=new boolean[v][v];
		for(int i=0;i<v;i++)
			for(int j=0;j<v;j++)
				adjMatrix[i][j]=false;
		for(int i=0;i<v;i++)
			adjMatrix[i][i]=true;
		printMatrix();
		Scanner scanner=new Scanner(System.in);
		while(scanner.hasNextInt()){			
			int i=scanner.nextInt();
			if(i==99)
				break;
			int j=0;
			if (scanner.hasNextInt()){
	            j=scanner.nextInt();	            
			}
			adjMatrix[i][j]=true;
			adjMatrix[j][i]=true;					
		}
		scanner.close();
		printMatrix();
		
	}
	
	public static void printMatrix(){
		for(int i=0;i<adjMatrix.length;++i){
			for(int j=0;j<adjMatrix[i].length;++j)
				System.out.print(adjMatrix[i][j]+" ");			
			System.out.println();
		}		
	}
	
	

}
