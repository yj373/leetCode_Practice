package leetCode_3;

public class DugeonGame_174 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] d = {{0}};
		System.out.println(calculateMinimumHP(d));

	}
	public static int calculateMinimumHP(int[][] dungeon) {
		if(dungeon==null||dungeon.length==0) return 0;
		int m = dungeon.length;
		int n = dungeon[0].length;
		int[][] mem = new int[m][n];
		//反着来：确定最后的体力值为1，逆推在起点处最小的体力值
		mem[m-1][n-1]=Math.max(1, 1-dungeon[m-1][n-1]);
		for(int i=m-2; i>=0; i--) {
			mem[i][n-1]=Math.max(1, mem[i+1][n-1]-dungeon[i][n-1]);
		}
		for(int i=n-2; i>=0; i--) {
			mem[m-1][i]=Math.max(1, mem[m-1][i+1]-dungeon[m-1][i]);
		}
		for(int i=m-2; i>=0; i--) {
			for(int j=n-2; j>=0; j--) {
				int down= Math.max(1, mem[i+1][j]-dungeon[i][j]);
				int right= Math.max(1, mem[i][j+1]-dungeon[i][j]);
				mem[i][j]= Math.min(down, right);
			}
		}
		return mem[0][0];
	        
	}

}
