package answer11_20;


/*短板问题*/
public class ContainerWithMostWater11 {

    public int maxArea(int[] height) {
        int maxArea = 0;

        if(height.length<2) return 0;

        for(int i=0;i<height.length;i++){
            for(int j=i+1;j<height.length;j++){
                int area = Math.min(height[j],height[i])*(j-i);
                maxArea = maxArea>area?maxArea:area;
            }
        }
        return maxArea;
    }

    public int maxAreaTwoPointer(int[] height) {
        int maxArea = 0;

        if(height.length<2) return 0;
        int x = 0,y=height.length-1;

        while (x<y){
            int area = Math.min(height[x],height[y])*(y-x);
            maxArea = maxArea>area?maxArea:area;
            if(height[x]<height[y]) x++;
            else y--;
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] in = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(new ContainerWithMostWater11().maxArea(in));
        System.out.println(new ContainerWithMostWater11().maxAreaTwoPointer(in));
    }
}
