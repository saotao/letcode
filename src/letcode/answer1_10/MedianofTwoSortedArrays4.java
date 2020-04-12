package answer1_10;

/**
 * 两个有序数组的中位数
 */
public class MedianofTwoSortedArrays4 {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] nums3 = new int[nums1.length + nums2.length];
        int i = 0, j = 0, count = 0;
        /*

        for(int i=0;i<nums1.length;i++){
            nums3[i] = nums1[i];
        }
        for(int i = 0;i<nums2.length;i++){
            nums3[nums1.length+i] = nums2[i];
        }
        Arrays.sort(nums3);
        if(nums3.length%2 == 1){
            return nums3[nums3.length/2];
        }else
            return (nums3[nums3.length/2]+nums3[nums3.length/2+1])/2;*/
        while (i < nums1.length || j < nums2.length) {
            if (i >= nums1.length) {
                nums3[count++] = nums2[j++];
                continue;
            }
            if (j >= nums2.length) {
                nums3[count++] = nums1[i++];
                continue;
            }
            if (nums1[i] < nums2[j]) nums3[count++] = nums1[i++];
            else nums3[count++] = nums2[j++];
        }

        if (nums3.length % 2 == 1) {
            return nums3[nums3.length / 2];
        } else
            return (nums3[nums3.length / 2] * 1.0 + nums3[nums3.length / 2 - 1]) / 2;
    }

    public double findMedianSortedArraysAnswer(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A;
            A = B;
            B = temp;
            int tmp = m;
            m = n;
            n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j - 1] > A[i]) {
                iMin = i + 1; // i is too small
            } else if (i > iMin && A[i - 1] > B[j]) {
                iMax = i - 1; // i is too big
            } else { // i is perfect
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = B[j - 1];
                } else if (j == 0) {
                    maxLeft = A[i - 1];
                } else {
                    maxLeft = Math.max(A[i - 1], B[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }

                int minRight = 0;
                if (i == m) {
                    minRight = B[j];
                } else if (j == n) {
                    minRight = A[i];
                } else {
                    minRight = Math.min(B[j], A[i]);
                }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1, 3, 4}, new int[]{2}));
    }


}
