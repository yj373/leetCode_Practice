package leetCode;

import java.util.ArrayList;
import java.util.List;

public class BTlevelTraversal_102 {
	public static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(-8);
		root.left = new TreeNode(-6);
		root.right = new TreeNode(7);
		root.left.left = new TreeNode(6);
		root.left.left.right = new TreeNode(5);
		System.out.println(levelOrder(root).toString());
	}
	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(root==null) return res;
		List<Integer> a = new ArrayList<Integer>();
		a.add(root.val);
		res.add(a);
		if(root.left==null&&root.right==null) return res;
		if(root.left==null&&root.right!=null) {
			for (List<Integer> l: levelOrder(root.right)) {
				res.add(l);
			}
			return res;
		}else if(root.left!=null&&root.right==null) {
			for(List<Integer> l:levelOrder(root.left)) {
				res.add(l);
			}
			return res;
		}
		List<List<Integer>> resL = levelOrder(root.left);
		List<List<Integer>> resR = levelOrder(root.right);
		int size = Math.max(resL.size(), resR.size());
		for (int i=0; i<size; i++) {
			if(i>=resL.size()) {
				for (int j=i; j<size; j++) res.add(resR.get(j));
				return res;
			}else if(i>=resR.size()) {
				for(int j=i; j<size;j++) res.add(resL.get(j));
				return res;
			}else {
				List<Integer> ele = new ArrayList<Integer>();
				for (int k: resL.get(i)) ele.add(k);
				for (int k: resR.get(i)) ele.add(k);
				res.add(ele);
			}
			
		}
		return res;
	        
	}

}
