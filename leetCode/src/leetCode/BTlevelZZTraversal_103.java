package leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import leetCode.BTlevelTraversal_102.TreeNode;

public class BTlevelZZTraversal_103 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		System.out.println(zigzagLevelOrder(root).toString());
	}
	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(root==null) return res;
		List<Integer> a = new ArrayList<Integer>();
		a.add(root.val);
		res.add(a);
		if(root.left==null&&root.right==null) return res;
		if(root.left==null&&root.right!=null) {
			for (List<Integer> l: zigzagLevelOrder(root.right)) {
				Collections.reverse(l);
				res.add(l);
			}
			return res;
		}else if(root.left!=null&&root.right==null) {
			for(List<Integer> l:zigzagLevelOrder(root.left)) {
				Collections.reverse(l);
				res.add(l);
			}
			return res;
		}
		List<List<Integer>> resL = zigzagLevelOrder(root.left);
		List<List<Integer>> resR = zigzagLevelOrder(root.right);
		int size = Math.max(resL.size(), resR.size());
		for (int i=0; i<size; i++) {
			if(i>=resL.size()) {
				for (int j=i; j<size; j++) {
					List<Integer> l =resR.get(j);
					Collections.reverse(l);
					res.add(l);
				}
				return res;
			}else if(i>=resR.size()) {
				for(int j=i; j<size;j++) {
					List<Integer> l =resL.get(j);
					Collections.reverse(l);
					res.add(l);
				}
				return res;
			}else {
				List<Integer> ele = new ArrayList<Integer>();
				List<Integer> r = resR.get(i);
				List<Integer> l = resL.get(i);
				Collections.reverse(r);
				Collections.reverse(l);
				if (i%2==0) {
					for (int k: r) ele.add(k);
					for (int k: l) ele.add(k);
				}else {
					for (int k: l) ele.add(k);
					for (int k: r) ele.add(k);
				}
				
				res.add(ele);
			}
			
		}
		return res;
        
    }
}
