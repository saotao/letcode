package letcode.answer31_40;

//找到开始和末尾的两个target，复杂度为logn
public class FindFirstandLastPositionofElementinSortedArray34 {


    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};

        int i = 0, j = nums.length - 1;
        boolean iU = true, jU = true;
        while (i <= j) {
            if (nums[i] == target && iU) {
                result[0] = i;
                iU = false;
            } else if (iU) {
                i++;
            }
            if (nums[j] == target && jU) {
                result[1] = j;
                jU = false;
            } else if (jU) {
                j--;
            }

            if (!iU && !jU) break;
        }
        if (iU && !jU) result[1] = -1;
        if (jU && !iU) result[0] = -1;

        return result;
    }

    //6ms，巨佬
    public int[] searchRange1(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = findFirst(nums, target);
        result[1] = findLast(nums, target);
        return result;
    }

    private int findFirst(int[] nums, int target) {
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] >= target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            if (nums[mid] == target) idx = mid;
        }
        return idx;
    }

    private int findLast(int[] nums, int target) {
        int idx = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            if (nums[mid] == target) idx = mid;
        }
        return idx;
    }

    public static void main(String[] args) {
        int[] ints = new FindFirstandLastPositionofElementinSortedArray34().searchRange1(new int[]{5, 7, 7, 8, 8, 10}, 8);
        for (int i : ints) {
            System.out.print(i + " ");
        }
    }
}
