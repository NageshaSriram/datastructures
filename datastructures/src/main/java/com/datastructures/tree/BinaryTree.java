package com.datastructures.tree;

public class BinaryTree {
	Node root;
	Node tree1;

	BinaryTree() {
		root = null;
		tree1 = null;
	}

	BinaryTree(int data) {
		root = new Node(data);
	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();

		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		System.out.print("Post Order::");
		postOrder(tree.root);
		System.out.print("\nIn Order::");
		inOrder(tree.root);
		System.out.print("\nPre Order::");
		preOrder(tree.root);

		System.out.println("Create tree using Array of elements");
		int[] arr = {25,15,50,10,22,35,70,4,12,18,24,31,44,66,90};
		tree.tree1 = createBinaryTree(arr, tree.tree1, 0);
		
		System.out.println("Tree1::");
		tree.root.left.left = new Node(4);
		System.out.print("Post Order::");
		postOrder(tree.tree1);
		System.out.print("\nIn Order::");
		inOrder(tree.tree1);
		System.out.print("\nPre Order::");
		preOrder(tree.tree1);
		
	}

	public static void postOrder(Node node) {
		if (node != null) {
			postOrder(node.left);
			postOrder(node.right);
			System.out.print(node.data + " ");
		}
	}
	
	public static void inOrder(Node node) {
		if (node != null) {
			inOrder(node.left);
			System.out.print(node.data + " ");
			inOrder(node.right);
		}
	}
	
	public static void preOrder(Node node) {
		if (node == null) {
			return;
		}
			System.out.print(node.data + " ");
			preOrder(node.left);
			preOrder(node.right);
	}
	
	public static Node createBinaryTree(int[] arr, Node root, int i) {
		if(i<arr.length) {
			Node node = new Node(arr[i]);
			
			root = node;
			
			root.left = createBinaryTree(arr, root.left, (2*i + 1));
			root.right = createBinaryTree(arr, root.right, (2*i + 2));
			
		}
		return root;
		
	}

}

class Node {
	int data;
	Node left, right;

	public Node(int data) {
		this.data = data;
		left = right = null;
	}
}