package leetCode;

public class SameTree_100 {
	public static class TreeNode {
		     int val;
		     TreeNode left;
		     TreeNode right;
		     TreeNode(int x) { val = x; }
		 }
	public boolean isSameTree(TreeNode p, TreeNode q) {
		 if (p==null&&q==null) return true;
	     if ((p==null&&q!=null)||(p!=null&&q==null)) return false;
	     if (p.val!=q.val) return false;
	     return isSameTree(p.left, q.left)&&isSameTree(q.right, p.right);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		n1.left=n2;
		n1.right=n3;
		TreeNode n_ = new TreeNode(1);
		n_.left=n2;
		n_.right=n3;
		
	}
}
