package com.interview.graph.dfs;
	
import java.util.*;

public class TargetSum {


	public int findTargetSumWays2(int[] nums, int target) {
		Map<Integer, Integer> dp = new HashMap();
		dp.put(0, 1);
		for (int num : nums) {
			Map<Integer, Integer> dp2 = new HashMap();
			for (int tempSum : dp.keySet()) {
				int key1 = tempSum + num;
				dp2.put(key1, dp2.getOrDefault(key1, 0) + dp.get(tempSum));
				int key2 = tempSum - num;
				dp2.put(key2, dp2.getOrDefault(key2, 0) + dp.get(tempSum));
			}
			dp = dp2;
		}
		return dp.getOrDefault(target, 0);
	}
	public int findTargetSumWays(int[] nums, int S) {
		if (nums.length == 0)
			return 0;
		Map<Integer, Integer> prev = new HashMap<Integer, Integer>();
		
		Map<Integer, Integer> cur;
		for (int i = 0; i < nums.length; i++) {
			// for nums[0]
			if (i == 0) {
				prev.put(nums[0], 1);
				if (!prev.containsKey(-nums[0])) {
					prev.put(-nums[0], 1);
				} else {
					prev.put(-nums[0], 2); // if nums[0] is 0.
				}
			} else {
				cur = new HashMap<Integer, Integer>();
				for (Map.Entry<Integer, Integer> entry : prev.entrySet()) {
					int sumSoFar = entry.getKey();
					int count = entry.getValue();
					// add num[i]
					if (!cur.containsKey(sumSoFar + nums[i])) {
						cur.put(sumSoFar + nums[i], count);
					} else {
						cur.put(sumSoFar + nums[i], cur.get(sumSoFar + nums[i]) + count);
					}
					// subtract num[i]
					if (!cur.containsKey(sumSoFar - nums[i])) {
						cur.put(sumSoFar - nums[i], count);
					} else {
						cur.put(sumSoFar - nums[i], cur.get(sumSoFar - nums[i]) + count);
					}
				}
				prev = cur;
			}
		}
		return prev.containsKey(S) ? prev.get(S) : 0;
	}
}