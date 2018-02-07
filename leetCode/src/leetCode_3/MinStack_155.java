package leetCode_3;

import java.util.ArrayList;
import java.util.Stack;

public class MinStack_155 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	Stack<Integer> min;
	Stack<Integer> stack;
	/** initialize your data structure here. */
	public MinStack_155() {
		min= new Stack<Integer>();
		stack= new Stack<Integer>();
	}
	    
	public void push(int x) {
	    stack.push(x);
	    if(min.isEmpty()) min.push(x);
	    else {
	    		int currentMin= min.peek();
	    		//注意：这里是<=防止出现多个相同最小值的情况
	    		if(x<=currentMin) min.push(x);
	    }
	}
	    
	public void pop() {
	    int p= stack.pop();
	    int currentMin= min.peek();
	    if(p==currentMin) min.pop();
	}
	    
	public int top() {
	    return stack.peek();    
	}
	    
	public int getMin() {
	    return min.peek();    
	}

}
