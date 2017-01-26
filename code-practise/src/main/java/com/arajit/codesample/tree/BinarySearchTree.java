package com.arajit.codesample.tree;

import java.util.Arrays;
import java.util.Comparator;

class BinaryTreeSearch {
	/*
	 * public enum State { Visited, Unvisited, Visiting;
	 * 
	 * }
	 */

	// this is the Node used in the tree
	class Node {
		private int data;
		private Node left;
		private Node right;

		public Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public void setRight(Node right) {
			this.right = right;
		}

		public Node getLeft() {
			return this.left;
		}

		public Node getRight() {
			return this.right;
		}

		public int getData() {
			return this.data;
		}

		public boolean equals(Node n) {
			if (this.data == (int) n.getData())
				return true;
			else
				return false;
		}
	}

	public static void main(String[] args) {
		BinaryTreeSearch bts = new BinaryTreeSearch();
		bts.run();
	}

	// execute the test case
	public void run() {
		Node root = new Node(10);
		insert(root, new Node(20));
		insert(root, new Node(5));
		insert(root, new Node(4));
		insert(root, new Node(6));
		insert(root, new Node(15));
		System.out.println("In-order traveral");
		inOrderTraverse(root);
		System.out.println("\npre-order traveral");
		preOrderTraverse(root);
		System.out.println("\npost-order traveral");
		postOrderTraverse(root);

		System.out.println("\n Node:" + binarySearch(root, new Node(6)));
		
		System.out.println("\n height:" + treeHeight(root));
		
		
	}
	
	public static int treeHeight( Node n ){
		if( n == null ) return 0;
		return 1 + Math.max( treeHeight( n.getLeft() ),	treeHeight( n.getRight() ) );
	}

	// insert a node to the binary search tree
	public void insert(Node root, Node n) {
		if (root == null || n == null)
			return;

		if (root.getData() >= n.getData()) {
			if (root.getLeft() == null) {
				root.setLeft(n);
				System.out.println("Added node to left of " + root.getData()
						+ " of value " + n.getData());
			} else {
				insert(root.getLeft(), n);
			}

		} else if (root.getData() <= n.getData()) {
			if (root.getRight() == null) {
				root.setRight(n);
				System.out.println("Added node to Right of " + root.getData()
						+ " of value " + n.getData());
			} else {
				insert(root.getRight(), n);
			}

		}
	}

	// in-order Traversal
	public void inOrderTraverse(Node root) {
		if (root != null) {
			inOrderTraverse(root.getLeft());
			System.out.print("  " + root.getData());
			inOrderTraverse(root.getRight());
		}
	}

	// pre-order Traversal
	public void preOrderTraverse(Node root) {
		if (root != null) {
			System.out.print("  " + root.getData());
			preOrderTraverse(root.getLeft());
			preOrderTraverse(root.getRight());
		}
	}

	// post-order Traversal
	public void postOrderTraverse(Node root) {
		if (root != null) {
			postOrderTraverse(root.getLeft());
			postOrderTraverse(root.getRight());
			System.out.print("  " + root.getData());
		}
	}

	// binary search
	public boolean binarySearch(Node root, Node n) {
		if (root == null || n == null) {
			return false;
		}
		System.out.println("\nTesting out " + root.getData() + " for value "
				+ n.getData());
		if (root.getData() > n.getData()) {
			return binarySearch(root.getLeft(), n);
		} else if (root.getData() < n.getData()) {
			return binarySearch(root.getRight(), n);
		}
		return true;
	}
	
	Node findLowestCommonAncestor(Node root, int value1, int value2) {
		while (root != null) {
			int value = root.getData();
			if (value > value1 && value > value2) {
				root = root.getLeft();
			} else if (value < value1 && value < value2) {
				root = root.getRight();
			} else {
				return root;
			}
		}
		return null; // only if empty tree
	}
	
	public static Node heapifyBinaryTree(Node root) {
		int size = traverse(root, 0, null); // Count nodes
		Node[] nodeArray = new Node[size];
		traverse(root, 0, nodeArray);
		// Load nodes into array
		// Sort array of nodes based on their values, using Comparator object
		Arrays.sort(nodeArray, new Comparator<Node>() {
			@Override
			public int compare(Node m, Node n) {
				int mv = m.getData(), nv = n.getData();
				return (mv < nv ? -1 : (mv == nv ? 0 : 1));
			}
		});
		// Reassign children for each node
		for (int i = 0; i < size; i++) {
			int left = 2 * i + 1;
			int right = left + 1;
			nodeArray[i].setLeft(left >= size ? null : nodeArray[left]);
			nodeArray[i].setRight(right >= size ? null : nodeArray[right]);
		}
		return nodeArray[0]; // Return new root node
	}

	public static int traverse(Node node, int count, Node[] arr) {
		if (node == null)
			return count;
		if (arr != null)
			arr[count] = node;
		count++;
		count = traverse(node.getLeft(), count, arr);
		count = traverse(node.getRight(), count, arr);
		return count;
	}

}