package leetCode_2;

public class IntersectionOfTwoLinkedList_160 {
	 public class ListNode {
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
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode pointA = headA;
		ListNode pointB = headB;
		while(pointA!=null&&pointB!=null) {
			pointA=pointA.next;
			pointB=pointB.next;
		}
		if(pointA==null&&pointB==null) {
			ListNode pointC=headA;
			ListNode pointD=headB;
			while(pointC!=null&&pointD!=null) {
				if(pointC.val==pointD.val) return pointC;
				pointC=pointC.next;
				pointD=pointD.next;
			}
			return null;
		}else if(pointA==null) {
			ListNode pointC=headA;
			ListNode pointD=headB;
			while(pointB!=null) {
				pointB=pointB.next;
				pointD=pointD.next;
			}
			while(pointC!=null&&pointD!=null) {
				if(pointC.val==pointD.val) return pointC;
				pointC=pointC.next;
				pointD=pointD.next;
			}
			return null;
		}else {
			ListNode pointC=headA;
			ListNode pointD=headB;
			while(pointA!=null) {
				pointA=pointA.next;
				pointC=pointC.next;
			}
			while(pointC!=null&&pointD!=null) {
				if(pointC.val==pointD.val) return pointC;
				pointC=pointC.next;
				pointD=pointD.next;
			}
			return null;
		}
        
    }

}
