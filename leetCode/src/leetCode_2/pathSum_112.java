package leetCode_2;

public class pathSum_112 {
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public boolean hasPathSum(TreeNode root, int sum) {
		if(root==null) return false;
		if(root.left==null&&root.right==null) return root.val==sum;
		if(root.left==null) return hasPathSum(root.right,sum-root.val);
		else if(root.right==null) return hasPathSum(root.left, sum-root.val);
		return hasPathSum(root.right,sum-root.val)||hasPathSum(root.left, sum-root.val);
        
    }

}
