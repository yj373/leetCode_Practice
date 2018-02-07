package leetCode;

import java.util.ArrayList;
import java.util.List;

public class MergeIntervels_56 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Interval i_1 = new Interval(1,4);
		Interval i_2 = new Interval(5,6);
		//Interval i_3 = new Interval(0,0);
		//Interval i_4 = new Interval(15,18);
		ArrayList<Interval> is = new ArrayList<Interval>();
		is.add(i_1);
		is.add(i_2);
		//is.add(i_3);
		//is.add(i_4);
		for (Interval i: merge(is)) {
			System.out.println(i.start+","+i.end);
		}
		

	}
	public static class Interval {
		      int start;
		      int end;
		      Interval() { start = 0; end = 0; }
		      Interval(int s, int e) { start = s; end = e; }
		      
		  }
	public static List<Interval> merge(List<Interval> intervals) {
		/*无法识别［1，4］，［5，6］
		 * */
//		List<Interval> res = new ArrayList<Interval>();
//		if (intervals.size()==0) return res;
//		int start = intervals.get(0).start;
//		int end = intervals.get(0).end;
//		for (Interval i: intervals) {
//			if (i.start< start) start= i.start;
//			if (i.end>end) end = i.end;
//		}
//		boolean[] memory = new boolean[end-start+1];
//		int len = memory.length;
//		for (Interval i: intervals) {
//			int s=i.start-start;
//			int e=i.end-start+1;
//			for (int j=s; j<e; j++) {
//				if (!memory[j]) memory[j]=true;
//			}
//		}
//		int k=0;
//		while (k<len) {
//			int s=k;
//			while(memory[k+1]==memory[k]) {
//				if (k+1==len-1) {
//					Interval i = new Interval(s+start, len-1+start);
//					res.add(i);
//					return res;
//				}
//				k++;
//			}
//			int e=k;
//			Interval i = new Interval(s+start, e+start);
//			res.add(i);
//			k++;
//			while(memory[k+1]==memory[k]) k++;
//			k++;
//			if (k==len-1) {
//				Interval i_ = new Interval(k, k);
//				res.add(i_);
//				return res;
//			}
//		}
		if (intervals.size()<=1) return intervals;
		List<Interval> res = new ArrayList<Interval>();
		//注意这种使用comparator来根据start排序的方法
		intervals.sort((i1, i2)->Integer.compare(i1.start, i2.start));
		int start = intervals.get(0).start;
		int end = intervals.get(0).end;
		for (Interval i: intervals) {
			if (i.start<=end) end =Math.max(end, i.end);
			else {
				Interval l = new Interval(start, end);
				res.add(l);
				start=i.start;
				end=i.end;
			}
		}
		res.add(new Interval(start, end));
		return res;
        
    }
}
