package leetCode;

public class ValidSudoku_36 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] c = {'.','1', '2'};
		char[] c2 = {'.','1', '2'};
		boolean[] memory = new boolean[10];
		boolean[] memory2 = new boolean[10];
		System.out.println(isValid(c, memory));
		System.out.println(isValid(c2, memory2));

	}
	public boolean isValidSudoku(char[][] board) {
		/*可以利用hashset 的add方法来完成检验
		 * public boolean isValidSudoku(char[][] board) {
    for(int i = 0; i<9; i++){
        HashSet<Character> rows = new HashSet<Character>();
        HashSet<Character> columns = new HashSet<Character>();
        HashSet<Character> cube = new HashSet<Character>();
        for (int j = 0; j < 9;j++){
            if(board[i][j]!='.' && !rows.add(board[i][j]))
                return false;
            if(board[j][i]!='.' && !columns.add(board[j][i]))
                return false;
            int RowIndex = 3*(i/3);
            int ColIndex = 3*(i%3);
            if(board[RowIndex + j/3][ColIndex + j%3]!='.' && !cube.add(board[RowIndex + j/3][ColIndex + j%3]))
                return false;
        }
    }
    return true;
}
		 * */
		boolean[] memory = new boolean[10];
		//check rows
		for (int i = 0; i<9; i++) {
			char[] row = new char[9];
			for (int j = 0; j<9; j++) {
				row[j] = board[i][j];
			}
			resetMemory(memory);
			if (!isValid(row, memory)) return false;
		}
		//check columns
		for (int i = 0; i<9; i++) {
			char[] column = new char[9];
			for (int j = 0; j<9; j++) {
				column[j] = board[j][i];
			}
			resetMemory(memory);
			if (!isValid(column, memory)) return false;
		}
		//check sub-box
		
		for (int i=0; i<9; i++) {
			char[] subBox = new char[9];
			int rowIndex = 3*(i/3);
			int columnIndex = 3*(i%3);
			for (int j=0; j<9; j++) {
				subBox[j] = board[rowIndex+j/3][columnIndex+j%3]; 
			}
			resetMemory(memory);
			if (!isValid(subBox, memory)) return false;
		}
		return true;
        
    }
	private static boolean isValid (char[] ob, boolean[] memory) {
		for (int i=0; i<ob.length; i++) {
			switch (ob[i]) {
			case '.': 
				continue;
			case '1':
				if (memory[1]) return false;
				else memory[1]=true;
				break;
			case '2':
				if (memory[2]) return false;
				else memory[2]=true;
				break;
			case '3':
				if (memory[3]) return false;
				else memory[3]=true;
				break;
			case '4':
				if (memory[4]) return false;
				else memory[4]=true;
				break;
			case '5':
				if (memory[5]) return false;
				else memory[5]=true;
				break;
			case '6':
				if (memory[6]) return false;
				else memory[6]=true;
				break;
			case '7':
				if (memory[7]) return false;
				else memory[7]=true;
				break;
			case '8':
				if (memory[8]) return false;
				else memory[8]=true;
				break;
			case '9':
				if (memory[9]) return false;
				else memory[9]=true;
				break;
			default: break;
		}
	}
		return true;
	}
	private static void resetMemory (boolean[] memory) {
		for (int i=0; i<memory.length; i++) {
			memory[i]=false;
		}
	}
}
