package com.gl.labsession3;

import java.util.ArrayList;

public class LongestPath {

	static Node root;

	static class Node {
		int data;
		Node left, right;
	}

	static Node newNode(int el) {
		Node n = new Node();
		n.data = el;
		n.left = n.right = null;

		return n;
	}

	ArrayList<Integer> findPath(Node root) {
		if (root == null) // reach the leaf node
			return (new ArrayList<Integer>());

		/*
		 * store the result of left and right traversals in left and right lists
		 * respectively
		 */
		ArrayList<Integer> left = findPath(root.left);
		ArrayList<Integer> right = findPath(root.right);

		/*
		 * Compare the sizes.If size of left > size of right, add root to the left list
		 * and return
		 */
		if (left.size() > right.size()) {
			left.add(root.data);
			return left;
		}

		// If size of right > size of left, add root to the right list and return
		else {
			right.add(root.data);
			return right;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestPath obj = new LongestPath();

		// Create the tree with folowing nodes (hardcoded inputs)
		root = newNode(100);
		root.left = newNode(20);
		root.right = newNode(130);
		root.left.left = newNode(10);
		root.left.right = newNode(50);
		root.right.left = newNode(110);
		root.right.right = newNode(140);
		root.left.left.left = newNode(5);

		// Store the longest path list in result ArrayList
		ArrayList<Integer> result = obj.findPath(root);

		/*
		 * print the output (Result List contains the elements in reverse order, thus
		 * print the list in reverse
		 */
		System.out.print("Longest path ");
		int i;
		for (i = result.size() - 1; i > 0; i--) {
			System.out.print(result.get(i) + " --> ");
		}
		System.out.println(result.get(i));

	}

}
