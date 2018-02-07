package leetCode_2;

public class sortedArrayToBST {
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public TreeNode sortedArrayToBST(int[] nums) {
		int len=nums.length;
		if(len==0) return null;
		if(len==1) return new TreeNode(nums[0]);
		int rootV=0;
		rootV = nums[len/2];
		TreeNode root = new TreeNode(rootV);
		if(len%2==1) {
			int[] left = new int[len/2];
			int[] right = new int[len/2];
			for(int i=0; i<len; i++) {
				if(i<len/2) left[i]=nums[i];
				if(i>len/2) right[i-(len/2+1)]=nums[i];
			}
			root.left=sortedArrayToBST(left);
			root.right=sortedArrayToBST(right);
		} else {
			int[] left = new int[len/2];
			int[] right = new int[len/2-1];
			for(int i=0; i<len; i++) {
				if(i<len/2) left[i]=nums[i];
				if(i>len/2) right[i-(len/2+1)]=nums[i];
			}
			root.left=sortedArrayToBST(left);
			root.right=sortedArrayToBST(right);
		}
		return root;
        
    }

}
