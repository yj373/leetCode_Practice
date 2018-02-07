package leetCode_2;

public class IsSubsequence_392 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isSubsequence("abc", "ahbgdc"));

	}
	public static boolean isSubsequence(String s, String t) {
		if(s==null||t==null) return false;
		int sLen=s.length();
		int tLen=t.length();
		if(tLen<sLen) return false;
		if(sLen==0) return true;
		char first = s.charAt(0);
		char[] tChar = t.toCharArray();
		int index=tLen;
		for(int i=0; i<tLen; i++) {
			if(tChar[i]==first) {
				index=i;
				break;
			}
		}
		if(index>tLen-1) return false;
		if(sLen==1) return true;
		else if(index==tLen-1) return false;
		return isSubsequence(s.substring(1),t.substring(index+1));
	        
	}

}
