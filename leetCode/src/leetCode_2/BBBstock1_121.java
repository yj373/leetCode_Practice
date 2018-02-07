package leetCode_2;

public class BBBstock1_121 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int maxProfit(int[] prices) {
		int len=prices.length;
		if(len==0||len==1) return 0;
		int buy=0;
		while(prices[buy+1]<=prices[buy]) {
			 buy++;
           if(buy==len-1) return 0;
		}
		int[] recur = new int[len-buy-1];
		for (int i=0; i<recur.length;i++) {
			recur[i]=prices[buy+i+1];
		}
		
		int max=recur[0];
		for(int i=0; i<recur.length;i++) {
			if(recur[i]>max) max=recur[i];
		}
		int yes=max-prices[buy];
		int no=maxProfit(recur);
		
		return Math.max(yes, no);
	        
	}

}
