package leetCode_2;

public class BalancedBT_110 {
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public boolean isBalanced(TreeNode root) {
		if (root==null) return true;
		if (root.left==null) return maxDepth(root.right)<=1;
		if (root.right==null) return maxDepth(root.left)<=1;
		int dL = maxDepth(root.left);
		int dR = maxDepth(root.right);
		return Math.abs(dL-dR)<=1&&isBalanced(root.left)&&isBalanced(root.right);
    }
	public int maxDepth(TreeNode root) {
		if(root==null) return 0;
		if (root.left==null) return 1+maxDepth(root.right);
		if (root.right==null) return 1+maxDepth(root.left);
		return 1+Math.max(maxDepth(root.right), maxDepth(root.left));
	        
	}

}
