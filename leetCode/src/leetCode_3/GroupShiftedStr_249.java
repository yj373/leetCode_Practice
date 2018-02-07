package leetCode_3;
import java.util.*;

public class GroupShiftedStr_249 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println((int)'a');
		System.out.println((int)'z');
		Set<Integer> set= new HashSet<Integer>();
		set.add(1);
		set.add(2);
		set.add(3);
		Iterator<Integer> it= set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}

	}
	 public List<List<String>> groupStrings(String[] strings) {
		 
		 //map中的key直接用每种情况以‘a’开头的string就行了。
		 //Collection 可以直接sort
	        if(strings.length==0) return new ArrayList<List<String>>();
	        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
	        for (int i=0; i<strings.length; i++){
	           int off= strings[i].charAt(0)-'a';
	           String key= "";
	           for(int j=0; j<strings[i].length(); j++) {
	        	   		char c= (char)(strings[i].charAt(j)-off);
	        	   		if(c<'a') c +=26;
	        	   		key+=c;
	           }
	            if(map.containsKey(key)) map.get(key).add(strings[i]);
        			else {
        				List<String> value= new ArrayList<String>();
        				value.add(strings[i]);
        				map.put(key, value);
        			}
	        }
	        List<List<String>> res= new ArrayList<List<String>>();
	        for(String key: map.keySet()) {
	        		List<String> res_= map.get(key);
	        		Collections.sort(res_);
	        		res.add(res_);
	        		
	        }
	        return res;
	        
	    }

}
