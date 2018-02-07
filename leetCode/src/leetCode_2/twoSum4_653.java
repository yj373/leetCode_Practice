package leetCode_2;

import java.util.Stack;

public class twoSum4_653 {
	public static class TreeNode {
	     int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.right.right = new TreeNode(8);
		root.right.right.left = new TreeNode(7);
		root.right.right.right = new TreeNode(9);
		System.out.print(findTarget(root,9));

	}
	public static boolean findTarget(TreeNode root, int k) {
		if(root==null) return false;
		Stack<TreeNode> l_stack = new Stack<TreeNode>();
		Stack<TreeNode> r_stack = new Stack<TreeNode>();
		stackAdd(l_stack, root, true);
		stackAdd(r_stack, root, false);
		while(l_stack.peek()!=r_stack.peek()) {
			int sum = l_stack.peek().val+r_stack.peek().val;
			if(sum==k) return true;
			else if(sum>k){
				stackNext(r_stack, false);
			}else {
				stackNext(l_stack, true);
			}
		}
		return false;
	        
	 }
	private static void stackAdd(Stack<TreeNode> st, TreeNode node, boolean isLeft) {
		while(node!=null) {
			st.push(node);
			node = (isLeft)? node.left : node.right;
		}
	}
	private static void stackNext(Stack<TreeNode> st, boolean isLeft) {
		TreeNode node = st.pop();
		if(isLeft) stackAdd(st, node.right, isLeft);
		else stackAdd(st, node.left, isLeft);
	}
}
