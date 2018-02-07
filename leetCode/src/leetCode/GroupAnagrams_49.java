package leetCode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams_49 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}
	public List<List<String>> groupAnagrams(String[] strs) {
		/**利用 hashmap的key来实现对字符串的分类
		 * */
		if (strs== null|| strs.length==0) return new ArrayList<List<String>>();
		HashMap<String, List<String>> map = new HashMap<String, List<String>>();
		for (int i=0; i<strs.length; i++) {
			char[] ele = strs[i].toCharArray();
			Arrays.sort(ele);
			String keyStr = String.valueOf(ele);
			if(!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<String>());
			map.get(keyStr).add(strs[i]);
		}
		return new ArrayList<List<String>>(map.values());
        
    }
//	private static boolean areAnagrams (String str1, String str2) {
//		char[] array_1 = str1.toCharArray();
//		char[] array_2 = str2.toCharArray();
//		int length_1 = array_1.length;
//		int length_2 = array_2.length;
//		if (length_1 != length_2) return false;
//		if (length_1 == 0 && length_2 == 0) return true;
//		boolean result = true;
//		for (int i = 0; i<length_1; i++) {
//			for (int j = 0; j<length_2; j++) {
//				if (array_1[i] == array_2[j]) {
//					result = true;
//					break;
//				}else {
//					result = false;
//				}
//			}
//			if (!result) break;
//		}
//		return result;
//		
//	}

}
