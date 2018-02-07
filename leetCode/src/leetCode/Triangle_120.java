package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle_120 {
	public static void main(String[] args) {
		ArrayList<Integer> l1 = new ArrayList<Integer>(Arrays.asList(1));
		ArrayList<Integer> l2 = new ArrayList<Integer>(Arrays.asList(2,3));
		ArrayList<List<Integer>> l = new ArrayList<List<Integer>>(Arrays.asList(l1,l2));
		System.out.println(minimumTotal(l));
	}
	public static int minimumTotal(List<List<Integer>> triangle) {
//		int root = triangle.get(0).get(0);
//		if (triangle.size()==1) return root;
//		ArrayList<List<Integer>> left = new ArrayList<List<Integer>>();
//		ArrayList<List<Integer>> right = new ArrayList<List<Integer>>();
//		for (List<Integer> l: triangle) {
//			if (l.size()>1) {
//				List<Integer> eleL = l.subList(0, l.size()-1);
//				List<Integer> eleR = l.subList(1, l.size());
//				left.add(eleL);
//				right.add(eleR);
//			}
//		}
//		
//		int movR = minimumTotal(right);
//		int movL = minimumTotal(left);
//		if (movL>=movR) return root+movR;
//		else return root+ movL;
		int dem = triangle.size();
		int [][] table = new int [dem][dem];
		if (triangle.size()==1) return triangle.get(0).get(0);
		for (int i = 0; i<dem; i++) {
			table[dem-1][i] = triangle.get(dem-1).get(i);
		}
		for (int i = dem-2; i>=0; i--) {
			for (int j=0; j<=i; j++) {
				int root = triangle.get(i).get(j);
				if (table[i+1][j]>=table[i+1][j+1]) {
					table[i][j] = table[i+1][j+1]+root;
				}else table[i][j] = table[i+1][j]+root;
			}
		}
		return table[0][0];
        
    }
}
