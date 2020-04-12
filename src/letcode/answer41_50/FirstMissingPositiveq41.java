package answer41_50;

import java.util.Arrays;

//查找一个数组中未出现的最小正整数
public class FirstMissingPositiveq41 {

    public int firstMissingPositive(int[] A)
    {
        for(int i = 0; i < A.length; i++)
        {
            while(A[i] > 0 && A[i] <= A.length && A[i] != A[A[i] - 1])
                swap(A, i, A[i] - 1);
        }

        for(int i = 0; i < A.length; i++)
        {
            if(A[i] != i + 1)
                return i + 1;
        }
        return A.length + 1;
    }

    private void swap(int[] A, int i, int j)
    {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    //n+log(n)
    public int firstMissingPositive1(int[] nums) {
        Arrays.sort(nums);
        if(nums.length==0||nums[nums.length-1]<=0) return 1;
        int count = 0;
        while (count<nums.length){
            if(nums[count]>0) break;
            count++;
        }
        if(nums[count]>1) return 1;
        else {
            for(count=count+1;count<nums.length;count++){
                if(nums[count]==nums[count-1]) continue;
                if(nums[count]!=nums[count-1]+1){
                    return nums[count-1]+1;
                }
                if((count+1)==nums.length){
                    return nums[count]+1;
                }
            }
            return nums[count-1]+1;
        }
    }

    public static void main(String[] args) {
        int i = new FirstMissingPositiveq41().firstMissingPositive(new int[]{1, 2, 0});
        int i1 = new FirstMissingPositiveq41().firstMissingPositive(new int[]{3,4,-1,1});
        int i2 = new FirstMissingPositiveq41().firstMissingPositive(new int[]{7,8,9,11,12});
        int i3 = new FirstMissingPositiveq41().firstMissingPositive1(new int[]{0,2,2,1,1});
        System.out.println(i);
        System.out.println(i1);
        System.out.println(i2);
        System.out.println(i3);
    }
}
