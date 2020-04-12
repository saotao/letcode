package answer1_10;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 找出在一个数组中相加等于target的数的数组，该数组含两个数字
 */
public class TwoSum1 {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] nums  = new int[]{1,2,3,4,5,6,7,8,9};
        int target = 7;
        twoSum(nums,target);
    }
}
