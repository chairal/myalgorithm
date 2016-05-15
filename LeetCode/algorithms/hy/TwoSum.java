package Algorithm.LeetCode.algorithms.hy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class TwoSum {

	static int target = 6;
	static int[] nums = {1,2,3,4,5};
	
	List<int[]> result = new ArrayList<int[]>();
	
	List twoSum1(int[] nums, int target){
		if(nums!=null && nums.length > 1){
			for(int i = 0;i < nums.length;i++){
				for(int j=i+1;j < nums.length;j++){
					int temp = nums[i] + nums[j];
					if(temp == target){
						result.add(new int[]{i,j});
					}
				}
			}
		}
		return result;
	}
	
	//int[] nums 中的数必须不一样才能使用此方法
	List twoSum2(int[] nums, int target){
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		if(nums!=null && nums.length > 1){
			for(int i = 0;i < nums.length;i++){
				map.put(nums[i], i);
			}
			
			for(int j = 0;j < nums.length;j++){
				if(map.containsKey(target-nums[j]) && map.get(target-nums[j])!=j){
					int tmp_j = Integer.valueOf(map.get(target-nums[j]));
					if(j<tmp_j){
						result.add(new int[]{j,map.get(target-nums[j])});
					}
				}
			}
			
			//map中的状态
//			Iterator it = map.entrySet().iterator( );
//			while(it.hasNext()){
//				Map.Entry entry = (Entry) it.next();
//				System.out.println("mapkey:"+entry.getKey()+"mapvalue:"+entry.getValue());
//			}
		}
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List show = new TwoSum().twoSum1(TwoSum.nums,TwoSum.target);
		for(int i=0;i<show.size();i++){
			int[] showArr = (int[])show.get(i);
			System.out.print("i:" + showArr[0] + "\t");
			System.out.println("j:" + showArr[1]);
		}
		
		System.out.println("------------------分割线------------------");
		
		List show2 = new TwoSum().twoSum2(TwoSum.nums,TwoSum.target);
		for(int i=0;i<show2.size();i++){
			int[] showArr = (int[])show2.get(i);
			System.out.print("i:" + showArr[0] + "\t");
			System.out.println("j:" + showArr[1]);
		}
	}
}

//Given nums = [2, 7, 11, 15], target = 9,
//
//Because nums[0] + nums[1] = 2 + 7 = 9,
//return [0, 1].