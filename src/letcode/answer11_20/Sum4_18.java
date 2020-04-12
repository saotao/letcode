package answer11_20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*四个数字的和为target ，输出所有的列表*/
public class Sum4_18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for(int i=0;i<nums.length-3;i++){
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            for(int j=i+1;j<nums.length-2;j++){
                if(j!=i+1 && nums[j]==nums[j-1]) continue;
                int m=j+1,n=nums.length-1;

                while (m<n){
                    if(nums[m]+nums[n] == target-nums[i]-nums[j]){
                        result.add(Arrays.asList(nums[i],nums[j],nums[m],nums[n]));
                        m++;
                        n--;
                        while (nums[m]==nums[m-1]&&m<n) m++;
                        while (nums[n]==nums[n+1]&&m<n) n--;
                    }else if(nums[m]+nums[n] < target-nums[i]-nums[j]){
                        m++;
                    }else {
                        n--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new Sum4_18().fourSum(new int[]{0,0,0,0},0);
        List<List<Integer>> lists2 = new Sum4_18().fourSum(new int[]{-3,-2,-1,0,0,1,2,3},0);
        List<List<Integer>> lists3 = new Sum4_18().fourSum(new int[]{-1,0,1,2,-1,-4},-1);
        System.out.println(lists.toString());
        System.out.println(lists2.toString());
        System.out.println(lists3.toString());
    }
}
