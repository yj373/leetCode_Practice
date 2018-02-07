package leetCode_2;

import java.util.ArrayList;
import java.util.List;

public class BBBstock3_123 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] pr = {1,2,4,2,5,7,2,4,9,0};
		System.out.println(maxProfit(pr));

	}
	public static int maxProfit(int[] prices) {
		/*不能用这种方法
		 * 原因：｛1，2，4，2，5，7，2，4，9，0｝
		 * 应该选（1，7）和（2，9）
		 * */
		
		
//		int len = prices.length;
//		List<Integer> profit = new ArrayList<Integer>();
//		if(len==0||len==1) return 0;
//		int buy=0;
//		int sell =buy+1;
//		while(buy<len-1&&sell<len) {
//			while(prices[buy+1]<=prices[buy]) {
//				buy++;
//				if(buy==len-1) break;
//			}
//			if(buy==len-1) break;
//			sell=buy+1;
//			if(sell==len-1) {
//				profit.add(prices[sell]-prices[buy]);
//				break;
//			} 
//			while(prices[sell+1]>=prices[sell]) {
//				sell++;
//				if(sell==len-1) {
//					profit.add(prices[sell]-prices[buy]);
//					break;
//				} 
//			}
//			if(sell==len-1) break;
//			profit.add(prices[sell]-prices[buy]);
//			buy=sell+1;
//			
//		}
//		if(profit.size()==0) return 0;
//		if(profit.size()==1) return profit.get(0);
//        if(profit.size()==2) return profit.get(0)+profit.get(1);
//		int trans1=Math.max(profit.get(0), profit.get(1));
//		int trans2=Math.min(profit.get(0), profit.get(1));
//		for(Integer i: profit) {
//			if(i>=trans1) {
//				trans2=trans1;
//				trans1=i;
//			}
//		}
//		return trans1+trans2;
		 int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE;
	        int release1 = 0, release2 = 0;
	        for(int i:prices){                              // Assume we only have 0 money at first
	            release2 = Math.max(release2, hold2+i);     // The maximum if we've just sold 2nd stock so far.（不卖， 卖）
	            hold2    = Math.max(hold2,    release1-i);  // The maximum if we've just buy  2nd stock so far.（不买， 买）
	            release1 = Math.max(release1, hold1+i);     // The maximum if we've just sold 1nd stock so far.（不卖， 卖）
	            hold1    = Math.max(hold1,    -i);          // The maximum if we've just buy  1st stock so far.（不买， 买） 
	        }
	        return release2; ///Since release1 is initiated as 0, so release2 will always higher than release1.
        
    }

}
