package leetCode_2;

import java.util.HashMap;

public class FirstUniqueChar_387 {
	public int firstUniqChar(String s) {
		HashMap<Character, Integer> mem = new HashMap<Character, Integer>();
		char[] st = s.toCharArray();
		int len=s.length();
		for(int i=0; i<len; i++) {
			if(mem.containsKey(st[i])) mem.put(st[i], -1);
			else mem.put(st[i], i);
		}
		int res=len;
		for(char key: mem.keySet()) {
			int val = mem.get(key);
			if(val!=-1&&val<res) res=val;
		}
		if(res==len) return -1;
		else return res;
        
    }
}
