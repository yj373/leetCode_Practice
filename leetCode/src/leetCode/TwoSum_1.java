package leetCode;


import java.util.*;

public class TwoSum_1 {

	public static void main(String[] args) {
		int nums3[] = {-2,0,0,2,2};
		List<List<Integer>> result= threeSum(nums3);
		for (List<Integer> indice: result) {
			System.out.println(indice.toString());
		}

	}
	public static int[] twoSum(int[] nums, int target) {
		int[] result= new int[2];
		for (int i=0; i<nums.length; i++) {
			for (int j=i+1; j<nums.length;j++) {
				if(nums[i]+nums[j]==target) {
					result[0]=i;
					result[1]=j;
				}
			}
		}
		return result;
		
	}
	public static List<List<Integer>> threeSum(int[] nums) {
		/*对数组进行排序后，将数组中的数依次作为目标值，寻找threeSum
		 * 注意｛－2，0，0，2，2｝的情况
		 * */
		Arrays.sort(nums);
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		for (int i=0; i<nums.length-2; i++) {
			if(i==0||(i>0 && nums[i]!=nums[i-1])) {
				int sec=i+1;
				int thi=nums.length-1;
				int target=0-nums[i];
				int sum = 0;
				while (sec<thi) {
					sum = nums[sec]+nums[thi];
					if(sum==target) {
						LinkedList<Integer> partRes = new LinkedList<Integer>();
						partRes.add(nums[i]);
						partRes.add(nums[sec]);
						partRes.add(nums[thi]);
						result.add(partRes);
						while(sec<thi&&nums[sec]==nums[sec+1]) sec++;
						while(sec<thi&&nums[thi]==nums[thi-1]) thi--;
						sec++;
						thi--;
					}else if(sum<target) {
						sec++;
					}else thi--;
				}
				
			}
		}
		return result;
	        
	}

}
