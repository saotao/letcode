package answer11_20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*三个数相加，最接近target，的和*/
public class Sum3Closest_16 {

    public int threeSumClosest(int[] nums, int target) {
        int closeInt = 0;
        int diff = Integer.MAX_VALUE;

        Arrays.sort(nums);
        for (int i = 0; i + 2 < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {              // skip same result
                continue;
            }
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int sum = nums[i]+nums[j]+nums[k];
                int close = Math.abs(target-sum);
                if(close<diff){
                    diff = close;
                    closeInt = sum;
                }
                if (sum>target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return closeInt;
    }

    public static void main(String[] args) {
        System.out.println(new Sum3Closest_16().threeSumClosest(new int[]{1,1,-1,-1,3},1));
    }
}
