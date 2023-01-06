package src.EverydayTest;

public class solution23_16 {
    public int countEven(int num) {
        int y = num / 10, x = num % 10;
        int res = y * 5, ySum = 0;
        while (y != 0) {
            ySum += y % 10;
            y /= 10;
        }
        if (ySum % 2 == 0) {
            res += x / 2 + 1;
        } else {
            res += (x + 1) / 2;
        }
        return res - 1;
    }

    public int countEven2(int num) {
        int t = 0;
        for (int j = num; j > 0; j /= 10) t += j % 10;
        return t % 2 == 1 ? --num / 2 : num / 2;
    }
}
