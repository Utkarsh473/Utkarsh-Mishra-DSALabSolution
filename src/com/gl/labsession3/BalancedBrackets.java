package com.gl.labsession3;

import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// create object of Balanced Bracket class
		BalancedBrackets obj = new BalancedBrackets();

		String balancedExpression;

		// Take user input
		System.out.println("Enter the string to be checked");
		balancedExpression = sc.next();

		// Print output
		if (obj.isBalanced(balancedExpression)) {
			System.out.println("The entered string has balanced brackets");
		}

		else {
			System.out.println("The entered string does not contain balanced brackets");
		}

	}

	boolean isBalanced(String str) {

		Stack<Character> stack = new Stack<Character>();

		int i = 0;
		char c;

		// iterate through the characters
		while (i < str.length()) {

			// store the character at index i in a variable
			c = str.charAt(i);

			// check if character is '(' or '{' or '['
			if (c == '(' || c == '{' || c == '[') {
				// push it to the stack
				stack.push(c);
			}

			// else pop from the stack
			else {
				if (stack.empty()) // if stack is empty, this implies that the str[i] has no opening counterpart
					return false;

				char ch = stack.pop();
				/*
				 * match the popped character with the string element. If it is not the opening
				 * counterpart of string element (c), return false
				 */
				switch (c) {

				case ')':
					if (ch != '(')
						return false;
					else
						break;

				case '}':
					if (ch != '{')
						return false;
					else
						break;

				case ']':
					if (ch != '[')
						return false;
					else
						break;

				}
			}
			i++;
		}

		if (!stack.empty()) // If string is balanced, stack should be empty after string traversal
			return false;

		return true;

	}

}
