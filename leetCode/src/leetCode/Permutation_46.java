package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation_46 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,1};
		System.out.println(permuteUnique(nums));

	}
	public static List<List<Integer>> permute(int[] nums) {
		if (nums.length==0) return new ArrayList<List<Integer>>();
		ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
		if (nums.length==1) {
			ArrayList<Integer> l = new ArrayList<Integer>();
			l.add(nums[0]);
			res.add(l);
			return res;
		}
		for (int i=0; i<nums.length; i++) {

			int temp = nums[0];
			nums[0] = nums[i];
			nums[i] = temp;
			int[] newNums = new int[nums.length-1];
			for (int j= 0; j<newNums.length; j++) {
				newNums[j] = nums[j+1];
			}
			for (List<Integer> l: permute(newNums)) {
				l.add(0, nums[0]);
				res.add(l);
			}

			temp = nums[0];
			nums[0] = nums[i];
			nums[i] = temp;
		}
		return res;
	        
	}
	public static List<List<Integer>> permuteUnique(int[] nums) {
		if (nums.length==0) return new ArrayList<List<Integer>>();
		ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		boolean flag = isSame(nums);
		if (flag) {
			List<Integer> list = new ArrayList<Integer>();
			for (int i=0; i<nums.length; i++) {
				list.add(nums[i]);
			}
			res.add(list);
			return res;
		}
		int i=0;
		while (i<nums.length) {
			int temp = nums[0];
			nums[0] = nums[i];
			nums[i] = temp;
			int[] newNums = new int[nums.length-1];
			for (int j= 0; j<newNums.length; j++) {
				newNums[j] = nums[j+1];
			}
			for (List<Integer> l: permuteUnique(newNums)) {
				l.add(0, nums[0]);
				res.add(l);
			}

			temp = nums[0];
			nums[0] = nums[i];
			nums[i] = temp;
			for (int j=i; j<nums.length; j++) {
				if (nums[j]==nums[i]) {
					i=j;
				}else break;
			}
			i++;
		}
		return res;    
	}
	private static boolean isSame (int[] numbers) {
		boolean flag = true;
		int target = numbers[0];
		int i=0;
		while (flag&&i<numbers.length) {
			if (numbers[i]!=target) {
				flag=false;
			}
			i++;
		}
		return flag;
	}
	

}
