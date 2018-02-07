package leetCode_2;

import java.util.Arrays;
import java.util.HashMap;

public class findDifference_389 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public char findTheDifference(String s, String t) {
		if(s.length()==0||s==null) return t.charAt(0);
		HashMap<Character, Integer> sMap = new HashMap<Character, Integer>();
		char[] sChar = s.toCharArray();
		for(char c: sChar) {
			if(sMap.containsKey(c)) {
				int val = sMap.get(c);
				sMap.put(c, val+1);
			}else sMap.put(c, 1);
		}
		char[] tChar = t.toCharArray();
		for(char c: tChar) {
			if(!sMap.containsKey(c)) return c;
			int val = sMap.get(c);
			if(val==0) return c;
			else sMap.put(c,val-1);
		}
		return '0';
	        
	}

}
