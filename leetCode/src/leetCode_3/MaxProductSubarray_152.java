package leetCode_3;


public class MaxProductSubarray_152 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int maxProduct(int[] nums) {
		//Kadane's Algorithm
		if(nums==null||nums.length==0) return 0;
		int len=nums.length;
		int maxHere=nums[0];//record the maximal product ended here
		int minHere=nums[0];//record the minimal product ended here(negative * negative=positive)
		int result=nums[0];//record the maximal product
		for(int i=1; i<len; i++) {
			int temp=maxHere;
			maxHere= Math.max(Math.max(maxHere*nums[i], minHere*nums[i]), nums[i]);//根据定义，maxHere＊nums[i]一定是连续的
			minHere= Math.min(Math.min(temp*nums[i], minHere*nums[i]), nums[i]);
			result= Math.max(maxHere, result);
		}
		return result;
		
	        
	}
	
}
