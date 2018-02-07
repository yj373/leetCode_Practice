package leetCode_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class RandomizedSet_380 {
	//用一个ArrayList来存储数据模拟真实的RandomizedSet, 并用HashMap来存储各元素在ArrayList中的位置。
	// remove的时候用最后一个元素的值覆盖，需要去掉的元素的值，实现位置交换。然后在map中做相应位置的调整
	//用HashMap以及ArrayList.set均为O(1)
	HashMap<Integer, Integer> map;
	ArrayList<Integer> frame;
	Random ran= new Random();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomizedSet_380 rs= new RandomizedSet_380();
		rs.insert(1);
		rs.remove(2);
		rs.insert(2);
		System.out.println(rs.getRandom());
		rs.remove(1);
		rs.insert(2);
		System.out.println(rs.getRandom());
	

	}
	/** Initialize your data structure here. */
    public RandomizedSet_380() {
    		map= new HashMap<Integer, Integer>();
    		frame= new ArrayList<Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
    		if(map.containsKey(val))
		return false;
    		frame.add(val);
    		map.put(val, frame.size()-1);
    		return true;
        
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
    		if(!map.containsKey(val))
		return false;
    		int pos= map.get(val);
    		int frameSize= frame.size();
    		if(pos<frame.size()-1) {
    			int last= frame.get(frameSize-1);
    			frame.set(pos, last);
    			map.put(last, pos);
    		}
    		frame.remove(frameSize-1);
    		map.remove(val);
    		return true;
        
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
    		int frameSize= frame.size();
		return frame.get(ran.nextInt(frameSize));
        
    }

}
