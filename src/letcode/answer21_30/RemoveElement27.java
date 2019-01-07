package letcode.answer21_30;

public class RemoveElement27 {

    public int removeElement(int[] nums, int val) {
        int count = nums.length;

        int i=0,j=count-1;
        while (i<count){
            if (j>=0&&nums[j]==val){
                j--;
                count--;
                continue;
            }
            if (i<count&&nums[i]!=val){
                i++;
                continue;
            }
            if(i>j||i>=count) break;
            int tem = nums[i];
            nums[i] = nums[j];
            nums[j] = tem;
        }
        return count;
    }
    public int removeElement1(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }


    public static void main(String[] args) {
        int []nums = new int[]{3,2,2,3};
//        int i = new RemoveElement27().removeElement(nums, 3);
        int u2 = new RemoveElement27().removeElement1(nums, 3);
        System.out.println(u2);
    }
}
