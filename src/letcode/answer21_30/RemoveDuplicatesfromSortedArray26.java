package answer21_30;

//有序数组，删除相同的数,返回更新的数组长度
public class RemoveDuplicatesfromSortedArray26 {

    public int removeDuplicates(int[] nums) {

        int count = 0;
        if(nums.length==0) return count;
        int tem = nums[0];
        count++;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=tem){
                tem = nums[i];
                nums[count] = tem;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int [] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        int i = new RemoveDuplicatesfromSortedArray26().removeDuplicates(nums);
        System.out.println(i);
        for(int i1:nums){
            System.out.println(i1);
        }
    }

}
