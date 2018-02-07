package leetCode_2;

import java.util.HashMap;
import java.util.LinkedList;

public class LRUcache_146 {
	/*doubled linkedlist关键在于编写DL的加点，去点， 移点和取尾四个方法
	 * */
	private HashMap<Integer, DLinkedNode> 
	cache = new HashMap<Integer, DLinkedNode>();
	private int count;
	private int capacity;
	private DLinkedNode head, tail;
	
	private void addNode(DLinkedNode node){
		node.pre = head;
		node.post = head.post;
		
		head.post.pre = node;
		head.post = node;
	}
	private void removeNode(DLinkedNode node){
		DLinkedNode pre = node.pre;
		DLinkedNode post = node.post;
		
		pre.post = post;
		post.pre = pre;
	}


	private void moveToHead(DLinkedNode node){
		this.removeNode(node);
		this.addNode(node);
	}
	private DLinkedNode popTail(){
		DLinkedNode res = tail.pre;
		this.removeNode(res);
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public LRUcache_146 (int capacity) {
		this.count = 0;
		this.capacity = capacity;

		head = new DLinkedNode();
		head.pre = null;
		
		tail = new DLinkedNode();
		tail.post = null;
		
		head.post = tail;
		tail.pre = head;
	}
	    
	public int get(int key) {
	    
		DLinkedNode node = cache.get(key);
		if(node == null){
			return -1; // should raise exception here.
		}
		
		// move the accessed node to the head;
		this.moveToHead(node);
		
		return node.value;
	}

	    
	public void put(int key, int value) {
		DLinkedNode node = cache.get(key);
		
		if(node == null){
			
			DLinkedNode newNode = new DLinkedNode();
			newNode.key = key;
			newNode.value = value;
			
			this.cache.put(key, newNode);
			this.addNode(newNode);
			
			++count;
			
			if(count > capacity){
				// pop the tail
				DLinkedNode tail = this.popTail();
				this.cache.remove(tail.key);
				--count;
			}
		}else{
			// update the value.
			node.value = value;
			this.moveToHead(node);
		}
	}
	 class DLinkedNode {
			int key;
			int value;
			DLinkedNode pre;
			DLinkedNode post;
		}

}
