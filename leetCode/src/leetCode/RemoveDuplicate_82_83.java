package leetCode;

public class RemoveDuplicate_82_83 {
	public static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(2);
		ListNode res = deleteDuplicates2(head);
		System.out.println(res.val);
		while (res.next!=null) {
			res=res.next;
			System.out.println(res.val);
		}
	}
	public ListNode deleteDuplicates(ListNode head) {
		if (head==null||head.next==null) return head;
		head.next=deleteDuplicates(head.next);
		return head.val==head.next.val ? head.next : head;
        
    }
	public static ListNode deleteDuplicates2(ListNode head) {
		 //关键在于三个例子：112；122；12
		 if (head==null||head.next==null) return head;
			boolean flag =true;
			ListNode n = head;
			while(n.next!=null) {
				if (n.next.val!=n.val) {
					n=n.next;
					flag=false;
					break;
				}
				n=n.next;
			}
			if (flag) return null;
	        if (head.val==head.next.val) return deleteDuplicates2(n);
	        head.next = deleteDuplicates2(n);
	        if (head.next==null) return head;
			return head.val==head.next.val ? deleteDuplicates2(n) : head;
	        
	}

}
