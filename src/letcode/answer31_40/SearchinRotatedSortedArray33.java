package letcode.answer31_40;

//在有拐点的上升数组中查找target，时间复杂度必须为O(logN)
public class SearchinRotatedSortedArray33 {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end){
            int mid = (start + end) / 2;
            if (nums[mid] == target)
                return mid;

            if (nums[start] <= nums[mid]){
                if (target < nums[mid] && target >= nums[start])
                    end = mid - 1;
                else
                    start = mid + 1;
            }

            if (nums[mid] <= nums[end]){
                if (target > nums[mid] && target <= nums[end])
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int []ints = new int[]{4,5,6,7,0,1,2};
        int ints1 = new SearchinRotatedSortedArray33().search(ints, 4);

    }
}
