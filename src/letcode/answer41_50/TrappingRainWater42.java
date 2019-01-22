package letcode.answer41_50;

//被困水的个数
public class TrappingRainWater42 {

    public int trap(int[] height) {
        if(height.length<2) return 0;

        int [] intsLeft = new int[height.length];
        int [] intsRight = new int[height.length];
        int result = 0;

        intsRight[0] = height[0];
        intsLeft[height.length-1] = height[height.length-1];
        for(int i=1;i<height.length;i++){
            intsRight[i] = height[i]>intsRight[i-1]?height[i]:intsRight[i-1];
        }
        for(int i=height.length-2;i>=0;i--){
            intsLeft[i] = height[i]>intsLeft[i+1]?height[i]:intsLeft[i+1];
        }
        for(int i=0;i<height.length;i++){
            result += ((intsLeft[i]>intsRight[i]?intsRight[i]:intsLeft[i])-height[i])>0?(intsLeft[i]>intsRight[i]?intsRight[i]:intsLeft[i])-height[i]:0;
        }
        return result;
    }

    //brute force n2
    public int trapBrute(int[] height) {
        int ans = 0;
        int size = height.length;
        for (int i = 1; i < size - 1; i++) {
            int max_left = 0, max_right = 0;
            for (int j = i; j >= 0; j--) { //Search the left part for max bar size
                max_left = Math.max(max_left, height[j]);
            }
            for (int j = i; j < size; j++) { //Search the right part for max bar size
                max_right = Math.max(max_right, height[j]);
            }
            ans += Math.min(max_left, max_right) - height[i];
        }
        return ans;
    }

    //two pointer
    int trapTwoP(int[] height)
    {
        int left = 0, right = height.length - 1;
        int ans = 0;
        int left_max = 0, right_max = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if(height[left] >= left_max){
                    left_max = height[left];
                }else{
                    ans += left_max - height[left];
                }
                ++left;
            }
            else {
                if(height[right] >= right_max ) {
                    right_max = height[right];
                } else{
                    ans += (right_max - height[right]);
                }
                --right;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int trap = new TrappingRainWater42().trap(new int[]{2,0,2});
        int trapBrute = new TrappingRainWater42().trapTwoP(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        System.out.println(trap);
        System.out.println(trapBrute);
    }
}
