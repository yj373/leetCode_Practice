package leetCode;

import java.util.ArrayList;

public class SerializeBST_449 {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		TreeNode left = new TreeNode(1);
		TreeNode right = new TreeNode(3);
		root.left = left;
		root.right = right;
		TreeNode res = deserialize(serialize(root));
		System.out.println(res.val);
		System.out.println(res.left.val);
		System.out.println(res.right.val);

	}
	public static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	public static String serialize(TreeNode root) {
		
		String res = "";
		if (root==null) return res;
		String s = String.valueOf(root.val);
		res=res.concat(" ");
		res=res.concat(s);
		res=res.concat(serialize(root.left));
		res=res.concat(serialize(root.right));
		return res;
        
    }
	public static TreeNode deserialize(String data) {
		if (data.length()==0) return null;
		ArrayList<Integer> data_2 = new ArrayList<Integer>();
		ArrayList<Integer> spaceIndex = new ArrayList<Integer>();
		char[] c = data.toCharArray();
		for (int i=0; i<c.length; i++) {
			if (c[i]==' ') spaceIndex.add(i);
		}
		for (int i=0; i<spaceIndex.size(); i++) {
			int ele;
			if (i==spaceIndex.size()-1) {
				ele = Integer.parseInt(data.substring(spaceIndex.get(i)+1));
				data_2.add(ele);
			}else {
				ele = Integer.parseInt(data.substring(spaceIndex.get(i)+1, spaceIndex.get(i+1)));
				data_2.add(ele);
			}	
		}
		int root = data_2.get(0);
		if (data_2.size()==1) return new TreeNode(root);
		TreeNode res = new TreeNode(root);
		if (data_2.get(1)>=root) {
			res.left=null;
			String rec = data.substring(spaceIndex.get(1));
			res.right= deserialize (rec);
			return res;
		}else {
			int rightRoot = data.length();
			for (int i=1; i<data_2.size(); i++) {
				if (data_2.get(i)>=root) {
					rightRoot = spaceIndex.get(i);
					break;
				}
			}
			String rec_l = data.substring(spaceIndex.get(1), rightRoot);
			res.left = deserialize (rec_l);
			String rec_r = data.substring(rightRoot);
			res.right = deserialize (rec_r);
			return res;
		}
        
    }
}
