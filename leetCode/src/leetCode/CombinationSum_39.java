package leetCode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum_39 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] candidates = new int[] {1,2,3};
		String s =  combinationSum2(candidates, 3).toString();
		System.out.println(s);

	}
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		if (target<candidates[0]||candidates.length==0||candidates==null) return new ArrayList<List<Integer>>();
		ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
		
		int len = candidates.length;
		for (int i=0; i<len; i++) {
			int newTarget = target-candidates[i];
			if (newTarget == 0) {
				List<Integer> b = new ArrayList<Integer>();
				b.add(candidates[i]);
				result.add(b);
				return result;
			}
			int[] newCandidates = new int[len-i];
			for (int j=0; j<newCandidates.length; j++) {
				newCandidates[j]=candidates[i+j];
			}
			List<List<Integer>> partRes = combinationSum(newCandidates, newTarget);
			if (partRes.size()!=0) {
				for (List<Integer> a:partRes) {
					a.add(candidates[i]);
					result.add(a);
				}
			}
		}
		return result;
    }
	
//	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
//		Arrays.sort(candidates);
//		int max = 0;
//		int len = candidates.length;
//		for (int i=0; i<len; i++) {
//			max= max+ candidates[i];
//		}
//		if (target<candidates[0]||len==0||candidates==null||target>max) {
//			return new ArrayList<List<Integer>>();
//		}
//		ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
//		
//		
//		for (int i=0; i<len; i++) {
//			int newTarget = target-candidates[i];
//			if (newTarget == 0) {
//				List<Integer> b = new ArrayList<Integer>();
//				b.add(candidates[i]);
//				result.add(b);
//				return result;
//			}
//			int[] newCandidates = new int[len-i-1];
//			for (int j=0; j<newCandidates.length; j++) {
//				newCandidates[j]=candidates[i+j+1];
//			}
//			List<List<Integer>> partRes = combinationSum2(newCandidates, newTarget);
//			if (partRes.size()!=0) {
//				for (List<Integer> a:partRes) {
//					a.add(candidates[i]);
//					result.add(a);
//				}
//			}
//		
	public  static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		   List<List<Integer>> list = new LinkedList<List<Integer>>();
		   Arrays.sort(candidates);
		   backtrack(list, new ArrayList<Integer>(), candidates, target, 0);
		   return list;
		}

		private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] cand, int remain, int start) {
		   
		   if(remain < 0) return; /** no solution */
		   else if(remain == 0) list.add(new ArrayList<>(tempList));
		   else{
		      for (int i = start; i < cand.length; i++) {
		         if(i > start && cand[i] == cand[i-1]) continue; /** skip duplicates */
		         tempList.add(cand[i]);
		         backtrack(list, tempList, cand, remain - cand[i], i+1);
		         tempList.remove(tempList.size() - 1);
		      }
		   }
		}

}
