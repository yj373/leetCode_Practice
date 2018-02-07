package leetCode_2;

public class MaxSquare_221 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = '0';
		int b = '1';
		System.out.println(a);
		System.out.println(b);

	}
public int maximalSquare(char[][] matrix) {
	if(matrix==null||matrix.length==0) return 0;
	int m = matrix.length;
	int n = matrix[0].length;
	int[][] dp = new int[m][n];
	//dp[i][j] represents the length of the largest square sub-matrix with matrix[i][j] becoming the rightmost and bottom-most 
	//element, 关键在于确定max square中的右下角1的位置（用DP）
	for (int i=0; i<m; i++) dp[i][0]= matrix[i][0]-'0';
	for (int i=0; i<n; i++) dp[0][i]= matrix[0][i]-'0';
	for (int i=1; i<m; i++) {
		for(int j=1; j<n; j++) {
			if(matrix[i][j]=='1') {
				dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]))+1;
			}else dp[i][j]=0;
		}
	}
	int max=0;
	for(int i=0; i<n; i++) {
		for(int j=0; j<m; j++) {
			if(dp[i][j]>max) max=dp[i][j];
		}
	}
	return max*max;
        
    }

}
