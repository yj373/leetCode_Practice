package leetCode;
import leetCode.BTlevelTraversal_102.TreeNode;

public class maximumDepthBT_104 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
	}
	
	
	public int maxDepth(TreeNode root) {
		if(root==null) return 0;
		if (root.left==null) return 1+maxDepth(root.right);
		if (root.right==null) return 1+maxDepth(root.left);
		return 1+Math.max(maxDepth(root.right), maxDepth(root.left));
	        
	}
}
