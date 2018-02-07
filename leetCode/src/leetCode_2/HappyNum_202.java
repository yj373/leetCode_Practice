package leetCode_2;

import java.util.HashSet;

public class HappyNum_202 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public boolean isHappy(int n) {
		char[] digits = String.valueOf(n).toCharArray();
		HashSet<Integer> mem = new HashSet<Integer>();
		int res=0;
		for(char c:digits) {
			res+=(c-'0')*(c-'0');
		}
		while(res!=1&&!mem.contains(res)) {
			mem.add(res);
			char[] digits_ = String.valueOf(res).toCharArray();
			int sum=0;
			for(char c:digits_) {
				sum+=(c-'0')*(c-'0');
			}
			res=sum;
		}
		if(res==1)return true;
		else return false;
	        
	}

}
