package leetCode_2;

import java.util.HashSet;
import java.util.Stack;

public class MinDepthOfBT_111 {
	public static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(-9);
		root.left = new TreeNode(-3);
		root.right = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.left.right.left = new TreeNode(-6);
		root.right.right = new TreeNode(0);
		root.right.left = new TreeNode(4);
		root.right.left.left = new TreeNode(-5);
		System.out.println(minDepth(root));
		

	}
	public static int minDepth(TreeNode root) {
		 if(root==null) return 0;
	        if(root.left==null&&root.right==null) return 1;
	        Stack<TreeNode> mem = new Stack<TreeNode>();
			HashSet<TreeNode> visited = new HashSet<TreeNode>();
			mem.push(root);
			int min=-1;
			
			
			while(!mem.isEmpty()) {
				TreeNode node = mem.peek();
				if(!visited.contains(node)) visited.add(node);
				if(node.right!=null&&!visited.contains(node.right)) {
					mem.push(node.right);
				}else if(node.left!=null&&!visited.contains(node.left)) {
					mem.push(node.left);
				}else if(node.left==null&&node.right==null) {
					if(mem.size()<min||min==-1) min=mem.size();
					mem.pop();
				}else mem.pop();
			}
			return min;
        
    }

}
