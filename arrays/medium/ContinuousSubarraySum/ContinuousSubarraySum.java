package arrays.medium.ContinuousSubarraySum;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {

    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>() {{
            put(0, -1);
        }};
        int curSum = 0;
        for (int i = 0; i < nums.length; ++i) {
            curSum += nums[i];
            if (k != 0) {
                curSum %= k;
            }
            int index = map.getOrDefault(curSum, -5);
            if (index != -5) {
                if (i - index > 1) {
                    return true;
                }
            } else {
                map.put(curSum, i);
            }
        }
        return false;
    }
}
