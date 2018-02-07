package leetCode;

public class LongestPalindromicSubstring_5 {
	private int maxIndex= 0;
	private int maxLength= 1;
	public static void main(String[] args) {
		LongestPalindromicSubstring_5 a = new LongestPalindromicSubstring_5();
		System.out.println(a.longestPalindrome("aba"));
	}
	
	
	public  String longestPalindrome(String s) {
//		if (s.length()<=1) return s;
//		int i = 0;
//		int j = s.length()-1; 
//		if (isPalindrome(s, i, j)) return s;
//		String sub_1 = s.substring(0, s.length()-1);
//		String sub_2 = s.substring(1, s.length());
//		String candidate_1 = longestPalindrome(sub_1);
//		String candidate_2 = longestPalindrome(sub_2);
//		if (candidate_1.length()>=candidate_2.length()) return candidate_1;
//		else return candidate_2;
		
		for (int i = 0; i<s.length(); i++) {
			findPalindrome (s, i, 0);
			findPalindrome (s, i, 1);
		}
		return s.substring(maxIndex, maxIndex+maxLength);
	        
	}
	private void findPalindrome (String s, int begin, int shift) {
		/*找到以每个字符为中心的最大回文字符串，取其中的最大的一个
		 * */
		int left= begin;
		int right= begin +shift;
		while (left>=1 && right<s.length() && s.charAt(left)==s.charAt(right)) {
			if (right-left+1> maxLength) {
				maxLength = right-left+1;
				System.out.println(maxLength);
				maxIndex = left;
				System.out.println(maxIndex);
			}
			left--;
			right++;
		}
		
		
	}

}
