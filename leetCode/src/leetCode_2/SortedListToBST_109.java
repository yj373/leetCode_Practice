package leetCode_2;

public class SortedListToBST_109 {
	public static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }
	public static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(-10);
		head.next = new ListNode(-3);
		head.next.next = new ListNode(0);
		head.next.next.next = new ListNode(5);
		head.next.next.next.next = new ListNode(9);
		TreeNode re = sortedListToBST(head);

	}
	public static TreeNode sortedListToBST(ListNode head) {
		if(head==null) return null;
		if(head.next==null) return new TreeNode(head.val);
		ListNode slow=head;
		ListNode fast=head;
		ListNode prev=null;
		while(fast.next!=null&&fast.next.next!=null) {
			prev=slow;
			slow=slow.next;
			fast=fast.next.next;
		}
		
		TreeNode root= new TreeNode(slow.val);
		if(prev!=null) {
			prev.next=null;
			root.left=sortedListToBST(head);
			root.right=sortedListToBST(slow.next);
		}else {
			root.right=sortedListToBST(slow.next);
		}
		return root;
        
    }

}
