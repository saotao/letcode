//Given a collection of numbers that might contain duplicates, return all possible unique permutations. 
//
// Example: 
//
// 
//Input: [1,1,2]
//Output:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//]
// 
// Related Topics Backtracking
package editor.en;

import java.util.*;

public class PermutationsIi {
    public static void main(String[] args) {
        Solution solution = new PermutationsIi().new Solution();
        List<List<Integer>> lists = solution.permuteUnique(new int[]{1, 2, 3, 4});
        lists.forEach(System.out::println);
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

//        public List<List<Integer>> permuteUnique(int[] nums) {
//            List<List<Integer>> res = new ArrayList<List<Integer>>();
//            if (nums == null || nums.length == 0) return res;
//            boolean[] used = new boolean[nums.length];
//            List<Integer> list = new ArrayList<Integer>();
//            Arrays.sort(nums);
//            dfs(nums, used, list, res);
//            return res;
//        }
//
//        public void dfs(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> res) {
//            if (list.size() == nums.length) {
//                res.add(new ArrayList<Integer>(list));
//                return;
//            }
//            for (int i = 0; i < nums.length; i++) {
//                if (used[i]) continue;
//                if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) continue;
//                used[i] = true;
//                list.add(nums[i]);
//                dfs(nums, used, list, res);
//                used[i] = false;
//                list.remove(list.size() - 1);
//            }
//        }

        private List<List<Integer>> result = new ArrayList<>();
        public List<List<Integer>> permuteUnique(int[] nums) {
            backtrack(0,nums.length-1,nums);
            return result;
        }

        private void backtrack(int n, int length, int[] nums) {
            if (n == length){
                List<Integer> te = new ArrayList<Integer>(nums.length);
                for (Integer ttt : nums) te.add(ttt);
                result.add(te);
                return;
            }
            for (int i = n ; i<= length ;i++){
                swap(nums,i,n);
                backtrack(n+1,length,nums);
                swap(nums,i,n);
            }

        }

        private void swap(int[] nums, int i, int n) {
            int temp = nums[i];
            nums[i] = nums[n];
            nums[n] = temp;
        }

//
//
//        class Solution {
//            List<List<Integer>>ans = new ArrayList(1000);
//            public List<List<Integer>> permute(int[] nums) {
//                perm(nums,0,nums.length-1);
//                return ans;
//            }
//
//            void perm(int[] nums,int i,int j)
//            {
//                if(i == j)
//                {
//                    List<Integer> temp = new ArrayList(nums.length);
//                    for(int k = 0;k < nums.length;k++)temp.add(nums[k]);
//                    ans.add(temp);
//                    return;
//                }
//                for(int k = i;k <= j;k++)
//                {
//                    swap(nums,i,k);
//                    perm(nums,i+1,j);
//                    swap(nums,i,k);
//                }
//            }
//
//            void swap(int[] nums,int i,int j)
//            {
//                int temp = nums[i];
//                nums[i] = nums[j];
//                nums[j] = temp;
//            }
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}