package letcode.answer31_40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//给定不重复数组，查找其中和为target的所有集合，数字可复用，巨佬递归
public class CombinationSum39 {

    //Subsets 子集
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private static void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrackSum(list, new ArrayList<>(), nums, target, 0);
        return list;
    }

    private static void backtrackSum(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
        if(remain < 0) return;
        else if(remain == 0) list.add(new ArrayList<>(tempList));
        else{
            for(int i = start; i < nums.length; i++){
                tempList.add(nums[i]);
                backtrackSum(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> subsets = combinationSum(new int[]{1, 2, 3},10);
        for(List<Integer> list:subsets) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
