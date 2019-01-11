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
		int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14};
		tree.tree1 = createBinaryTree(arr, tree.tree1, 0);
		
		System.out.println("Tree1::");
		tree.root.left.left = new Node(4);
		System.out.print("Post Order::");
		postOrder(tree.tree1);
		System.out.print("\nIn Order::");
		inOrder(tree.tree1);
		System.out.print("\nPre Order::");
		preOrder(tree.tree1);
		System.out.println("\nLeavs of Tree1");
		printLeaves(tree.tree1);
		
		System.out.println("\n All left outer Nodes");
		printLeftNodes(tree.tree1);
		
		System.out.println("\n All right outer Nodes");
		printRightNodes(tree.tree1);
		
		printTreeMirror(tree.tree1);
		System.out.print("\nPost Order::");
		postOrder(tree.tree1);
		
		
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
	
	public static void printLeaves(Node root) {
		if(root == null) {
			return;
		}
		if(root.left == null && root.right == null) {
			System.out.print(root.data + " ");
		}
		printLeaves(root.left);
		printLeaves(root.right);
	}
	
	public static void printLeftNodes(Node node) {
		if(node == null) {
			return;
		}
		System.out.print(node.data + " ");
		if(node.left != null) {
			printRightNodes(node.left);
		}else {
			printRightNodes(node.right);
		}
	}
	public static void printRightNodes(Node node) {
		if(node == null) {
			return;
		}
		System.out.print(node.data + " ");
		if(node.right != null) {
			printRightNodes(node.right);
		}else {
			printRightNodes(node.left);
		}
	}
	public static void printTreeMirror(Node node) {
		if(node == null) {
			return;
		}
		Node temp = node.left;
		node.left = node.right;
		node.right = temp;
		printTreeMirror(node.left);
		printTreeMirror(node.right);
		
		
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