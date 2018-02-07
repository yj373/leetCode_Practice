package leetCode_2;

public class ReverseLinkedList_92 {
	public static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		ListNode res = reverseBetween(head, 2, 3);
		System.out.println(res.val);
		while(res.next!=null) {
			res=res.next;
			System.out.println(res.val);
		}

	}
	public static ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode nodeM=findNode(head,m);
		ListNode nodeN=findNode(head,n);
		if(m==n) return head;
		ListNode nodeN_=findNode(head, n+1);
        ListNode _nodeM=findNode(head, m-1);
        nodeN.next=null;
        nodeM=reverseList(nodeM);
        if(_nodeM==head) head.next=nodeM;
        if(_nodeM!=null) _nodeM.next=nodeM;
        ListNode newN=findNode(nodeM,n-m+1);
        newN.next=nodeN_;
        if(m!=1)return head;
        else return nodeN;
        
    }
	private static ListNode findNode(ListNode head, int m) {
		if(m==0||head==null) return null;
		if(m==1) return head;
		ListNode res = head.next;
		m--;
		while(m>1) {
			res=res.next;
			if(res==null) return null;
			m--;
		}
		return res;
		
	}
	 public static ListNode reverseList(ListNode head) {
	        if(head==null||head.next==null) return head;
	        ListNode next = head.next;
	        ListNode res = reverseList(next);
	        next.next=head;
	        head.next=null;
	        return res;
	        
	    }

}
