package leetCode_2;

import java.util.HashSet;
import java.util.Stack;

public class simRootOfLeafNums_129 {
	public static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(1);
		root.right = new TreeNode(2);
		System.out.println(sumNumbers(root));

	}
	public static int sumNumbers(TreeNode root) {
		//DFS, 注意向栈中加点时要检验是否visited, 并且注意最后两种情况的分类
		if(root==null)return 0;
		if(root.left==null&&root.right==null) return root.val;
		Stack<TreeNode> mem = new Stack<TreeNode>();
		HashSet<TreeNode> visited = new HashSet<TreeNode>();
		mem.push(root);
		int sum=0;
		int num=root.val;
		while(!mem.empty()) {
			TreeNode node =mem.peek();
			if(!visited.contains(node)) visited.add(node);
			
			if(node.right!=null&&!visited.contains(node.right)) {
				mem.push(node.right);
				num=num*10+node.right.val;
			} else if(node.left!=null&&!visited.contains(node.left)) {
				mem.push(node.left);
				num=num*10+node.left.val;
			} else if(node.left==null&&node.right==null){
				sum+=num;
				num=(num-node.val)/10;
				mem.pop();
			}else {
				num=(num-node.val)/10;
				mem.pop();
			}
		}
		return sum;
        
    }

}
