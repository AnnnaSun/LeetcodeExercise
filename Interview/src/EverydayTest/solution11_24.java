package src.EverydayTest;

public class solution11_24 {
    public static int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int leftstart=0; int rightstart =0;
        int res = 0;
        for (; leftstart<nums.length && rightstart<nums.length; ){
            int count=0;
            while(nums[leftstart]>=left && nums[leftstart]<=right && nums[rightstart]<=right &&nums[rightstart]>=left){
                count = rightstart-leftstart+1;
                rightstart++;
            }
            if (nums[leftstart]<left) leftstart++;
            else if (nums[rightstart]>right) {
                rightstart++;
                leftstart = rightstart;
            }
            if(count%2==1){
                res= res+(1+count)/2*count;
            }else {
                res = res + (1 + count) * (count / 2);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        numSubarrayBoundedMax(new int[]{2,1,4,3}, 2, 3);
    }
}
