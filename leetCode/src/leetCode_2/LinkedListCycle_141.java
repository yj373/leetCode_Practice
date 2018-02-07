package leetCode_2;

public class LinkedListCycle_141 {
	//include 142
	class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) {
		          val = x;
		          next = null;
		      }
		  }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public boolean hasCycle(ListNode head) {
	     if(head==null) return false;
	     ListNode slow=head;
	     ListNode fast=head;
	     while(fast.next!=null&&fast.next.next!=null) {
	    	 	slow=slow.next;
	    	 	fast=fast.next.next;
	    	 	if(fast==slow) return true;
	     }
	     return false;
	}
	public ListNode detectCycle(ListNode head) {
		if(!hasCycle(head)) return null;
		ListNode slow=head;
	    ListNode fast=head;
	  
	    while(fast.next!=null&&fast.next.next!=null) {
	    	 	slow=slow.next;
	    	 	fast=fast.next.next;
	    	 	if(fast==slow) {
	    	 		ListNode slow2=head;
	    	 		while(slow2!=slow) {
	    	 			slow2=slow2.next;
	    	 			slow=slow.next;
	    	 		}
	    	 		return slow;
	    	 	}
	    }
	    return null;
	    
	    
		
    }

}
