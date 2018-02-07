package leetCode_3;

public class HouseRobber_198 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {0,0};
		System.out.println(rob(num));

	}
	public static int rob(int[] nums) {
		if(nums==null||nums.length==0) return 0;
		int len=nums.length;
		int[] mem = new int[len];
		mem[0]=nums[0];
		for(int i=1; i<len; i++) {
			if(i==1) mem[i] = Math.max(nums[0],nums[1]);
			else mem[i]=Math.max(mem[i-1], mem[i-2]+nums[i]);
		}
		return mem[len-1];
        
    }

}
