package leetCode;

import java.util.HashMap;

public class JumpGame_55 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] n = {2,3,1,1,4};
		System.out.println(canJump(n));
//		HashMap<Integer, Boolean> mem  = new HashMap<Integer, Boolean>();
//		System.out.println(mem.get(1));
	}
	public static boolean canJump(int[] nums) {
		
//		boolean[] memory = new boolean[len];
//		memory[len-1]=true;
//		for (int i=len-2; i>=0; i--) {
//			if (i+nums[i]>=len-1) {
//				memory[i]=true;
//				continue;
//			}
//			for (int j=1; j<=nums[i]; j++) {
//				if (memory[i+j]) memory[i]=true;
//			}
//		}
		
//		int len = nums.length;
//		HashMap<Integer, Boolean> mem  = new HashMap<Integer, Boolean>();
//		for (int i=0; i<len; i++){
//            if (i+nums[i]>=len-1) mem.put(i, true);
//        }
//		if (mem.get(0)!=null) return mem.get(0);
//		for (int i=1; i<=nums[0]; i++) {
//			if (mem.get(i)==null) {
//				int[] newNums = new int[len-i];
//				for (int j =0 ; j<newNums.length; j++) {
//					newNums[j] = nums[i+j];
//				}
//				mem.put(i, canJump(newNums));
//				if(mem.get(i)) return true;
//				
//			}else if (mem.get(i)==true) return true;
//		}
//		return false;
		/*只用计算之前能够到达的最远位置
		 * */
		int max=0;
		for (int i=0; i<nums.length; i++) {
			if (i>max) return false;
			max = Math.max(nums[i]+i, max);
		}
		return true;
		
		
        
    }

}
