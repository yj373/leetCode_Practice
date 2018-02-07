package leetCode;

public class RomanInteger_12_13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(intToRoman(1801));

	}
	public static int romanToInt(String s) {
		/*注意罗马数字转换为阿拉伯数字的算法在：从右往左大加小减
		 * */
		int length = s.length();
		int result = 0;
		int lastDigit = 0;
		char[] roman = s.toCharArray();
		for (int i = length-1; i>=0; i--) {
			int digit = charToInt(roman[i]);
			if (digit>=lastDigit) result = result +digit;
			else result = result-digit;
			lastDigit = digit;
		}
		return result;
	        
	}
	private static int charToInt(char r) {
		switch (r) {
		case 'I': 
			return 1;	
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		default: 
			return 0;
		
		}
	}
	public static String intToRoman(int num) {
		String[][] table = new String [][] {
			{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
			{"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
			{"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
			{"", "M", "MM", "MMM"}
		};
		String result = "";
		int thousand = num/1000;
		result = result.concat(table[3][thousand]);
		int hundred  = (num%1000)/100;
		result = result.concat(table[2][hundred]);
		int tens = (num%100)/10;
		result = result.concat(table[1][tens]);
		int ones = num%10;
		result = result.concat(table[0][ones]);
		
		return result;
	        
	}

}
