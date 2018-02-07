package leetCode;

public class SortColor_75 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] n = {1,2,0};
		sortColors(n);
		for (Integer i: n) {
			System.out.println(i);
		}
		
	}
	public static void sortColors(int[] nums) {
		int len = nums.length;
        if (len<=1) return;
        if (len==2) {
        		if (nums[0]>nums[1]) {
        			int temp = nums[0];
        			nums[0] = nums[1];
        			nums[1] = temp;
        		}
        		return;
        }
      int i=0;
      //number of 0
      int j=0;
      //number of 2
      int k=0;
      while(i+k<len) {
    	  	int temp = 0;
    	  	if (nums[i]==0) {
    	  		temp=nums[i];
    	  		nums[i]=nums[j];
    	  		nums[j]=temp;
    	  		j++;
    	  		i++;
      	}else if (nums[i]==2) {
      		temp = nums[i];
      		nums[i] = nums[len-1-k];
      		nums[len-1-k] = temp;
      		k++;
      	}else i++;
      }
    }

}
