package leetCode_3;

import java.util.HashMap;
import java.util.List;

public class ShortestWordDistance_243 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = {"a","b"};
		System.out.println(shortestDistance(words,"b","a"));

	}
	public static int shortestDistance(String[] words, String word1, String word2) {
		//再次注意：字符串比较时要用.equal(...)
		//244 answer:
		/*class WordDistance {
    HashMap<String, List<Integer>> wordsList = new HashMap<String, List<Integer>>();

    public WordDistance(String[] words) {
        for(int i=0; i<words.length; i++){
            String key= words[i];
            if(wordsList.containsKey(key)) wordsList.get(key).add(i);
            else{
                List<Integer> val= new ArrayList<Integer>();
                val.add(i);
                wordsList.put(key, val);
            }
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> i1= wordsList.get(word1);
        List<Integer> i2= wordsList.get(word2);
        int res= Integer.MAX_VALUE;
        for(int i=0, j=0; i<i1.size()&&j<i2.size();){
            int index1= i1.get(i);
            int index2= i2.get(j);
            if(index1<index2){
                res= Math.min(res, index2-index1);
                i++;
            }else{
                res= Math.min(res, index1-index2);
                j++;
            }
        }
        return res;
    }
}
		 * */
		int ind_1=-1;
		int ind_2=-1;
		int dis=Integer.MAX_VALUE;
		for(int i=0; i<words.length; i++) {
			if(words[i].equals(word1)) ind_1=i;
			if(words[i].equals(word2)) ind_2=i;
			if(ind_1!=-1&&ind_2!=-1) dis = Math.min(dis, Math.abs(ind_1-ind_2));
		}
		HashMap<String, List<Integer>> map= new HashMap<String, List<Integer>>();
		return dis;
	        
	 }

}
