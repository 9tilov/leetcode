package arrays.hard.findMedianSortedArrays;

public class FindMedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        if (length1 > length2) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
            int tmpLength = length1;
            length1 = length2;
            length2 = tmpLength;
        }
        int lo = 0;
        int hi = length1;
        while (lo <= hi) {
            int pivot1 = (lo + hi) / 2;
            int pivot2 = (length1 + length2 + 1) / 2 - pivot1;
            int maxLeft1 = getMin(nums1, pivot1);
            int minRight1 = getMax(nums1, pivot1);
            int maxLeft2 = getMin(nums2, pivot2);
            int minRight2 = getMax(nums2, pivot2);
            if (maxLeft1 <= minRight2 && minRight1 >= maxLeft2) {
                if ((length1 + length2) % 2 == 0) {
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / (double) 2;
                } else {
                    return Math.max(maxLeft1, maxLeft2);
                }
            } else {
                if (maxLeft1 > minRight2) {
                    hi = pivot1;
                } else {
                    lo = pivot1 + 1;
                }
            }
        }
        return -1;
    }

    private int getMin(int[] ar, int pivot) {
        if (pivot <= 0) {
            return Integer.MIN_VALUE;
        }
        return ar[pivot - 1];
    }

    private int getMax(int[] ar, int pivot) {
        if (pivot > ar.length - 1) {
            return Integer.MAX_VALUE;
        }
        return ar[pivot];
    }
}
