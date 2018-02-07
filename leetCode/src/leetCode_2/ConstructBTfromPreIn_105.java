package leetCode_2;

public class ConstructBTfromPreIn_105 {
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if(preorder.length!=inorder.length) return null;
		int len=preorder.length;
		if(len==0) return null;
		int rootVal = preorder[0];
		if(len==1) return new TreeNode(rootVal);
		int rootIndex=0;
		for(int i=0; i<len; i++) {
			if(inorder[i]==rootVal) {
				rootIndex=i;
				break;
			}
		}
		int[]leftInorder = new int[rootIndex];
		int[]rightInorder = new int[len-1-rootIndex];
		for(int i=0;i<len;i++) {
			if(i<rootIndex) leftInorder[i]=inorder[i];
			if(i>rootIndex) rightInorder[i-rootIndex-1]=inorder[i];
		}
		int[]leftPreorder = new int[rootIndex];
		int[]rightPreorder = new int[len-1-rootIndex];
		for(int i=1;i<len; i++) {
			if(i<=rootIndex) leftPreorder[i-1]=preorder[i];
			if(i>rootIndex) rightPreorder[i-rootIndex-1]=preorder[i];
		}
		TreeNode root = new TreeNode(rootVal);
		root.left=buildTree(leftPreorder, leftInorder);
		root.right=buildTree(rightPreorder, rightInorder);
		return root;
        
    }

}
