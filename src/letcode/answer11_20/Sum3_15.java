package answer11_20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*三个数和为0*/
public class Sum3_15 {


    //暴力，不能有重复的，❌
    public List<List<Integer>> threeSumForce(int[] nums) {
        int target = 0;
        if(nums.length<3) return null;
        List<List<Integer>> results = new ArrayList<>();
       // Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            for(int j= i+1;j<nums.length-1;j++){

                for(int k = j+1;k<nums.length;k++){
                    List<Integer> list = new ArrayList<>();
                    if(nums[i]+nums[j]+nums[k]==0){
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                    }
                    if(list.size()>0){
                        results.add(list);
                    }
                }
            }
        }

        return results;

    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i + 2 < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {              // skip same result
                continue;
            }
            int j = i + 1, k = nums.length - 1;
            int target = -nums[i];
            while (j < k) {
                if (nums[j] + nums[k] == target) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;  // skip same result
                    while (j < k && nums[k] == nums[k + 1]) k--;  // skip same result---两个数已经定了，所以可以排除重复的值
                } else if (nums[j] + nums[k] > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return res;
    }

    //背过
    public List<List<Integer>> sum3333(int[] ints){
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(ints);
        for(int i=0;i<ints.length-2;i++){
            if(i>0&&ints[i]==ints[i-1]){//因为已经取过一次该值，并且获得或者未获得答案，因此可以过滤该值
                continue;
            }
            int j=i+1;
            int k=ints.length-1;
            int target = -ints[i];
            while (j<k){
                if(ints[j]+ints[k]==target){
                    results.add(Arrays.asList(ints[i],ints[j],ints[k]));
                    j++;
                    k--;
                    while (ints[j]==ints[j-1]&&j<k) j++;
                    while (ints[k]==ints[k+1]&&j<k) k--;
                }else if(ints[j]+ints[k]<target){
                    j++;
                }else {
                    k--;
                }
            }
        }

        return results;
    }

    public static void main(String[] args) {
        List<List<Integer>> results = new Sum3_15().sum3333(new int[]{-1, 0, 1, 2, -1, -4});
    }
}
