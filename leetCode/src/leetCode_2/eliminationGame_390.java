package leetCode_2;

import java.util.Stack;

public class eliminationGame_390 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lastRemaining(9));

	}
	public static int lastRemaining(int n) {
			//这种办法的时间为O(n)
//		if(n==1||n==2) return n;
//		Stack<Integer> remove = new Stack<Integer>();
//		Stack<Integer> res_1 = new Stack<Integer>();
//		Stack<Integer> res_2 = new Stack<Integer>();
//		boolean flag=false;
//		for(int i=1; i<=n; i++) {
//			if(flag) res_1.push(i);
//			else remove.push(i);
//			flag=!flag;
//		}
//		while(res_1.size()+res_2.size()!=1) {
//			if(res_1.size()==0) {
//				flag=false;
//				while(res_2.size()!=0) {
//					if(flag) res_1.push(res_2.pop());
//					else remove.push(res_2.pop());
//					flag=!flag;
//				}
//				
//			}else {
//				flag=false;
//				while(res_1.size()!=0) {
//					if(flag) res_2.push(res_1.pop());
//					else remove.push(res_1.pop());
//					flag=!flag;
//				}
//				
//			}
//		}
//		if(res_1.size()==1) return res_1.pop();
//		else return res_2.pop();
		
		//时间为O(log(n))的办法
		int remaining =n;
		int head = 1;
		int step = 1;
		boolean fromLeft=true; 
		while(remaining>1) {
			if(fromLeft||remaining%2==1) head=head+step;
			remaining = remaining/2;
			step =step*2;
			fromLeft=!fromLeft;
		}
		return head;
        
	}

}
