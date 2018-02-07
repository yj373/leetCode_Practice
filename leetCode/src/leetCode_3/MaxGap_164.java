
package leetCode_3;

import java.util.Arrays;

public class MaxGap_164 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] n = {3,6,9,1};
		System.out.println(maximumGap(n));

	}
	public static int maximumGap(int[] nums) {
		//bucket sort
		//题目的意思是找sort之后的数组两个相邻数的最大gap
		if(nums==null||nums.length<2) return 0;
		int min=nums[0];
		int max=nums[0];
		for(int i: nums) {
			min=Math.min(min, i);
			max=Math.max(max, i);
		}
		int len = nums.length;
		int gap=(int)Math.ceil((double)(max-min)/(len-1));
	    int[] bucketMin = new int[len-1];
	    int[] bucketMax = new int[len-1];
	    Arrays.fill(bucketMin, Integer.MAX_VALUE);
	    Arrays.fill(bucketMax, Integer.MIN_VALUE);
	    for (int i: nums) {
	    		if(i==min||i==max) continue;
	    		int ind= (i-min)/gap;
	    		bucketMin[ind] = Math.min(bucketMin[ind], i);
	    		bucketMax[ind] = Math.max(bucketMax[ind], i);
	    }
	    int prev = min;
	    int maxG = Integer.MIN_VALUE;
	    for(int i=0; i<len-1; i++) {
	    		if(bucketMin[i]==Integer.MAX_VALUE&&bucketMax[i]==Integer.MIN_VALUE) continue;
	    		maxG= Math.max(maxG, bucketMin[i]-prev);
	    		prev= bucketMax[i];
	    }
	    maxG = Math.max(maxG, max-prev);
	    return maxG;
	}

}
