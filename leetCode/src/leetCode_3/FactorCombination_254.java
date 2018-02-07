package leetCode_3;
import java.util.*;

public class FactorCombination_254 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getFactors(12).toString());

	}
	 public static List<List<Integer>> getFactors(int n) {
		 //DFS
	        List<List<Integer>> res= new ArrayList<List<Integer>>();
	        if(n<=3) return res;
	        helper(2, n, res, new ArrayList<Integer>());
	        return res;
	}
	public static void helper(int start, int end, List<List<Integer>> res, List<Integer> ele){
	     if(end<=1) {
	    	 //注意这里不能直接将ele加到res中去，需要重新创建一个ArrayList来存储ele的值，然后再加入到res
	    	 	if(ele.size()>1) res.add(new ArrayList<Integer>(ele));
	    	 	return;
	     }
	     for(int i=start; i<=end; i++) {
	    	 	if(end%i==0) {
	    	 		ele.add(i);
	    	 		helper(i, end/i, res, ele);
	    	 		ele.remove(ele.size()-1);
	    	 	} 
	     }
	}

}
