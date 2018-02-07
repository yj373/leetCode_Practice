package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrix_54_59 {
	public static void main(String[] args) {
		
	}
	public List<Integer> spiralOrder(int[][] matrix) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		int rows =matrix.length;
		if (matrix==null||rows==0) return res;
		int columns = matrix[0].length;
		if (columns==1) {
			for (int i=0; i<rows; i++) {
				res.add(matrix[i][0]);
			}
			return res;
		}
		if (rows==1) {
			for (int i=0; i<columns; i++) {
				res.add(matrix[0][i]);
			}
			return res;
		}
		for (int i=0; i<4; i++) {
			if (i==0) {
				for (int j=0; j< columns-1; j++) res.add(matrix[0][j]);
			}
			else if (i==1) {
				for (int j=0; j<rows-1; j++) res.add(matrix[j][columns-1]);
			}
			else if (i==2) {
				for (int j=0; j<columns-1; j++) res.add(matrix[rows-1][columns-1-j]);
			}
			else if (i==3) {
				for (int j=0; j<rows-1; j++) res.add(matrix[rows-1-j][0]);
			}
		}
		if (rows-2==0||columns-2==0) return res;
		int[][] newM = new int[rows-2][columns-2];
		for (int i = 0; i<newM.length; i++) {
			for (int j = 0; j<newM[0].length; j++) {
				newM[i][j]= matrix[i+1][j+1];
			}
		}
		List<Integer> res2 = spiralOrder(newM);
		for (Integer i: res2) {
			res.add(i);
		}
		return res; 
    }
	public int[][] generateMatrix(int n) {
		
		if(n<=0) return new int[0][0];
		int[][] res = new int[n][n];
		if (n==1) {
			res[0][0]=1;
			return res;
		}
		if (n==2) {
			res[0][0]=1;
			res[0][1]=2;
			res[1][0]=4;
			res[1][1]=3;
			return res;
		}
		int last = (n-1)*4;
		for (int i=0; i<4; i++) {
			for (int j=0; j<n-1; j++) {
				if (i==0) res[0][j]=1+j+(n-1)*i;
				else if (i==1) res[j][n-1]=1+j+(n-1)*i;
				else if (i==2) res[n-1][n-1-j]=1+j+(n-1)*i;
				else if (i==3) res[n-1-j][0]=1+j+(n-1)*i;
			}
		}
		int[][] recur = generateMatrix(n-2);
		for (int i=1; i<n-1; i++) {
			for (int j=1; j<n-1; j++) {
				res[i][j] = recur[i-1][j-1]+last;
			}
		}
		return res;
        
    }
}
