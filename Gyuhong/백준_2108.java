import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int nums[] = new int[N];
		
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		System.out.println(getAverage(nums));
		System.out.println(getMiddleNumber(nums));
		System.out.println(getMode(nums));
		System.out.println(getRange(nums));
	}
	
	
	static int getAverage(int[] nums) {
		int sum = 0;
		int aver;
		
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		
		aver = (int) Math.round((double) sum / nums.length);
		
		return aver;
	}
	
	static int getMiddleNumber(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length/2];
	}
	
	static int getMode(int[] nums) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < nums.length; i++) {
			map.computeIfPresent(nums[i], (k,v)->v+1);
			map.putIfAbsent(nums[i], 1);
		}
		
		int max=0;
		for(Integer key: map.keySet()) {
			max = Math.max(map.get(key), max);
		}
		
		List<Integer> list = new LinkedList<Integer>(); 
		for(Integer key: map.keySet()) {
			if(map.get(key) == max) list.add(key);
		}
		
		if(list.size() == 1) {
			return list.get(0);
		}
		
		Collections.sort(list);
		return list.get(1);
	}
	
	static int getRange(int[] nums) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < nums.length; i++) {
			min = Math.min(min, nums[i]);
			max = Math.max(max, nums[i]);
		}
		return max - min;
	}
}

