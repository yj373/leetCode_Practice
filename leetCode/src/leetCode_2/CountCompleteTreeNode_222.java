package leetCode_2;

import java.util.HashSet;
import java.util.Stack;

public class CountCompleteTreeNode_222 {
	public static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		System.out.println(countNodes(root));

	}
	public static int countNodes(TreeNode root) {
		//DFS version
//		if(root==null) return 0;
//		Stack<TreeNode> mem = new Stack<TreeNode>();
//        mem.push(root);
//        HashSet<TreeNode> visited = new HashSet<TreeNode>();
//        while(mem.size()!=0) {
//        		TreeNode n =mem.pop();
//        		if(!visited.contains(n)) visited.add(n);
//        		if(n.left!=null) mem.push(n.left);
//        		if(n.right!=null) mem.push(n.right);
//        }
//        return visited.size();
		if(root==null) return 0;
		int leftDep=0;
		int rightDep=0;
		TreeNode lNode = root.left;
		TreeNode rNode = root.right;
		while(lNode!=null) {
			leftDep++;
			lNode=lNode.left;
		}
		while(rNode!=null) {
			rightDep++;
			rNode=rNode.right;
		}
		if(leftDep==rightDep) return (1<<(leftDep+1))-1;
		else return 1+countNodes(root.left)+countNodes(root.right);
		
		
        
    }

}
