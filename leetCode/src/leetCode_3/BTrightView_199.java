package leetCode_3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class BTrightView_199 {
	public static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		System.out.println(rightSideView(root));

	}
	public static List<Integer> rightSideView(TreeNode root) {
		
		List<Integer> res = new ArrayList<Integer>();
		if(root==null) return res;
		res.add(root.val);
		Stack<TreeNode> mem = new Stack<TreeNode>();
		HashSet<TreeNode> visited = new HashSet<TreeNode>();
		int threshold = 1;
		mem.add(root);
		while(!mem.isEmpty()) {
			TreeNode node = mem.peek();
			if(!visited.contains(node)) visited.add(node);
			if(node.right!=null&&!visited.contains(node.right)) {
				mem.push(node.right);
				if(mem.size()>threshold) {
					res.add(node.right.val);
					threshold++;
				}
			}else if(node.left!=null&&!visited.contains(node.left)) {
				mem.push(node.left);
				if(mem.size()>threshold) {
					res.add(node.left.val);
					threshold++;
				}
			}else mem.pop();
		}
		
		return res;
	        
	}

}
