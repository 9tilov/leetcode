package arrays.medium.LongestMountain;

public class LongestMountain {

    public int longestMountain(int[] A) {
        if (A.length < 3) {
            return 0;
        }
        int tilt = -5;
        int start = 0;
        int end = 1;
        int max = 0;
        boolean isMount = false;
        while (end < A.length) {
            if (A[end - 1] < A[end]) {
                if (tilt != -5) {
                    if (tilt == -1 || tilt == 0) {
                        if (tilt == -1 && isMount) {
                            max = Math.max(max, end - start);
                        }
                        start = end - 1;
                    }
                }
                isMount = false;
                tilt = 1;
            }
            if (A[end - 1] == A[end]) {
                if (tilt != -5) {
                    if (tilt == -1 && isMount) {
                        max = Math.max(max, end - start);
                    }
                    start = end;
                }
                isMount = false;
                tilt = 0;
            }
            if (A[end - 1] > A[end]) {
                if (tilt != -5) {
                    if (tilt == 1) {
                        isMount = true;
                    } else if (tilt == 0) {
                        start = end;
                    }
                }
                tilt = -1;
            }
            ++end;
        }
        if (isMount) {
            max = Math.max(max, end - start);
        }
        return max;
    }
}
