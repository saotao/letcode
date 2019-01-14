package letcode.answer31_40;

//查找有序数组中的target，如果不存在，返回其应该插入的位置
public class SearchInsertPosition35 {

    public int searchInsert(int[] nums, int target) {
        int lo =0,hi=nums.length-1;
        while (lo<=hi){
            int mid = lo+(hi-lo)/2;
            if(nums[mid]<target) lo=mid+1;
            else if(nums[mid]>target) hi=mid-1;
            else return mid;
            if(lo>hi&&nums[mid]<target){
                return mid+1;
            }else if(lo>hi&&nums[mid]>target) return mid;
        }
        return 0;
    }

    public static void main(String[] args) {
        int []ints = new int[]{1,3,5,6};
        int i = 0;
        System.out.println(new SearchInsertPosition35().searchInsert(ints,i));
    }
}
