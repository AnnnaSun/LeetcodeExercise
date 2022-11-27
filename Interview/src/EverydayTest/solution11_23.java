package src.EverydayTest;

public class solution11_23 {
    public int countBalls(int lowLimit, int highLimit) {
        int result = 0;
        int[] resultMap = new int[46];
        for(int i = lowLimit; i <= highLimit; i++) {
            int num = i, index = 0;
            while(num > 0) {
                index += num % 10;
                num = num / 10;
            }
            resultMap[index] += 1;
        }
        for (int r : resultMap) result = Math.max(result, r);
        return result;
    }
}
