package leetCode_2;

import java.util.*;
public class pathSum2_113 {
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		System.out.println(pathSum(root,9).toString());
	}
	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(root==null) return res;
		if(root.left==null&&root.right==null) {
			if(root.val==sum) {
				List<Integer> l = new ArrayList<Integer>();
				l.add(root.val);
				res.add(l);
				return res;
			}
			return res;
		}
		boolean inL = hasPathSum(root.left, sum-root.val);
		boolean inR = hasPathSum(root.right,sum-root.val);
		if(!(inL||inR)) return res;
		
		if (inL) {
			for(List<Integer> l: pathSum(root.left, sum-root.val)) {
				l.add(0, root.val);
				res.add(l);
			}
		}
		
		if (inR) {
			for(List<Integer> l: pathSum(root.right, sum-root.val)) {
				l.add(0, root.val);
				res.add(l);
			}
		}
		return res;
        
    }
	public static boolean hasPathSum(TreeNode root, int sum) {
		if(root==null) return sum==0;
		if(root.left==null&&root.right==null) return root.val==sum;
		if(root.left==null) return hasPathSum(root.right,sum-root.val);
		else if(root.right==null) return hasPathSum(root.left, sum-root.val);
		return hasPathSum(root.right,sum-root.val)||hasPathSum(root.left, sum-root.val);
        
    }

}
