package leetCode_2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LevelOrderBT_107 {
	public static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		System.out.println(levelOrderBottomDFS(root));

	}
	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
		
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(root==null) return res;
		List<Integer> l = new ArrayList<Integer>();
		l.add(root.val);
		res.add(l);
		if(root.left==null&&root.right==null) return res;
		List<List<Integer>> left = levelOrderBottom(root.left);
		List<List<Integer>> right = levelOrderBottom(root.right);
		if(left==null) {
			for(List<Integer> list:right) res.add(0, list);
			return res;
		}
		if(right==null) {
			for(List<Integer> list:left) res.add(0, list);
			return res;
		}
		int leftSize = left.size();
		int rightSize = right.size();
		for(int i=0; i<Math.max(leftSize, rightSize); i++) {
			if(i>=leftSize) {
				for(int j=i; j<Math.max(leftSize, rightSize);j++) {
					res.add(0, right.get(rightSize-1-j));
				}
				return res;
			}else if(i>=rightSize) {
				for(int j=i; j<Math.max(leftSize, rightSize); j++) {
					res.add(0, left.get(leftSize-1-j));
				}
				return res;
			}
			List<Integer> ele = left.get(leftSize-1-i);
			for(int k: right.get(rightSize-1-i)) ele.add(k);
			res.add(0,ele);
		}
		return res;
	        
	}
	 public static List<List<Integer>> levelOrderBottomDFS(TreeNode root) {
         List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
         levelMaker(wrapList, root, 0);
         return wrapList;
     }
     
     public static void levelMaker(List<List<Integer>> list, TreeNode root, int level) {
         if(root == null) return;
         if(level >= list.size()) {
             list.add(0, new LinkedList<Integer>());
         }
         levelMaker(list, root.left, level+1);
         levelMaker(list, root.right, level+1);
         list.get(list.size()-level-1).add(root.val);
     }

}
