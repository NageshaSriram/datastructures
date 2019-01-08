package com.datastructures.tree;

public class BinaryTree {
	Node root;
	
	BinaryTree(){
		root = null;
	}
	BinaryTree(int data){
		root = new Node(data);
	}
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
	}

}
class Node{
	int data;
	Node left,right;
	
	public Node(int data) {
		this.data = data;
		left=right=null;
	}
}