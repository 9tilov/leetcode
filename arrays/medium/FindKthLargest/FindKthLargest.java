package arrays.medium.FindKthLargest;

import java.util.PriorityQueue;
import java.util.Queue;

public class FindKthLargest {

    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 1) {
            return nums[0];
        }
        Queue<Integer> q = new PriorityQueue<>(k);
        for (int i = 0; i < nums.length; ++i) {
            if (q.size() < k) {
                q.add(nums[i]);
            } else {
                int curMin = q.peek();
                if (nums[i] > curMin) {
                    q.poll();
                    q.add(nums[i]);
                }
            }
        }
        return q.poll();
    }
}
