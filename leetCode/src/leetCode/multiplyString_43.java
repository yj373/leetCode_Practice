package leetCode;

public class multiplyString_43 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public String multiply(String num1, String num2) {
		
		int len_1 = num1.length();
		int len_2 = num2.length();
		int[] res = new int[len_1+len_2];
		for (int i= len_1-1; i>=0; i--) {
			for(int j= len_2-1; j>=0; j--) {
				int mul = (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
				int k1 = i+j;
				int k2 = i+j+1;
				int sum = mul +res[k2];
				res[k1] += sum/10;
				res[k2] = sum%10;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i: res) {
			if(!(sb.length()==0&&i==0)) sb.append(i);
		}
		return sb.length()==0 ? "0" : sb.toString();
    }
	private static String add(String nums1, String nums2) {
		int len_1 = nums1.length();
		int len_2 = nums2.length();
		if (len_1==0) return nums2;
		if (len_2==0) return nums1;
		int a = Integer.parseInt(nums1.substring(len_1-1));
		int b = Integer.parseInt(nums2.substring(len_2-1));
		String res = "";
		res=res.concat(add(nums1.substring(0, len_1-1), nums2.substring(0, len_2-1)));
		String pRes = String.valueOf(a+b);
		if (a+b>=10) {
			res=add(res, "1");
			res = res.concat(pRes.substring(pRes.length()-1));
		}else res = res.concat(pRes.substring(pRes.length()-1));
		return res;
		
	}
}
