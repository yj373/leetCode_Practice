package leetCode;

import java.util.List;

public class ReverseInteger_7 {
	public static void main(String[] args) {
		int k= reverse(1534236469);
		System.out.println(k);

	}
	public static int reverse(int x) {
		/*注意对Integer最值的考虑
		 * */
		if(x==0) return 0;
		String s = String.valueOf(x);
		int last =s.length()-1;
		String resString= "";
		while(s.charAt(last)=='0') last--;
		if(s.charAt(0)=='-') resString=resString.concat(String.valueOf('-'));
		while(last>=0) {
			if(s.charAt(last)!='-') {
				resString=resString.concat(String.valueOf(s.charAt(last)));
			}
			
			last--;
		}
		long res= Long.parseLong(resString);
		if(res>Integer.MAX_VALUE||res<Integer.MIN_VALUE) return 0;
		return (int)res;
        
    }
}

