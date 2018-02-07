package leetCode;

public class symmetricTree_101 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(3);
		System.out.println(isSymmetric(root));

	}
	public static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
	}
	public static boolean isSymmetric(TreeNode root) {
		if(root==null) return true;
		TreeNode res = antiSym(root.left);
		return isSame(res,root.right);
	        
	}
	public static boolean isSame(TreeNode tree1, TreeNode tree2) {
		if (tree1==null&&tree2==null) return true;
		if ((tree1==null&&tree2!=null)||(tree1!=null&&tree2==null)) return false;
		return tree1.val==tree2.val&&isSame(tree1.left, tree2.left)&&isSame(tree1.right, tree2.right);
	}
	public static TreeNode antiSym(TreeNode tree) {
		if (tree==null) return null; 
		TreeNode left = tree.left;
		TreeNode right = tree.right;
		if (left==null) tree.right=null;
		else {
			tree.right=antiSym(left);
		}
		if (right==null) tree.left=null;
		else {
			tree.left=antiSym(right);
		}
		return tree;
	}
}
