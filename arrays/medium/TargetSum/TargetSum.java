package arrays.medium.TargetSum;

public class TargetSum {

    private int countSum = 0;

    public int findTargetSumWays(int[] nums, int S) {
        calculateTargetSum(nums, S, 0, 0);
        return countSum;
    }

    private void calculateTargetSum(int[] nums, int S, int index, int tmpSum) {
        if (tmpSum == S && index == nums.length) {
            ++countSum;
            return;
        }
        if (index >= nums.length) {
            return;
        }
        int num = nums[index];
        calculateTargetSum(nums, S, index + 1, tmpSum + num);
        calculateTargetSum(nums, S, index + 1, tmpSum - num);
    }

}
