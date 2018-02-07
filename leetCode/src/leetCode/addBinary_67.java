package leetCode;

public class addBinary_67 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public String addBinary(String a, String b) {
		int len_a = a.length();
		int len_b = b.length();
		if (len_a==0) return b;
		if (len_b==0) return a;
		String res=addBinary(a.substring(0, len_a-1), b.substring(0, len_b-1));
		char a_ = a.charAt(len_a-1);
		char b_ = b.charAt(len_b-1);
		if (a_=='0'&&b_=='0') {
			res = res.concat("0");
		}else if ((a_=='0'&&b_=='1')||(a_=='1'&&b_=='0')) {
			res = res.concat("1");
		}else {
			res=addBinary(res, "1");
			res=res.concat("0");
		}
		return res;
	        
	}

}
