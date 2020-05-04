package EverydayTest;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 */
public class jumpGameDemo {
    public static void main(String[] args){
        System.out.println(steps(new int[]{3,5,7,1,4,2,1,1,1}));
    }
//    public static int steps(int[] nums){
//        int step = 0;
//        int position = nums.length-1;
//        while (position>0){
//            for (int i=0;i<position;i++){
//                if (i+nums[i]>=position){//从直接跳到最后一位的下标开始算起，倒推
//                    position = i;
//                    step++;
//                    break;
//                }
//            }
//        }
//        return step;
//    }

    //better choice
    public static int steps(int[] nums){
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            ////找能跳的最远的
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {////遇到边界，就更新边界，并且步数加一。寻找在两步跳跃范围内可以跳跃的最远距离
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
