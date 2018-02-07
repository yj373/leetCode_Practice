package leetCode_2;

import leetCode_2.ConstructBTfromPreIn_105.TreeNode;

public class ConstructBTfromInpos_106 {
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] inorder= {2,1};
		int[] postorder= {2,1};
		TreeNode res = buildTree(inorder, postorder);
		System.out.println(res.val);
	}
	public static TreeNode buildTree(int[] inorder, int[] postorder) {
		/*可用hashMap提前将inorder中的值和index存储起来
		 * */
		if(postorder.length!=inorder.length) return null;
		int len=postorder.length;
		if(len==0) return null;
		int rootVal = postorder[len-1];
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
		int[]leftPostorder = new int[rootIndex];
		int[]rightPostorder = new int[len-1-rootIndex];
		for(int i=0;i<len-1; i++) {
			if(i<rootIndex) leftPostorder[i]=postorder[i];
			if(i>=rootIndex) rightPostorder[i-rootIndex]=postorder[i];
		}
		TreeNode root = new TreeNode(rootVal);
		root.left=buildTree(leftInorder, leftPostorder);
		root.right=buildTree(rightInorder, rightPostorder);
		return root; 
	        
	 }

}
