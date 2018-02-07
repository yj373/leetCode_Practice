package leetCode_2;

public class JumpGame2_45 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] n = {2,3,0,1,4};
		System.out.println(jump(n));

	}
	public static int jump(int[] nums) {
//		if(!canJump(nums)) return Integer.MAX_VALUE-1;
//		int len=nums.length;
//		if(len==1) return 0;
//		int maxInd=nums[0];
//		if(nums[0]>=len-1) return 1;
//		int steps=0;
//		for(int i=1; i<=nums[0]; i++) {
//			int[] can = new int[len-i];
//			for(int j=0; j<can.length; j++) {
//				can[j]=nums[j+i];
//			}
//			int step_=jump(can)+1;
//			if(steps==0) steps=step_;
//			else if(step_<steps) steps=step_;
//		}
//        return steps;
		int len=nums.length;
		if(len==1) return 0;
		int steps=1;
		int[] mem = new int[len];
		mem[0]=0;
		mem[1]=nums[0];
		while(mem[steps]<len-1) {
			steps++;
			int max=nums[0];
			for(int i=mem[steps-2]; i<=mem[steps-1]; i++) {
				if(i+nums[i]>max) max=i+nums[i];
			}
			mem[steps]=max;
		}
		return steps;
    }
	public static boolean canJump(int[]nums) {
		int max=0;
		for (int i=0; i<nums.length; i++) {
			if (i>max) return false;
			max = Math.max(nums[i]+i, max);
		}
		return true;
	}

}
