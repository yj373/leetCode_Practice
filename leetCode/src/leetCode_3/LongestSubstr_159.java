package leetCode_3;

import java.util.HashMap;

public class LongestSubstr_159 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lengthOfLongestSubstringTwoDistinct("ecek"));

	}
	public static int lengthOfLongestSubstringTwoDistinct(String s) {
		if(s==null||s.length()==0) return 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int st=0;
		int en=0;
		int maxLength=0;
		while(en<s.length()) {
			if(map.size()<=2) {
				char c = s.charAt(en);
				int val = en;
				map.put(c, val);
				en++;
			}else {
				int leftMost=s.length();
				for(Integer i:map.values()) {
					if(i<leftMost) leftMost=i;
				}
				char c_ = s.charAt(leftMost);
				map.remove(c_);
				st=leftMost+1;
			}
			if(map.size()<=2) maxLength=Math.max(maxLength, en-st);
			else maxLength=Math.max(maxLength, en-st-1);
			
		}
		return maxLength;
		
	        
	}

}
