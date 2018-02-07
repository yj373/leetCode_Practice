package leetCode;

public class AddTwoNumbers_2 {

	public static void main(String[] args) {
		

	}
	public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
	}
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		/*divide and concur recurrence
		 * */
		if(l1==null) {
			return l2;
		}
		if(l2==null) {
			return l1;
		}
		
		int sum =l1.val+l2.val;
		ListNode result = new ListNode((sum)%10);
		if(sum<10) {
			result.next= addTwoNumbers(l1.next,l2.next);
		}else {
			ListNode pa = new ListNode(1);
			ListNode partResult= addTwoNumbers(l1.next,pa);
			result.next= addTwoNumbers(partResult,l2.next);
		}
			
		return result;
		
        
    }
	

}
