package answer31_40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//同39题，每个元素只能用一次
public class CombinationSumII40 {

    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrackSum(list, new ArrayList<>(), nums, target, 0);
        return list;
    }

    private void backtrackSum(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
        if(remain < 0) return;
        else if(remain == 0&&!list.contains(tempList)) {
            list.add(new ArrayList<>(tempList));
        }
        else{
            for(int i = start; i < nums.length; i++){
                tempList.add(nums[i]);
                backtrackSum(list, tempList, nums, remain - nums[i], i+1); // not i + 1 because we can reuse same elements
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new CombinationSumII40().combinationSum2(new int[]{1000,100,200,700,600,100,500}, 800);
//        List<List<Integer>> lists = new CombinationSumII40().combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
        for(List<Integer> list:lists) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
