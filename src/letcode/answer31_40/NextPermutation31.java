package answer31_40;


//思路，从后往前找，直到下一个数字n小于上一个数字m，然后在后面的元素中找到比n大的最小元素j，
//交换n,j;然后给后面的数字排序
public class NextPermutation31 {

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public void nextPermutation1(int[] nums) {
        if(nums.length==0) return;
        int i = nums.length - 1;
        boolean hasN = false;

        while (i>0){
            if(nums[i]<=nums[--i]){
                continue;
            }else {
                hasN = true;
                break;
            }
        }
        if(hasN) {
            find(i,nums,i+1,nums.length-1);
            paixu(nums,i+1,nums.length-1);
        }
        else {
            paixu(nums,0,nums.length-1);
        }

    }


    private void find(int n,int[] ints,int start,int end){
        while (start<=end&&ints[n]<ints[start]){
            start++;
        }
        int tem = ints[n];
        ints[n] = ints[start-1];
        ints[start-1] = tem;
    }

    private void paixu(int [] ints,int start,int end){

        for(int i = start+1;i<=end;i++){
            for(int j=i;j>start&&ints[j]<ints[j-1];j--){
                int tem = ints[j];
                ints[j] = ints[j-1];
                ints[j-1] = tem;
            }
        }
    }

    public static void main(String[] args) {



        /*int[] paixu = paixu(new int[]{3, 1, 3, 2, 4}, 1, 4);
        for(int i : paixu){
            System.out.print(i+"  ");
        }
        System.out.println();

        int[] ints = find(0, paixu, 1, 4);
        for(int i : ints){
            System.out.print(i+"  ");
        }*/
        int []nums = new int[]{5,1,1};
        new NextPermutation31().nextPermutation1(nums);
        for(int i : nums){
            System.out.print(i+"  ");
        }


    }
}
