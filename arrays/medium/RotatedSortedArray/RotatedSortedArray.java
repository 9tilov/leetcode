package arrays.medium.RotatedSortedArray;

public class RotatedSortedArray {

    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            if (nums[0] == target) {
                return 0;
            } else {
                return -1;
            }
        }
        int pivotInd = findPivot(nums);
        if (pivotInd == 0) {
            return binarySearch(nums, 0, nums.length - 1, target);
        }
        int min1 = nums[0];
        int max1 = nums[pivotInd -1];
        int left;
        int right;
        if (target >= min1 && target <= max1) {
            left = 0;
            right = pivotInd - 1;
        } else {
            left = pivotInd;
            right = nums.length - 1;

        }
        return binarySearch(nums, left, right, target);
    }

    private int findPivot(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private int binarySearch(int[] nums, int leftInd, int rightInd, int target) {
        while (leftInd <= rightInd) {
            int mid = (leftInd + rightInd) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            if (target > nums[mid]) {
                leftInd = mid + 1;
            } else {
                rightInd = mid - 1;
            }
        }
        return -1;
    }
}
