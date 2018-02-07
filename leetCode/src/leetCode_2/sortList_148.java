package leetCode_2;

import java.util.ArrayList;
import java.util.Arrays;

public class sortList_148 {
	public static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(2);
		head.next=new ListNode(1);
		head = sortList(head);
		while(head!=null) {
			System.out.println(head.val);
		}
		

	}
	public static ListNode sortList(ListNode head) {
		if(head==null||head.next==null) {
			return head;
		} 
		ListNode prev = null;
		ListNode slow = head;
		ListNode fast = head;
		//find the half point of the list
		while(fast!=null&&fast.next!=null) {
			prev=slow;
			slow=slow.next;
			fast=fast.next.next;
		}
		prev.next=null;
		//sort both halves
		ListNode l1 = sortList(head);
		ListNode l2 = sortList(slow);
		//merge the two halves
		return merge(l1,l2);
        
    }
	private static ListNode merge(ListNode l1, ListNode l2) {
		if(l1==null) return l2;
		if(l2==null) return l1;
		if(l1.val<=l2.val) {
			ListNode head = new ListNode(l1.val);
			head.next= merge(l1.next,l2);
			return head;
		}else {
			ListNode head = new ListNode(l2.val);
			head.next= merge(l1, l2.next);
			return head;
		}
		
	}

}
