class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = m + n;
        return (getKth(nums1, 0, m, nums2, 0, n, (len + 1) / 2) + getKth(nums1, 0, m, nums2, 0, n, (len + 2) / 2)) / 2;
    }
    
    private double getKth(int[] A, int s1, int m, int[] B, int s2, int n, int k) {
        if (m > n) {
            return getKth(B, s2, n, A, s1, m, k);
        }
        if (m == 0) {
            return B[s2 + k - 1];
        }
        if (k == 1) {
            return Math.min(A[s1], B[s2]);
        }
        int i = Math.min(m, k / 2);
        int j = k - i;
        if (A[s1 + i - 1] < B[s2 + j - 1]) {
            return getKth(A, s1 + i, m - i, B, s2, n, k - i);
        } else {
            return getKth(A, s1, m, B, s2 + j, n - j, k - j);
        }
    }
}
