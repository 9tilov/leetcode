package arrays.medium.SumOfMutatedArrayClosestToTarget;

public class SumOfMutatedArrayClosestToTarget {

    public int findBestValue(int[] arr, int target) {
        int min = 0;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < arr.length; ++i) {
            sum += arr[i];
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        if (sum == target) return max;
        int minDiff = Integer.MAX_VALUE;
        int mid;
        int minResult = 1;
        while (min <= max) {
            sum = 0;
            mid = (max + min) / 2;
            for (int i = 0; i < arr.length; ++i) {
                if (arr[i] > mid) {
                    sum += mid;
                } else {
                    sum += arr[i];
                }
            }

            if (sum > target) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
            if (Math.abs(sum - target) < minDiff || (Math.abs(sum - target) == minDiff && mid < minResult)) {
                minResult = mid;
                minDiff = Math.abs(sum - target);
            }
        }
        return minResult;
    }

}
