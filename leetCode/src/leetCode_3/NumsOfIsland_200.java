package leetCode_3;

public class NumsOfIsland_200 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int numIslands(char[][] grid) {
		if(grid==null) return 0;
		int rows = grid.length;
		int columns = grid[0].length;
		int count=0;
		for(int i=0; i<rows; i++) {
			for(int j=0; j<columns; j++) {
				if(grid[i][j]=='1') {
					DFSMarking(grid, i, j);
					++count;
				}
			}
		}
		return count;
	        
	}
	
	private void DFSMarking(char[][]grid, int i, int j) {
		if(i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]!='1') return;
		grid[i][j]='0';
		DFSMarking(grid, i+1, j);
		DFSMarking(grid, i-1, j);
		DFSMarking(grid, i, j-1);
		DFSMarking(grid, i, j+1);
	}

}
